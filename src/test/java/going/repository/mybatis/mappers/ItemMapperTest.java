package going.repository.mybatis.mappers;

import going.domain.member.MemberRepository;
import going.model.item.ItemModifyDto;
import going.model.item.ItemSaveDto;
import going.model.item.ItemViewDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void crud() {
        ItemSaveDto itemSaveDto = ItemSaveDto.builder()
                .item_name("5번째")
                .agency_id(2L)
                .agency_name("OO투어")
                .location("뉴욕")
                .price(99999)
                .departure_date(LocalDateTime.now())
                .arrival_date(LocalDateTime.now())
                .description("상품 등록입니다.")
                .build();

        itemMapper.save(itemSaveDto);

        List<ItemViewDto> findAll = itemMapper.findAll();
        assertThat(findAll.size()).isEqualTo(3);

        ItemViewDto findById = itemMapper.findById(5L);
        assertThat(findById.getItem_name()).isEqualTo(itemSaveDto.getItem_name());

        ItemModifyDto itemModifyDto = ItemModifyDto.builder()
                        .item_id(findById.getItem_id())
                                .
        itemMapper.update();
    }

    @Test
    void update() {

        itemMapper.update();
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