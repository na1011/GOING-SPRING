package going.controller;

import going.model.common.SearchDto;
import going.model.item.ItemResponseDto;
import going.model.item.ItemSaveDto;
import going.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

        return "search/detail";
    }

    @GetMapping("/main")
    public String itemMain(@ModelAttribute("params") final SearchDto params, Model model) {

        List<ItemResponseDto> itemList = itemService.findAll(params);
        model.addAttribute("itemList", itemList);
        model.addAttribute("params", params);

        return "search/main";
    }

    @GetMapping("/register")
    public String itemRegisterView(@ModelAttribute ItemSaveDto params) {
        return "myPage/register";
    }

    @PostMapping("/register")
    public String itemRegister(@Validated @ModelAttribute ItemSaveDto params, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "myPage/register";
        }
        Long itemId = itemService.itemRegister(params);

        return "redirect:/item/detail/" + itemId;
    }
}
