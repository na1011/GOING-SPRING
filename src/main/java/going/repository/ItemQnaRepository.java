package going.repository;

import going.domain.Qna;

import java.util.List;
import java.util.Optional;

public interface ItemQnaRepository {

    Long save(Qna params);

    Optional<Qna> findById(Long qnaId);

    List<Qna> findAll(Long itemId);

    Long update(Qna params);

    void deleteById(Long qnaId);

    int count(Long itemId);
}
