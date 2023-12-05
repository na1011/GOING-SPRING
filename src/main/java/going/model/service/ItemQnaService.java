package going.model.service;

import going.domain.Qna;
import going.model.dto.qna.QnaRequestDto;
import going.model.dto.qna.QnaResponseDto;
import going.repository.ItemQnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemQnaService {

    private final ItemQnaRepository qnaRepository;

    @Transactional
    public Long saveQna(QnaRequestDto params) {
        Qna qna = params.toEntity();
        return qnaRepository.save(qna);
    }

    public QnaResponseDto findById(Long qnaId) {
        Qna qna = qnaRepository.findById(qnaId).orElseThrow(() -> new NullPointerException("잘못된 요청입니다."));
        return qna.toDto();
    }

    public List<QnaResponseDto> findAll(Long itemId) {
        return qnaRepository.findAll(itemId).stream()
                .map(Qna::toDto)
                .toList();
    }

    @Transactional
    public Long updateQna(QnaRequestDto params) {
        Qna qna = params.toEntity();
        return qnaRepository.update(qna);
    }

    @Transactional
    public void deleteQna(Long qnaId) {
        qnaRepository.deleteById(qnaId);
    }
}
