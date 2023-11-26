package going.web.controller;

import going.domain.Paging;
import going.domain.item.ItemRepository;
import going.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/search/*")
public class SearchController {

    private final ItemRepository itemRepository;

    @Autowired
    public SearchController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/main")
    public String mainPage(@RequestParam(defaultValue = "1", name = "page") int page, Model model) {

        List<Item> findAll = itemRepository.findAll();
        Paging paging = new Paging(page, findAll.size(), 3, 5);

        List<Item> itemList = listPaging(paging, findAll);

        model.addAttribute("itemList", itemList);
        model.addAttribute("paging", paging);
        return "search/main";
    }

    @GetMapping("/result")
    public String search(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam("searchTitle") String searchTitle, Model model) {

        List<Item> result = itemRepository.searchByTitle(searchTitle);
        Paging paging = new Paging(page, result.size(), 3, 5);

        List<Item> itemList = listPaging(paging, result);

        model.addAttribute("itemList", itemList);
        model.addAttribute("title", searchTitle);
        model.addAttribute("paging", paging);
        return "search/result";
    }

    private List<Item> listPaging(Paging paging, List<Item> list) {
        List<Item> itemList = new ArrayList<>(3);
        for (int i = paging.getStartIndex(); i <= paging.getEndIndex(); i++) {
            itemList.add(list.get(i - 1));
        }
        return itemList;
    }
}
