package going.domain.member;

import going.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member {

    private Long id;
    private String email;
    private String password;
    private Role role;
    private List<Item> cartList;

    public Member(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.cartList = new ArrayList<>();
    }
}
