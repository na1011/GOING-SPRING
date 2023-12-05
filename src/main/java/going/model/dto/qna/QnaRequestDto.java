package going.model.dto.qna;

import going.domain.Qna;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QnaRequestDto {

    private Long qnaId;
    private Long itemId;
    private String userName;
    private String title;
    private String content;

    @Builder
    public QnaRequestDto(Long qnaId, Long itemId, String userName, String title, String content) {
        this.qnaId = qnaId;
        this.itemId = itemId;
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public Qna toEntity() {
        return Qna.builder()
                .qnaId(qnaId)
                .itemId(itemId)
                .userName(userName)
                .title(title)
                .content(content)
                .build();
    }
}
