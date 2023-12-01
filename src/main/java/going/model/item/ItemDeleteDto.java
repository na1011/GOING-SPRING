package going.model.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemDeleteDto {

    private Long itemId;

    @Builder
    public ItemDeleteDto(Long itemId) {
        this.itemId = itemId;
    }
}
