package going.repository.mybatis;

import going.model.item.ItemModifyDto;
import going.model.item.ItemSaveDto;
import going.model.item.ItemViewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    void save(ItemSaveDto item);

    void update(ItemModifyDto item);

    void deleteById(Long id);

    ItemViewDto findById(Long id);

    List<ItemViewDto> findAll();

//    int count();
}
