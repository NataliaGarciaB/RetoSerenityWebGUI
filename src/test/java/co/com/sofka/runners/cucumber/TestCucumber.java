package co.com.sofka.runners.cucumber;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/contacto/contactUs.feature",
        "src/test/resources/features/signin/signIn.feature"},
        glue = {"co.com.sofka.stepdefinition.user"}
)

public class TestCucumber {

}
