package going.web.controller;

import going.domain.item.Item;
import going.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;

    @Autowired
    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> cheapList = itemRepository.findAll().stream()
                .sorted((a, b) -> a.getPrice().compareTo(b.getPrice())).limit(5)
                .collect(Collectors.toList());

        model.addAttribute("cheapList", cheapList);
        return "index";
    }

    @GetMapping("/alert")
    public String alert() {
        return "alert";
    }
}
