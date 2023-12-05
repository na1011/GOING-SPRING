package going.controller;

import going.model.dto.common.MessageDto;
import going.model.dto.item.ItemResponseDto;
import going.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemService itemService;

    @GetMapping
    public String Home(Model model) {
        List<ItemResponseDto> priceList = itemService.orderByPrice();
        List<ItemResponseDto> popularList = itemService.orderByLike();

        model.addAttribute("priceList", priceList);
        model.addAttribute("popularList", popularList);
        return "index";
    }

    @GetMapping("/alert")
    public String alert(Model model) {
        MessageDto message = new MessageDto("잘못된 요청입니다.", "/");
        model.addAttribute("message", message);
        return "alert";
    }
}
