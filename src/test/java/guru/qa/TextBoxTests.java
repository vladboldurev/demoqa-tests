package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = "Vlad Bold";
        String email = "test@mail.com";
        String currentAddress = "Moscow";

        open("/text-box");
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=submit]").click();
        Selenide.sleep(5000L);

//        $("[id=output]").shouldHave(text(name), text(email), text(city));
        $("[id=output] [id=name]").shouldHave(text(name));
        $("[id=output]").$("[id=email]").shouldHave(text(email));
        $("[id=output]").find("[id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=permanentAddress]").shouldNotHave(text("error"));
    }
}
