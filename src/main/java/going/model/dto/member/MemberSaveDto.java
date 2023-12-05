package going.model.dto.member;

import going.model.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveDto {

    private String email;
    private String password;
    private String phone;
    private String userName;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .userName(userName)
                .build();
    }

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (!StringUtils.hasLength(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }
}
