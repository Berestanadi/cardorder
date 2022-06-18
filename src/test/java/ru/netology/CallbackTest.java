package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {

    @BeforeEach
    public void setUp(){
        open("http://localhost:9999");
    }

    @Test
    public void HappyPathTest() {
        $("[data-test-id=name] input").setValue("Григорьев Иван");
        $("[data-test-id=phone] input").setValue("+79990009898");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}