package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 아이템 등록, 수정에 사용
 */
@Getter
@Setter
public class ItemSaveDto {

    private String item_name;
    private String agency_name;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departure_date;
    private LocalDateTime arrival_date;

    @Builder
    public ItemSaveDto(String item_name, String agency_name, String location, int price, String description, LocalDateTime departure_date, LocalDateTime arrival_date) {
        this.item_name = item_name;
        this.agency_name = agency_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
    }
}
