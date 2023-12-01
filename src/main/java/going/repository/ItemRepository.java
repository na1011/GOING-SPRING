package going.repository;

import going.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Long save(Item item);

    void update(Item item);

    void deleteById(Long id);

    Optional<Item> findById(Long id);

    List<Item> findAll();

//    int count();
}
