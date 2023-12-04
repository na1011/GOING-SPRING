package going.model.member;

import going.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberUpdateDto {

    private String email;
    private String password;
    private String phone;

    public MemberUpdateDto(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .phone(phone)
                .password(password)
                .build();
    }
}
