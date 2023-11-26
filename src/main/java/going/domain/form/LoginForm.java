package going.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    private String email;
    private String password;
    private String addr;

    public LoginForm(String email, String password, String addr) {
        this.email = email;
        this.password = password;
        this.addr = addr;
    }
}
