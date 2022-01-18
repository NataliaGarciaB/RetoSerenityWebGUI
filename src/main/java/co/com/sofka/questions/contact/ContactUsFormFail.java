package co.com.sofka.questions.contact;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.contact.ContactUsPage.MESSAGE_FAIL;

public class ContactUsFormFail implements Question<Boolean> {

    @Override
    public Boolean answeredBy (Actor actor) {
        return (MESSAGE_FAIL.resolveFor(actor).containsOnlyText("Invalid email address."));
    }

    public static ContactUsFormFail contactUsFormFail () {
        return new ContactUsFormFail();
    }
}
