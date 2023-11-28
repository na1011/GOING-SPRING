package going.domain.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegisterForm {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    private String role;

    public MemberRegisterForm() {
    }
}
