package going.service;

import going.common.exception.BadRequestException;
import going.domain.Item;
import going.model.common.Paging;
import going.model.common.PagingResponseDto;
import going.model.common.SearchDto;
import going.model.item.ItemResponseDto;
import going.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public PagingResponseDto<ItemResponseDto> findAll(final SearchDto params) {

        int totalCount = itemRepository.count(params);
        if (totalCount < 1) {
            return new PagingResponseDto<>(Collections.emptyList(), null);
        }

        Paging paging = new Paging(totalCount, params);
        params.setPaging(paging);

        List<ItemResponseDto> findAll = itemRepository.findAll(params)
                .stream()
                .map(Item::toDto)
                .toList();

        return new PagingResponseDto<>(findAll, paging);
    }
}
