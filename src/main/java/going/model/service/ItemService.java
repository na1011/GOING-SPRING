package going.model.service;

import going.web.exception.BadRequestException;
import going.domain.Item;
import going.model.dto.common.PagingDto;
import going.model.dto.common.SearchDto;
import going.model.dto.item.ItemResponseDto;
import going.model.dto.item.ItemSaveDto;
import going.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Long saveItem(Item item) {
        return itemRepository.save(item);
    }

    public ItemResponseDto findById(Long id) {
        Optional<Item> findById = itemRepository.findById(id);
        Item findItem = findById.orElseThrow(() -> new BadRequestException("해당하는 상품이 없습니다."));

        return findItem.toDto();
    }

    public Long itemRegister(ItemSaveDto params) {

        Item item = params.toEntity();
        return itemRepository.save(item);
    }

    public List<ItemResponseDto> findAll(final SearchDto params) {

        int totalCount = itemRepository.count(params);
        if (totalCount < 1) {
            return null;
        }

        PagingDto paging = new PagingDto(totalCount, params);
        params.setPaging(paging);

        return itemRepository.findAll(params)
                .stream()
                .map(Item::toDto)
                .toList();
    }

    public List<ItemResponseDto> orderByPrice() {
        return itemRepository.orderByPrice()
                .stream()
                .map(Item::toDto)
                .toList();
    }

    public List<ItemResponseDto> orderByLike() {
        return itemRepository.orderByLike()
                .stream()
                .map(Item::toDto)
                .toList();
    }
}
