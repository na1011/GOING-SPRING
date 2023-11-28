package going.domain.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class ItemRegisterForm {

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 9999999)
    private Integer price;

    public ItemRegisterForm() {
    }
}
