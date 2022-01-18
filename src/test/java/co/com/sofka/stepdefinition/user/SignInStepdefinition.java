package co.com.sofka.stepdefinition.user;

import co.com.sofka.models.signin.SignInFormModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;

import static co.com.sofka.questions.signin.SignInFormOk.signInFormOk;
import static co.com.sofka.tasks.OpenHomePage.openHomePage;
import static co.com.sofka.tasks.singnin.BrowseToSignIn.browseToSignIn;
import static co.com.sofka.tasks.singnin.FillSignInCreateAccount.fillSignInCreateAccount;
import static co.com.sofka.tasks.singnin.FillSignInOK.fillSignInOK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SignInStepdefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(SignInStepdefinition.class);
    private static final String ACTOR_NAME = "Natalia";
    SignInFormModel signInFormModel;

    @Given("el cliente esta ubicado en el sitio web")
    public void elClienteEstaUbicadoEnElSitioWeb() {
        try{
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(openHomePage());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }

    }

    @When("el cliente navegue a la seccion del formulario de SIGN IN")
    public void elClienteNavegueALaSeccionDelFormularioDeSIGNIN() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToSignIn()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("No ingresa a SIGN IN");
        }
    }

    @When("el cliente crea una cuenta y presiona el boton CREATE A ACCOUNT")
    public void elClienteCreaUnaCuentaYPresionaElBotonCREATEAACCOUNT() {
        try{
            generatePersonRegister();
            theActorInTheSpotlight().attemptsTo(
                    fillSignInCreateAccount()
                        .withTheEmail(signInFormModel.getEmail())
                        .wasFilledFirstName(signInFormModel.getFirstName())
                        .andTheLastName(signInFormModel.getLastName())
                        .andThePassword(signInFormModel.getPassword())
                        .andTheAddress(signInFormModel.getAddress())
                        .andTheCity(signInFormModel.getCity())
                        .andTheZipCode(signInFormModel.getZipCode())
                        .andTheMobilePhone(signInFormModel.getMobilePhone())
                        .andTheFutureAddress(signInFormModel.getFutureAddress())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }

    }

    @Then("el cliente ingresa correctamente a la pagina web")
    public void elClienteIngresaCorrectamenteALaPaginaWeb() {
        try {
            theActorInTheSpotlight()
                    .should(seeThat(
                                    signInFormOk(), equalTo(true)
                            )
                    );
            LOGGER.info("Test SIGN IN OK");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("el cliente ingresa la informacion de la cuenta y presiona el boton SIGN IN")
    public void elClienteIngresaLaInformacionDeLaCuentaYPresionaElBotonSIGNIN() {
        try {
            generatePersonOK();
            theActorInTheSpotlight().attemptsTo(
                    fillSignInOK()
                            .withTheEmail(signInFormModel.getEmail())
                            .andThePassword(signInFormModel.getPassword())
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }

    @Then("el cliente ingresa exitosamente a la pagina web")
    public void elClienteIngresaExitosamenteALaPaginaWeb() {
        try {
            theActorInTheSpotlight()
                    .should(seeThat(
                                    signInFormOk(), equalTo(true)
                            )
                    );
            LOGGER.info("Test SIGN IN OK2");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }


    private void generatePersonRegister(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setFirstName("Natalia");
        signInFormModel.setLastName("Garcia");
        signInFormModel.setEmail("NNNGB123@mgmail.com");
        signInFormModel.setPassword("NNNGB123");
        signInFormModel.setAddress("AVENIDA SIEMPRE VIVA 1234");
        signInFormModel.setCity("Nn NN");
        signInFormModel.setZipCode("10002");
        signInFormModel.setMobilePhone("31477645678");
        signInFormModel.setFutureAddress("Siempre igual");
    }
    private void generatePersonOK(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setEmail("NNNGB123@mgmail.com");
        signInFormModel.setPassword("NNNGB123");
    }

}
