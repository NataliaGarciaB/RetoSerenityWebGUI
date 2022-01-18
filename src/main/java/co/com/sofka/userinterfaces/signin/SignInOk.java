package co.com.sofka.userinterfaces.signin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignInOk extends PageObject {

    public static final Target SIGN_IN_BUTTON = Target
            .the("Button SignIn")
            .located(By.cssSelector("a[class='login']"));

    public static final Target EMAIL = Target
            .the("Email")
            .located(By.id("email"));

    public static final Target PASSWORD = Target
            .the("PassWord")
            .located(By.id("passwd"));

    public static final Target LOGIN_BUTTON_SUBMIT = Target
            .the("Button submit login")
            .located(By.id("SubmitLogin"));

    //For validation
    public static final Target MY_ACCOUNT = Target
            .the("Message my account")
            .located(xpath("//*[@id=\"center_column\"]/h1"));
}