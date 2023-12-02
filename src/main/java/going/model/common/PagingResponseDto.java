package going.model.common;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponseDto<T> {

    private List<T> list = new ArrayList<>();
    private Paging paging;

    public PagingResponseDto(List<T> list, Paging paging) {
        this.list.addAll(list);
        this.paging = paging;
    }
}
