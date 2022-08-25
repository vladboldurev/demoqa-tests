package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationWithFakerTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker(new Locale("EN"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String fullName = format("%s %s", firstName, lastName);

    @BeforeEach
    void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void regFormTest() {
        String currentAddress = "Moscow";

        String phone = "79000000000";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailName(email);




//        $("#gender-radio-3 + label").click();
//        $("#genterWrapper").$(byText("Other")).click();
        executeJavaScript("arguments[0].click()", $("#gender-radio-3"));

        registrationFormPage.setBirthDate("30", "July", "2008");


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
        $(".table-responsive").shouldHave(text(fullName), text(email));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text((fullName)));
        registrationFormPage.checkResult("Student Name", fullName);
        Selenide.sleep(5000l);
    }
}
