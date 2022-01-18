package co.com.sofka.userinterfaces.signin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SignInCreateAccountPage extends PageObject {

    // Create Account form
    public static final Target CREATE_EMAIL = Target
            .the("Create account email")
            .located(id("email_create"));

    public static final Target CREATE_ACCOUNT_BUTTON = Target
            .the("Account button")
            .located(id("SubmitCreate"));

    public static final Target FIRST_NAME = Target
            .the("First name field")
            .located(id("customer_firstname"));

    public static final Target LAST_NAME = Target
            .the("Last name field")
            .located(id("customer_lastname"));

    public static final Target CREATE_PASSWORD = Target
            .the("Create password field")
            .located(id("passwd"));

    public static final Target ADDRESS = Target
            .the("Address field")
            .located(id("address1"));

    public static final Target CITY = Target
            .the("City field")
            .located(id("city"));

    public static final Target STATE = Target
            .the("State field")
            .located(id("id_state"));

    public static final Target STATE_CALIFORNIA = Target
            .the("State field")
            .located(xpath("//option[text()='California']"));


    public static final Target ZIP_CODE = Target
            .the("Zip code field")
            .located(id("postcode"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile phone field")
            .located(id("phone_mobile"));

    public static final Target ADDRESS_ALIAS = Target
            .the("Address alias field")
            .located(id("alias"));

    public static final Target SUBMIT_ACCOUNT_BUTTON = Target
            .the("Submit button")
            .located(id("submitAccount"));
}
