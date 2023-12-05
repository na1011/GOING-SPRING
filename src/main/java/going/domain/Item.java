package going.domain;

import going.model.dto.item.ItemResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    private Long itemId;
    private Long agencyId;
    private String itemName;
    private String agencyName;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private int likeCount;

    @Builder
    public Item(Long itemId, Long agencyId, String itemName, String agencyName, String location, int price, String description, LocalDateTime departureDate, LocalDateTime arrivalDate, int likeCount) {
        this.itemId = itemId;
        this.agencyId = agencyId;
        this.itemName = itemName;
        this.agencyName = agencyName;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.likeCount = likeCount;
    }

    public ItemResponseDto toDto() {
        return ItemResponseDto.builder()
                .itemId(itemId)
                .itemName(itemName)
                .agencyName(agencyName)
                .location(location)
                .price(price)
                .description(description)
                .departureDate(departureDate)
                .arrivalDate(arrivalDate)
                .likeCount(likeCount)
                .build();
    }
}
