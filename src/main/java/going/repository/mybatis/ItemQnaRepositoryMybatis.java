package going.repository.mybatis;

import going.domain.Qna;
import going.repository.ItemQnaRepository;
import going.repository.mybatis.mappers.ItemQnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemQnaRepositoryMybatis implements ItemQnaRepository {

    private final ItemQnaMapper mapper;

    @Override
    public Long save(Qna params) {
        mapper.save(params);
        return params.getQnaId();
    }

    @Override
    public Optional<Qna> findById(Long qnaId) {
        return mapper.findById(qnaId);
    }

    @Override
    public List<Qna> findAll(Long itemId) {
        return mapper.findAll(itemId);
    }

    @Override
    public Long update(Qna params) {
        mapper.update(params);
        return params.getQnaId();
    }

    @Override
    public void deleteById(Long qnaId) {
        mapper.deleteById(qnaId);
    }

    @Override
    public int count(Long itemId) {
        return 0;
    }
}
