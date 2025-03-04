import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {

  @BeforeAll
  static void beforeAll(){
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillFormTest() {
    open("/automation-practice-form");
    $("#firstName").setValue("Victoria");
    $("#lastName").setValue("Test");
    $("#userEmail").setValue("victoria@mail.com");
    $("[for=gender-radio-2]").click();
    $("#userNumber").setValue("7458521458");
    $("#dateOfBirthInput").click();
    $("div.react-datepicker select").click();
    $(byText("April")).click();
    $("div.react-datepicker select").click();
    $(byText("2000")).click();
    $("div.react-datepicker").$(byText("14")).click();
    $("#subjectsInput").setValue("Test");
    $("[for=hobbies-checkbox-1]").click();
    $("[for=hobbies-checkbox-2]").click();
    $("[for=hobbies-checkbox-3]").click();
    File cv = new File("C:/Projects/demoqa.com_automation-practice-form/src/source/test.png");
    $("#uploadPicture").uploadFile(cv);
    $("#currentAddress").setValue("Some street 1");
    $("#state").click();
    $(byText("NCR")).click();
    $("#city").click();
    $(byText("Delhi")).click();
    $("#submit").click();
    $(".modal-header #example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".modal-body tr th:nth-child(1)").shouldHave(text("Label"));
    $(".modal-body tr th:nth-child(2)").shouldHave(text("Values"));
    $(".table-responsive tbody tr:nth-child(1) td:nth-child(1)").shouldHave(text("Student Name"));
    $(".table-responsive tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Victoria Test"));
    $(".table-responsive tbody tr:nth-child(2) td:nth-child(1)").shouldHave(text("Student Email"));
    $(".table-responsive tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("victoria@mail.com"));
    $(".table-responsive tbody tr:nth-child(3) td:nth-child(1)").shouldHave(text("Gender"));
    $(".table-responsive tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Female"));
    $(".table-responsive tbody tr:nth-child(4) td:nth-child(1)").shouldHave(text("Mobile"));
    $(".table-responsive tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("7458521458"));
    $(".table-responsive tbody tr:nth-child(5) td:nth-child(1)").shouldHave(text("Date of Birth"));
    $(".table-responsive tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("14 April,2000"));
    $(".table-responsive tbody tr:nth-child(6) td:nth-child(1)").shouldHave(text("Subjects"));
    $(".table-responsive tbody tr:nth-child(6) td:nth-child(2)").shouldBe(empty);
    $(".table-responsive tbody tr:nth-child(7) td:nth-child(1)").shouldHave(text("Hobbies"));
    $(".table-responsive tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading, Music"));
    $(".table-responsive tbody tr:nth-child(8) td:nth-child(1)").shouldHave(text("Picture"));
    $(".table-responsive tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("test.png"));
    $(".table-responsive tbody tr:nth-child(9) td:nth-child(1)").shouldHave(text("Address"));
    $(".table-responsive tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Some street 1"));
    $(".table-responsive tbody tr:nth-child(10) td:nth-child(1)").shouldHave(text("State and City"));
    $(".table-responsive tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
  }
}
