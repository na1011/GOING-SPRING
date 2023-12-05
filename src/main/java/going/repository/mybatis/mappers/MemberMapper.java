package going.repository.mybatis.mappers;

import going.model.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);

    void update(Member member);

    void deleteByEmail(String email);

    Optional<Member> findByEmail(String email);

    int countByEmail(String email);
}
