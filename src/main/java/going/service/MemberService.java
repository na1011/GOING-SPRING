package going.service;

import going.domain.Member;
import going.model.member.MemberLoginDto;
import going.model.member.MemberResponseDto;
import going.model.member.MemberSaveDto;
import going.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String saveMember(MemberSaveDto params) {

        params.encodingPassword(passwordEncoder);
        Member saveMember = params.toEntity();

        return memberRepository.save(saveMember);
    }

    public MemberResponseDto login(MemberLoginDto params) {
        Member findByEmail = memberRepository.findByEmail(params.getEmail()).orElseThrow(() -> new NullPointerException("잘못된 이메일 주소입니다."));
        String encodedPassword = (findByEmail == null) ? "" : findByEmail.getPassword();

        if ((findByEmail == null) || !passwordEncoder.matches(params.getPassword(), encodedPassword)) {
            return null;
        }

        return findByEmail.toDto();
    }

    public int validateEmail(String email) {
        return memberRepository.countByEmail(email);
    }
}
