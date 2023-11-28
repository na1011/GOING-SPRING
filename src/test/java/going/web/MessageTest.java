package going.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
public class MessageTest {

    @Autowired
    MessageSource ms;

    @Test
    void errorMessages() {
        String result = ms.getMessage("Range.price", null, null);
        Assertions.assertThat(result).isEqualTo("{0}, 가격은 {2}~{1}원 범위입니다.");
    }
}
