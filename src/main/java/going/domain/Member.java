package going.domain;

import going.model.member.MemberResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private Long memberId;
    private String email;
    private String password;
    private String phone;
    private String userName;
    private Role role;
    private LocalDateTime joinDate;

    @Builder
    public Member(Long memberId, String email, String phone, String userName, String password, Role role, LocalDateTime joinDate) {
        this.memberId = memberId;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.joinDate = joinDate;
    }

    public MemberResponseDto toDto() {
        return MemberResponseDto.builder()
                .email(email)
                .phone(phone)
                .userName(userName)
                .role(role)
                .build();
    }
}
