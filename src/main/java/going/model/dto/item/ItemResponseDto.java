package going.model.dto.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemResponseDto {

    private Long itemId;
    private String itemName;
    private String agencyName;
    private String location;
    private int price;
    private String description;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private int likeCount;

    @Builder
    public ItemResponseDto(Long itemId, String itemName, String agencyName, String location, int price, String description, LocalDateTime departureDate, LocalDateTime arrivalDate, int likeCount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.agencyName = agencyName;
        this.location = location;
        this.price = price;
        this.description = description;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.likeCount = likeCount;
    }
}
