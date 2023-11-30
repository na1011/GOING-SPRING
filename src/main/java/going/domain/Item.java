package going.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    private Long item_id;
    private Long agency_id;
    private String item_name;
    private String agency_name;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departure_date;
    private LocalDateTime arrival_date;
    private int like_count;
    private int delete_yn;

    @Builder
    public Item(Long item_id, Long agency_id, String item_name, String agency_name, String location, int price, String description, LocalDateTime departure_date, LocalDateTime arrival_date, int like_count, int delete_yn) {
        this.item_id = item_id;
        this.agency_id = agency_id;
        this.item_name = item_name;
        this.agency_name = agency_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.like_count = like_count;
        this.delete_yn = delete_yn;
    }
}
