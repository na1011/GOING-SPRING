package going.repository;

import going.domain.Item;

import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findById(Long id);
}
