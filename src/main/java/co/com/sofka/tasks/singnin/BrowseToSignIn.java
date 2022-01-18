package co.com.sofka.tasks.singnin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.signin.SignInOk.SIGN_IN_BUTTON;

public class BrowseToSignIn implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN_BUTTON),
                Click.on(SIGN_IN_BUTTON)
        );
    }

    public static BrowseToSignIn browseToSignIn(){
        return new BrowseToSignIn();
    }


}
