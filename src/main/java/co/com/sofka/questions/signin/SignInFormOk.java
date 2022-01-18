package co.com.sofka.questions.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.signin.SignInOk.MY_ACCOUNT;

public class SignInFormOk implements Question<Boolean>{

    @Override
    public Boolean answeredBy (Actor actor) {
        return (MY_ACCOUNT
                .resolveFor(actor)
                .containsOnlyText("MY ACCOUNT")
        );
    }

    public static SignInFormOk signInFormOk () { return new SignInFormOk(); }
}