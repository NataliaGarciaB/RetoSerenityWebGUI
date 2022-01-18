package co.com.sofka.questions.contact;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.contact.ContactUsPage.MESSAGE_OK;

public class ContactUsFormOk implements Question<Boolean> {
    @Override
    public Boolean answeredBy (Actor actor) {
        return (MESSAGE_OK
                .resolveFor(actor)
                .containsOnlyText("Your message has been successfully sent to our team.")
        );
    }

    public static ContactUsFormOk contactUsFormOk () {
        return new ContactUsFormOk();
    }
}
