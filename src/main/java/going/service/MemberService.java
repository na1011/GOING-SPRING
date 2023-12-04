package going.service;

import going.domain.Member;
import going.model.member.MemberLoginDto;
import going.model.member.MemberResponseDto;
import going.model.member.MemberSaveDto;
import going.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
        Member findByEmail = memberRepository.findByEmail(params.getEmail()).orElseThrow(() -> new NullPointerException("로그인 실패"));

        return findByEmail.toDto();
    }
}
