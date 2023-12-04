package going.controller;

import going.model.item.ItemResponseDto;
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
}
