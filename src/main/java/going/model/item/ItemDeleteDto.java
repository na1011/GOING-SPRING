package going.model.item;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemDeleteDto {

    private Long id;

    @Builder
    public ItemDeleteDto(Long id) {
        this.id = id;
    }
}
