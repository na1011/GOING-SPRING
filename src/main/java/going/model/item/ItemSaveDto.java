package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSaveDto {

    private Long item_id;
    private String item_name;
    private String agency_name;
    private String location;
    private int price;
    private String description;

    @Builder
    public ItemSaveDto(Long item_id, String item_name, String agency_name, String location, int price, String description) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.agency_name = agency_name;
        this.location = location;
        this.price = price;
        this.description = description;
    }
}
