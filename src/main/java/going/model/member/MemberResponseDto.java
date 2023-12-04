package going.model.member;

import going.domain.Member;
import going.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {

    private String email;
    private String phone;
    private String userName;
    private Role role;

    @Builder
    public MemberResponseDto(String email, String phone, String userName, Role role) {
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.role = role;
    }

    public MemberResponseDto() {
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .phone(phone)
                .userName(userName)
                .role(role)
                .build();
    }
}
