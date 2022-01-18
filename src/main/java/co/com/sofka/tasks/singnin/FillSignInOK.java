package co.com.sofka.tasks.singnin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.signin.SignInOk.*;

public class FillSignInOK implements Task {
    private String email;
    private String password;

    public FillSignInOK withTheEmail (String email) {
        this.email = email;
        return this;
    }

    public FillSignInOK andThePassword (String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BUTTON_SUBMIT)
        );

    }

    public static FillSignInOK fillSignInOK () {
        return new FillSignInOK();
    }

}
