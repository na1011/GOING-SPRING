package going.web.controller;

import going.model.dto.qna.QnaRequestDto;
import going.model.dto.qna.QnaResponseDto;
import going.model.service.ItemQnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemQnaController {

    private final ItemQnaService service;

    // qna 리스트
    @GetMapping("/search/detail/{itemId}/qna")
    public List<QnaResponseDto> findAllQna(@PathVariable("itemId") Long itemId) {
        return service.findAll(itemId);
    }

    // qna 등록
    @PostMapping("/search/detail/{itemId}/qna")
    public Long saveQna(@RequestBody QnaRequestDto params) {
        Long qnaId = service.saveQna(params);
        return qnaId;
    }

    // qna 수정
    @PatchMapping("/search/detail/{itemId}/qna/{qnaId}")
    public QnaResponseDto updateQna(@PathVariable("qnaId") Long qnaId, @RequestBody QnaRequestDto params) {
        Long id = service.updateQna(params);
        return service.findById(id);
    }

    // qna 삭제
    @DeleteMapping("/search/detail/{itemId}/qna/{qnaId}")
    public Long deleteQna(@PathVariable("qnaId") Long qnaId) {
        service.deleteQna(qnaId);
        return qnaId;
    }
}
