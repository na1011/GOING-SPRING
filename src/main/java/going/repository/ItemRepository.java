package going.repository;

import going.domain.Item;
import going.model.dto.common.SearchDto;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Long save(Item item);

    void update(Item item);

    void deleteById(Long id);

    Optional<Item> findById(Long id);

    List<Item> findAll(final SearchDto params);

    int count(final SearchDto params);

    List<Item> orderByPrice();

    List<Item> orderByLike();
}
