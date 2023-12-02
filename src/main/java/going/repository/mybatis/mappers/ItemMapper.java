package going.repository.mybatis.mappers;

import going.domain.Item;
import going.model.common.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(Item item);

    void deleteById(Long id);

    Optional<Item> findById(Long id);

    List<Item> findAll(final SearchDto params);

    int count(final SearchDto params);
}
