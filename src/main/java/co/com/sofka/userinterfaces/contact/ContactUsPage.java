package co.com.sofka.userinterfaces.contact;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ContactUsPage extends PageObject {

    // Contact us form.
    public static final Target CONTACT_US = Target
            .the("Contact Us")
            .located(xpath("//*[@id=\"contact-link\"]/a"));

    // Contact form fields
    public static final Target CHOOSE_SUBJECT = Target
            .the("Choose Subject Heading")
            .located(By.id("id_contact"));
    public static final Target CHOOSE_WEBMASTER = Target
            .the("Webmaster subject")
            .located(xpath("//option[text()='Webmaster']"));
    public static final Target EMAIL = Target
            .the("Email")
            .located(id("email"));
    public static final Target ORDER = Target
            .the("Order")
            .located(id("id_order"));
    public static final Target MESSAGE = Target
            .the("Message")
            .located(id("message"));
    public static final Target BUTTON_MESSAGE = Target
            .the("Button message ")
            .located(id("submitMessage"));

    // For validation
    public static final Target MESSAGE_OK = Target
            .the("Message Ok")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

    public static final Target MESSAGE_FAIL = Target
            .the("Message Fail")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
}
