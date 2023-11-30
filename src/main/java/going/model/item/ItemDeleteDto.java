package going.model.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDeleteDto {

    private Long item_id;

    @Builder
    public ItemDeleteDto(Long item_id) {
        this.item_id = item_id;
    }
}
