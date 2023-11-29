package going.domain.item;

import java.util.List;

public class popularListTest {
    public static void main(String[] args) {
        ItemRepository itemRepository = new ItemRepository();
        Item like2 = new Item("좋아요2개", 2);
        like2.setLikes(2);

        Item like5 = new Item("좋아요5개", 5);
        like5.setLikes(5);

        Item like10 = new Item("좋아요10개", 10);
        like10.setLikes(10);

        itemRepository.save(like5);
        itemRepository.save(like10);
        itemRepository.save(like2);

        List<Item> likeList = itemRepository.popularList();
        for (Item item : likeList) {
            System.out.println("item.getItemName() = " + item.getItemName());
        }
    }
}
