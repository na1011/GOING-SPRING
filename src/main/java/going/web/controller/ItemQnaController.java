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

    // qna 보기
    @GetMapping("/search/detail/{itemId}/qna/{qnaId}")
    public QnaResponseDto viewQna(@PathVariable("qnaId") Long qnaId) {
        return service.findById(qnaId);
    }
}
