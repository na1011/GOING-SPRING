package going.repository;

import going.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    String save(Member member);

    void update(Member member);

    void deleteByEmail(String email);

    Optional<Member> findByEmail(String email);

    int countByEmail(String email);
}
