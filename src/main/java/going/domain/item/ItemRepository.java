package going.domain.item;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {

    private static Map<Long, ItemVO> store = new HashMap<>();
    private static long sequence = 0L;

    public ItemVO save(ItemVO item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public ItemVO findById(Long id) {
        return store.get(id);
    }

    public List<ItemVO> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<ItemVO> searchByTitle(String title) {
        return findAll().stream()
                .filter(i -> i.getItemName().contains(title))
                .collect(Collectors.toList());
    }

    public void clearStore() {
        store.clear();
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 11; i++) {
            save(new ItemVO("테스트", i * i * i));
            save(new ItemVO("검색용", i * i));
        }
    }
}
