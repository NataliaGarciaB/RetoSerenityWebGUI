package co.com.sofka.stepdefinition.user;

import co.com.sofka.models.contact.ContactUsFormModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;


import static co.com.sofka.questions.contact.ContactUsFormFail.contactUsFormFail;
import static co.com.sofka.questions.contact.ContactUsFormOk.contactUsFormOk;
import static co.com.sofka.tasks.OpenHomePage.openHomePage;
import static co.com.sofka.tasks.contact.BrowseToContactUs.browseToContactUs;
import static co.com.sofka.tasks.contact.FillContactUs.fillContactUs;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class ContactUsStepdefinition extends Setup {
    private static final Logger LOGGER = Logger.getLogger(ContactUsStepdefinition.class);
    private static final String ACTOR_NAME = "Natalia";
    ContactUsFormModel contactUsFormModel;

    //Backgroud
    @Given("el cliente esta ubicado en la pagina de inicio")
    public void elClienteEstaUbicadoEnLaPaginaDeInicio() {
        try{
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(openHomePage());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    @When("el cliente navegue a la seccion del formulario")
    public void elClienteNavegueALaSeccionDelFormulario() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToContactUs()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("No entra al formulario");
        }
    }

    //Escenario 1
    @When("el cliente ingrese la informacion correctamente y presione el boton enviar")
    public void elClienteIngreseLaInformacionCorrectamenteYPresioneElBotonEnviar() {
        try{
            generatePerson(
                    "nnatag@gmaol.com",
                    "101",
                    "Tengo inconvenientes con mi pedido"
            );
            theActorInTheSpotlight().attemptsTo(
                    fillContactUs()
                            .andTheEmail(contactUsFormModel.getEmail())
                            .andTheReference(contactUsFormModel.getReference())
                            .andTheMessage(contactUsFormModel.getMessage())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    @Then("el cliente visualizara una alerta exitosa que emite la pagina")
    public void elClienteVisualizaraUnaAlertaExitosaQueEmiteLaPagina() {
        try {
            theActorInTheSpotlight()
                    .should(seeThat(
                            contactUsFormOk(), equalTo(true)
                    )
            );
            LOGGER.info("Test OK");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }

    //Escenario 2
    @When("el cliente ingrese la informacion incompleta y presione el boton de envio")
    public void elClienteIngreseLaInformacionIncompletaYPresioneElBotonDeEnvio() {
        try{
            generatePerson(
                    "",
                    "202",
                    "Me siento insatisfecha con mi pedido"
            );
            theActorInTheSpotlight().attemptsTo(
                    fillContactUs()
                            .andTheEmail(contactUsFormModel.getEmail())
                            .andTheReference(contactUsFormModel.getReference())
                            .andTheMessage(contactUsFormModel.getMessage())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    @Then("el cliente visualizara una alerta fallida por falta de email")
    public void elClienteVisualizaraUnaAlertaFallidaPorFaltaDeEmail() {
        try {
            theActorInTheSpotlight()
                    .should(seeThat(
                            contactUsFormFail(), equalTo(true)
                            )
                    );
            LOGGER.info("Test OK2");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }

    private void generatePerson(String email, String reference, String message){
        contactUsFormModel = new ContactUsFormModel();
        contactUsFormModel.setEmail(email);
        contactUsFormModel.setReference(reference);
        contactUsFormModel.setMessage(message);
    }
}
