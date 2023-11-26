package going.domain.item;

import going.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private int likes;
    private List<Member> likedBy;

    public Item(String itemName, Integer price) {
        this.itemName = itemName;
        this.price = price;
        this.likes = 0;
        this.likedBy = new ArrayList<>();
    }
}
