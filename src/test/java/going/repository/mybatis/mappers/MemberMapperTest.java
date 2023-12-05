package going.repository.mybatis.mappers;

import going.model.domain.Member;
import going.model.dto.member.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper mapper;

    @Test
    void save() {
        Member member = Member.builder()
                .email("test@test.com")
                .phone("01012345678")
                .userName("김여행")
                .password("1234")
                .role(Role.valueOf("ADMIN"))
                .build();

        System.out.println("member = " + member);
        mapper.save(member);

        Member findMember = mapper.findByEmail(member.getEmail()).orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."));

        assertThat(findMember.getUserName()).isEqualTo("김여행");
    }

    @Test
    void update() {
        Member memberModify = Member.builder()
                .email("test@test.com")
                .phone("0000000")
                .password("비밀번호 변경")
                .build();
        mapper.update(memberModify);

        Member findMember = mapper.findByEmail(memberModify.getEmail()).orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."));

        assertThat(findMember.getPassword()).isEqualTo("비밀번호 변경");
    }

    @Test
    void deleteById() {
        mapper.deleteByEmail("test@test.com");

        assertThatThrownBy(() -> mapper.findByEmail("test@test.com").orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."))).isInstanceOf(NullPointerException.class);
    }

}