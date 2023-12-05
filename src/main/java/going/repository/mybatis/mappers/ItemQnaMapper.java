package going.repository.mybatis.mappers;

import going.domain.Qna;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemQnaMapper {

    void save(Qna params);

    Optional<Qna> findById(Long qnaId);

    List<Qna> findAll(Long itemId);

    void update(Qna params);

    void deleteById(Long qnaId);

    int count(Long itemId);
}
