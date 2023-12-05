package going.domain;

import going.model.dto.qna.QnaResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Qna {

    private Long qnaId;
    private Long itemId;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private int deleteYn;

    @Builder
    public Qna(Long qnaId, Long itemId, String userName, String title, String content, LocalDateTime writeDate, int deleteYn) {
        this.qnaId = qnaId;
        this.itemId = itemId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.deleteYn = deleteYn;
    }

    public QnaResponseDto toDto() {
        return QnaResponseDto.builder()
                .qnaId(qnaId)
                .itemId(itemId)
                .userName(userName)
                .title(title)
                .content(content)
                .writeDate(writeDate)
                .build();
    }
}
