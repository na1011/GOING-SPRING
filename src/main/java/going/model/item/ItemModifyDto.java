package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemModifyDto {

    private Long item_id;
    private String item_name;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departure_date;
    private LocalDateTime arrival_date;

    @Builder
    public ItemModifyDto(Long item_id, String item_name, String location, int price, String description, LocalDateTime departure_date, LocalDateTime arrival_date) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
    }
}
