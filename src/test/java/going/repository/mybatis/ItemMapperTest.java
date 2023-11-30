package going.repository.mybatis;

import going.model.item.ItemSaveDto;
import going.model.item.ItemViewDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void save() {
        ItemSaveDto itemSaveDto = ItemSaveDto.builder()
                .item_name("상품등록 테스트")
                .agency_name("회사이름")
                .location("뉴욕")
                .price(99999)
                .departure_date(LocalDateTime.now())
                .arrival_date(LocalDateTime.now())
                .description("상품 등록입니다.")
                .build();

        itemMapper.save(itemSaveDto);

        List<ItemViewDto> findAll = itemMapper.findAll();
        Assertions.assertThat(findAll.size()).isEqualTo(1);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}