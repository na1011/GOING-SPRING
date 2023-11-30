package going.controller;

import going.config.resolver.Login;
import going.domain.form.ItemRegisterForm;
import going.domain.item.Item;
import going.domain.item.ItemRepository;
import going.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/myPage/*")
public class MyPageController {

    private final ItemRepository itemRepository;

    @Autowired
    public MyPageController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/home")
    public String myPageHome(@Login Member loginMember, Model model) {
        List<Item> cartList = loginMember.getCartList();
        model.addAttribute("cartList", cartList);
        return "myPage/home";
    }

    @GetMapping("/history")
    public String payHistory() {
        return "myPage/history";
    }

    @GetMapping("/register")
    public String itemRegisterView(@ModelAttribute ItemRegisterForm form) {
        return "myPage/register";
    }

    @PostMapping("/register")
    public String itemRegister(@Validated @ModelAttribute ItemRegisterForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("에러 발생 = {}", bindingResult);
            return "myPage/register";
        }

        Item item = new Item(form.getItemName(), form.getPrice());
        itemRepository.save(item);
        return "redirect:/item/detail/" + item.getId();
    }

    @GetMapping("/reserve")
    public String myReserve() {
        return "myPage/reserve";
    }
}