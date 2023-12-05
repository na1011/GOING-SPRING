package going.model.dto.qna;

import going.domain.Qna;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QnaResponseDto {

    private Long qnaId;
    private Long itemId;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime writeDate;

    @Builder
    public QnaResponseDto(Long qnaId, Long itemId, String userName, String title, String content, LocalDateTime writeDate) {
        this.qnaId = qnaId;
        this.itemId = itemId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
    }

    public Qna toEntity() {
        return Qna.builder()
                .qnaId(qnaId)
                .itemId(itemId)
                .userName(userName)
                .title(title)
                .content(content)
                .writeDate(writeDate)
                .build();
    }
}
