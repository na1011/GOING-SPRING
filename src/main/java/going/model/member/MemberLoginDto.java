package going.model.member;

import going.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDto {

    private String email;
    private String password;
    private String addr;

    public MemberLoginDto() {
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
