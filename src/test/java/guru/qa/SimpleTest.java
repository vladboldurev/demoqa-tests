package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeEach
    void setUp() {
        Selenide.open("https://ya.ru");
    }

    @Test
    void assertTest() {
        Assertions.assertTrue(true);
    }

    @AfterEach
    void tearDown() {
        WebDriverRunner.closeWindow();
    }
}
