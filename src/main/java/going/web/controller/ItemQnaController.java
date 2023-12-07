package going.web.controller;

import going.domain.Member;
import going.model.dto.member.MemberResponseDto;
import going.model.dto.qna.QnaRequestDto;
import going.model.dto.qna.QnaResponseDto;
import going.model.service.ItemQnaService;
import going.web.resolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemQnaController {

    private final ItemQnaService service;

    @PostMapping("/search/detail/{itemId}/qna")
    public QnaResponseDto saveQna(@PathVariable("itemId") Long itemId, @RequestBody QnaRequestDto params) {
        Long qnaId = service.saveQna(params);
        return service.findById(qnaId);
    }

    @GetMapping("/search/detail/{itemId}/qna")
    public List<QnaResponseDto> findAllQna(@PathVariable("itemId") Long itemId) {
        return service.findAll(itemId);
    }


}
