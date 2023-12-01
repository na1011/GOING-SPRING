package going.model.common;

import lombok.Getter;

@Getter
public class Paging {

    // 현재 페이지와 컨텐츠 총 갯수
    private int page;

    // 전체 컨텐츠 갯수와 한 페이지에 표시될 컨텐츠 갯수
    private int allSize;
    private int displaySize;

    // 전체 페이징 갯수
    private int pageNum;

    // 한 페이지에 표시될 컨텐츠의 시작과 끝 인덱스
    private int endIndex;
    private int startIndex;

    // 페이징을 n페이지 단위로 처리
    private int pagingSize;
    private int endPage;
    private int startPage;

    // 페이징 이전 / 다음 버튼
    private boolean prev;
    private boolean next;

    public Paging(int page, int allSize, int displaySize, int pagingSize) {
        this.page = page;
        this.allSize = allSize;
        this.displaySize = displaySize;
        this.pagingSize = pagingSize;
        pageCalculate();
    }

    public void pageCalculate() {
        // 전체 페이징 갯수
        pageNum = (int) Math.ceil((double) allSize / (double) displaySize);

        // 한 페이지에 표시될 컨텐츠의 시작과 끝 인덱스
        endIndex = page * displaySize;
        startIndex = endIndex - (displaySize - 1);

        // 컨텐츠의 마지막 번호를 총 컨텐츠 갯수와 맞춤
        if (endIndex > allSize) {
            endIndex = allSize;
        }

        // 페이징을 n페이지 단위로 처리
        endPage = (int) Math.ceil((double) page / (double) pagingSize) * pagingSize;
        startPage = endPage - (pagingSize - 1);

        // 페이징의 마지막 번호를 총 페이징 갯수와 맞춤
        if (endPage > pageNum) {
            endPage = pageNum;
        }

        // 페이징의 이전과 다음버튼 처리
        prev = startPage != 1;
        next = endPage < pageNum;
    }
}
