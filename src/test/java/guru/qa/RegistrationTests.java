package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeEach
    void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void regFormTest() {
        String name = "Vlad Bold";
        String email = "test@mail.com";
        String currentAddress = "Moscow";

        String phone = "79000000000";
        open("/automation-practice-form");

        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Bold");
        $("#userEmail").setValue("test@mail.com");

//        $("#gender-radio-3 + label").click();
//        $("#genterWrapper").$(byText("Other")).click();
        executeJavaScript("arguments[0].click()", $("#gender-radio-3"));

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("Maths").pressEnter();

//        $("#hobbies-checkbox-1 + label").click();
//        executeJavaScript("arguments[0].click()", $("#hobbies-checkbox-1"));
        $("#userNumber").setValue(phone);
        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

        $("#state").click();
        $("#stateCity-wrapper").$("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$("#react-select-4-option-0").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(name), text(email));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text((name)));
    }
}
