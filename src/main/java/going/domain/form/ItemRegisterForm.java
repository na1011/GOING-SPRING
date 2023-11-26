package going.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRegisterForm {

    private String ItemName;
    private int price;

    public ItemRegisterForm() {
    }
}
