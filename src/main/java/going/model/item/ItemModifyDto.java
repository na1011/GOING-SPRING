package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemModifyDto {

    private Long item_id;
    private String item_name;
    private String location;
    private int price;
    private String description;

    @Builder
    public ItemModifyDto(Long item_id, String item_name, String location, int price, String description) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.location = location;
        this.price = price;
        this.description = description;
    }
}
