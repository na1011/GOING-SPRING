package going.web.controller;

import going.domain.ConstField;
import going.domain.item.ItemRepository;
import going.domain.item.ItemVO;
import going.domain.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item/*")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/detail/{itemId}")
    public String itemDetail(@PathVariable long itemId, Model model) {
        ItemVO findItem = itemRepository.findById(itemId);
        model.addAttribute("itemDetail", findItem);

        return "item/detail";
    }

    @ResponseBody
    @PostMapping("/cart/add")
    public String cartAdd(@RequestParam("itemId") Long itemId, @SessionAttribute(name = ConstField.LOGIN_MEMBER) MemberVO loginMember) {

        ItemVO findItem = itemRepository.findById(itemId);
        List<MemberVO> likedList = findItem.getLikedBy();

        List<ItemVO> cartList = loginMember.getCartList();
        if (!cartList.contains(findItem)) {
            cartList.add(findItem);
            likedList.add(loginMember);
            loginMember.setCartList(cartList);
            findItem.setLikedBy(likedList);

            return "좋아요";

        } else {
            cartList.remove(findItem);
            likedList.remove(loginMember);
            loginMember.setCartList(cartList);
            findItem.setLikedBy(likedList);

            return "취소";
        }
    }
}
