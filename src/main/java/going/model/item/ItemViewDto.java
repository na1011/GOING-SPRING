package going.model.item;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemViewDto {

    private Long item_id;
    private String item_name;
    private String agency_name;
    private String location;
    private int price;
    private int like_count;
    private int delete_yn;
    private String description;

    @Builder
    public ItemViewDto(Long item_id, String item_name, String agency_name, String location, int price, int like_count, int delete_yn, String description) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.agency_name = agency_name;
        this.location = location;
        this.price = price;
        this.like_count = like_count;
        this.delete_yn = delete_yn;
        this.description = description;
    }
}
