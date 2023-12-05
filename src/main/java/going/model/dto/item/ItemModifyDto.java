package going.model.dto.item;

import going.model.domain.Item;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemModifyDto {

    private Long itemId;
    private String itemName;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    @Builder
    public ItemModifyDto(Long itemId, String itemName, String location, int price, String description, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Item toEntity() {
        return Item.builder()
                .itemId(itemId)
                .itemName(itemName)
                .location(location)
                .price(price)
                .description(description)
                .departureDate(departureDate)
                .arrivalDate(arrivalDate)
                .build();
    }
}
