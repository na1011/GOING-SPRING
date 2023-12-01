package going.controller;

import going.model.item.ItemResponseDto;
import going.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search/*")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/detail/{itemId}")
    public String itemDetail(@PathVariable("itemId") long itemId, Model model) {

        ItemResponseDto findById = itemService.findById(itemId);
        model.addAttribute("itemDetail", findById);

        return "search/test";
    }

    @GetMapping("/main")
    public String itemMain(Model model) {

        List<ItemResponseDto> itemList = itemService.findAll();
        model.addAttribute("itemList", itemList);

        return "search/test";
    }
}
