package guru.qa;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXPathExamples {
    void test(){
        $("[data-testid=email]").setValue("123");
        $(by("data-testid", "email")).setValue("123");
        $("#email").setValue("123");
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");
        $("[name=email]").setValue("");
        $(byName("email"));
        $("[class=login]").setValue("");
//        если один элемент с этими классами
        $(".inputtext.color_red");
        $("input.inputtext");
        $x("//input[@class='test'][@class='test2']");
//        если два элемента один из них вложенный
        $(".test1 .test2");
//        супер конкретный
        $("input.test1.test2#email[name=email][datatestid=email]");

//        поиск по тексту
        $x("//div[text()='Hello']");
        $x("//div[contains(text(), 'ello')]");
        $x("//div[text()[contains(.,'ello')]]");

        $(byText("Hello"));
        $(withText("ello"));
    }
}
