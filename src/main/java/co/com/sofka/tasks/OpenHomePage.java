package co.com.sofka.tasks;

import co.com.sofka.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


    public class OpenHomePage implements Task {

        private HomePage homePage;

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Open.browserOn(homePage)
            );
        }

        public static OpenHomePage openHomePage(){
            return new OpenHomePage();
        }
    }