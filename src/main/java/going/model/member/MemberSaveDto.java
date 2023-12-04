package going.model.member;

import going.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

@Getter
@Setter
@ToString
public class MemberSaveDto {

    private String email;
    private String password;
    private String phone;
    private String userName;

    public MemberSaveDto() {
    }

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (!StringUtils.hasLength(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .userName(userName)
                .build();
    }
}
