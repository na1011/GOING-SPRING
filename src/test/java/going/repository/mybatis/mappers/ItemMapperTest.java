package going.repository.mybatis.mappers;

import going.domain.Item;
import going.model.item.ItemModifyDto;
import going.model.item.ItemSaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void save() {
        ItemSaveDto itemSave = ItemSaveDto.builder()
                .itemName("아이템 맵퍼 테스트")
                .agencyId(1L)
                .agencyName("A투어")
                .location("뉴욕")
                .price(99999)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now())
                .description("상품 등록 테스트입니다.")
                .build();
        Item item = itemSave.toEntity();
        itemMapper.save(item);

        Item findItem = itemMapper.findById(item.getItemId()).orElseThrow(() -> new NullPointerException("찾는 아이템이 없습니다."));

        assertThat(findItem.getItemName()).isEqualTo(item.getItemName());
    }

    @Test
    void update() {
        ItemModifyDto itemModify = ItemModifyDto.builder()
                .itemId(18L)
                .itemName("아이템 수정 테스트")
                .arrivalDate(LocalDateTime.now())
                .departureDate(LocalDateTime.now())
                .description("상품 수정 테스트입니다.")
                .price(11111)
                .location("도쿄")
                .build();

        Item item = itemModify.toEntity();
        itemMapper.update(item);

        Item findItem = itemMapper.findById(item.getItemId()).orElseThrow(() -> new NullPointerException("찾는 아이템이 없습니다."));

        assertThat(findItem.getItemName()).isEqualTo("아이템 수정 테스트");
    }

    @Test
    void deleteById() {
        ItemSaveDto itemSave = ItemSaveDto.builder()
                .itemName("아이템 삭제 테스트")
                .agencyId(1L)
                .agencyName("A투어")
                .location("뉴욕")
                .price(99999)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now())
                .description("삭제 테스트입니다.")
                .build();
        Item item = itemSave.toEntity();
        itemMapper.save(item);

        itemMapper.deleteById(item.getItemId());

        assertThat(itemMapper.findById(item.getItemId()).orElse(null)).isNull();
    }

    @Test
    void findAll() {
    }
}