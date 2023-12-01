package going.service;

import going.domain.Item;
import going.model.item.ItemSaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void saveItem() {
        ItemSaveDto itemSave = ItemSaveDto.builder()
                .itemName("5번째")
                .agencyId(1L)
                .agencyName("A투어")
                .location("뉴욕")
                .price(99999)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now())
                .description("상품 등록 테스트입니다.")
                .build();
        Item item = itemSave.toEntity();
        Long id = itemService.saveItem(item);


    }
}