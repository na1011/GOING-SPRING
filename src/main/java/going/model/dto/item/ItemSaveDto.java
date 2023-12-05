package going.model.dto.item;

import going.domain.Item;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ItemSaveDto {

    private Long agencyId;
    private String itemName;
    private String agencyName;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public ItemSaveDto() {
    }

    @Builder
    public ItemSaveDto(Long agencyId, String itemName, String agencyName, String location, int price, String description, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.agencyId = agencyId;
        this.itemName = itemName;
        this.agencyName = agencyName;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Item toEntity() {
        return Item.builder()
                .agencyId(agencyId)
                .itemName(itemName)
                .agencyName(agencyName)
                .location(location)
                .price(price)
                .description(description)
                .departureDate(departureDate)
                .arrivalDate(arrivalDate)
                .build();
    }
}
