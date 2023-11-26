package going.web.controller;

import going.domain.ConstField;
import going.domain.form.ItemRegisterForm;
import going.domain.item.Item;
import going.domain.item.ItemRepository;
import going.domain.member.Member;
import going.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/myPage/*")
public class MyPageController {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MyPageController(ItemRepository itemRepository, MemberRepository memberRepository) {
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/home")
    public String myPageHome(@SessionAttribute(name = ConstField.LOGIN_MEMBER) Member loginMember, Model model) {
        List<Item> cartList = loginMember.getCartList();
        model.addAttribute("cartList", cartList);
        return "myPage/home";
    }

    @GetMapping("/history")
    public String payHistory() {
        return "myPage/history";
    }

    @GetMapping("/register")
    public String itemRegisterView() {
        return "myPage/register";
    }

    @PostMapping("/register")
    public String itemRegister(@ModelAttribute ItemRegisterForm form, Model model) {
        Item item = new Item(form.getItemName(), form.getPrice());
        itemRepository.save(item);
        return "redirect:/item/detail/" + item.getId();
    }

    @GetMapping("/reserve")
    public String myReserve() {
        return "myPage/reserve";
    }
}
