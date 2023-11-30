package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ItemViewDto {

    private Long item_id;
    private String item_name;
    private String agency_name;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departure_date;
    private LocalDateTime arrival_date;
    private int like_count;

    @Builder
    public ItemViewDto(Long item_id, String item_name, String agency_name, String location, int price, String description, LocalDateTime departure_date, LocalDateTime arrival_date, int like_count) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.agency_name = agency_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.like_count = like_count;
    }
}
