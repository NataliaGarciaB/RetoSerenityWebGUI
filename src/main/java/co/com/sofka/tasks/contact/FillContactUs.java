package co.com.sofka.tasks.contact;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.contact.ContactUsPage.*;

public class FillContactUs implements Task {
    private String email;
    private String reference;
    private String message;

    public FillContactUs andTheEmail(String email){
        this.email = email;
        return this;
    }

    public FillContactUs andTheReference(String reference){
        this.reference = reference;
        return this;
    }

    public FillContactUs andTheMessage(String message){
        this.message = message;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CHOOSE_SUBJECT),
                Click.on(CHOOSE_SUBJECT),
                Click.on(CHOOSE_WEBMASTER),
                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),
                Scroll.to(ORDER),
                Enter.theValue(reference).into(ORDER),
                Scroll.to(MESSAGE),
                Enter.theValue(message).into(MESSAGE),
                Scroll.to(BUTTON_MESSAGE),
                Click.on(BUTTON_MESSAGE)
        );
    }

    public static FillContactUs fillContactUs(){
        return new FillContactUs();
    }

}
