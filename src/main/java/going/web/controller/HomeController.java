package going.web.controller;

import going.domain.item.Item;
import going.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;

    @Autowired
    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> cheapList = itemRepository.cheapList();
        List<Item> popularList = itemRepository.popularList();

        model.addAttribute("cheapList", cheapList);
        model.addAttribute("popularList", popularList);
        return "index";
    }

    @GetMapping("/alert")
    public String alert() {
        return "alert";
    }
}
