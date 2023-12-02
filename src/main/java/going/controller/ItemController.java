package going.controller;

import going.model.common.PagingResponseDto;
import going.model.common.SearchDto;
import going.model.item.ItemResponseDto;
import going.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String itemMain(@ModelAttribute("params") SearchDto params, Model model) {

        PagingResponseDto<ItemResponseDto> result = itemService.findAll(params);
        model.addAttribute("itemList", result.getList());
        model.addAttribute("paging", result.getPaging());

        return "search/test";
    }
}
