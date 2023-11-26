package going.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegisterForm {

    private String email;
    private String password;
    private String role;

    public MemberRegisterForm() {
    }
}
