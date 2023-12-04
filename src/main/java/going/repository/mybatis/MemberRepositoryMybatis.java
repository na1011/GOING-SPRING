package going.repository.mybatis;

import going.domain.Member;
import going.repository.MemberRepository;
import going.repository.mybatis.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryMybatis implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public String save(Member member) {
        memberMapper.save(member);
        return member.getUserName();
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    @Override
    public int countByEmail(String email) {
        return memberMapper.countByEmail(email);
    }
}
