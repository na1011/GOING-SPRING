package going.repository.mybatis.mappers;

import going.domain.Item;
import going.model.common.PagingDto;
import going.model.common.SearchDto;
import going.model.item.ItemModifyDto;
import going.model.item.ItemSaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

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
                .agencyName("1번투어")
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
                .itemId(6L)
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
        SearchDto params = new SearchDto();
        params.setPage(1);

        int totalData = itemMapper.count(params);
        PagingDto paging = new PagingDto(totalData, params);
        params.setPaging(paging);

        List<Item> findAll = itemMapper.findAll(params);

        assertThat(findAll.size()).isEqualTo(3);
    }

    @Test
    void searchKeyword() {
        SearchDto params = new SearchDto();
        params.setPage(1);
        params.setSearchType("agency");
        params.setKeyword("10번투어");

        int totalData = itemMapper.count(params);
        PagingDto paging = new PagingDto(totalData, params);
        params.setPaging(paging);

        List<Item> findAll = itemMapper.findAll(params);

        assertThat(findAll.get(0).getAgencyName()).isEqualTo("10번투어");
    }
}