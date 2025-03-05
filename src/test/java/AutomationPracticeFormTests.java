import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

  @BeforeAll
  static void beforeAll(){
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillFormTest() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    $("#firstName").setValue("Victoria");
    $("#lastName").setValue("Test");
    $("#userEmail").setValue("victoria@mail.com");
    $("[for=gender-radio-2]").click();
    $("#userNumber").setValue("7458521458");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").find("option[value='3']").click();
    $(".react-datepicker__year-select").find("option[value='2000']").click();
    $(".react-datepicker__day--014").click();
    $("#subjectsInput").setValue("Accounting").pressEnter();
    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#uploadPicture").uploadFromClasspath("test.png");
    $("#currentAddress").setValue("Some street 1");
    $("#state").click();
    $("#stateCity-wrapper").$(byText("NCR")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Delhi")).click();
    $("#submit").click();
    $(".modal-header #example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".modal-body tr th:nth-child(1)").shouldHave(text("Label"));
    $(".modal-body tr th:nth-child(2)").shouldHave(text("Values"));
    $(".table-responsive").shouldHave(text("Victoria Test"));
    $(".table-responsive").shouldHave(text("victoria@mail.com"));
    $(".table-responsive").shouldHave(text("Female"));
    $(".table-responsive").shouldHave(text("7458521458"));
    $(".table-responsive").shouldHave(text("14 April,2000"));
    $(".table-responsive").shouldHave(text("Accounting"));
    $(".table-responsive").shouldHave(text("Sports"));
    $(".table-responsive").shouldHave(text("test.png"));
    $(".table-responsive").shouldHave(text("Some street 1"));
    $(".table-responsive").shouldHave(text("NCR Delhi"));
  }
}
