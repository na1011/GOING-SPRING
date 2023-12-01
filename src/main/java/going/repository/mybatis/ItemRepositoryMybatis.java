package going.repository.mybatis;

import going.domain.Item;
import going.repository.ItemRepository;
import going.repository.mybatis.mappers.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryMybatis implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Long save(Item item) {
        itemMapper.save(item);
        return item.getItemId();
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemMapper.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }
}
