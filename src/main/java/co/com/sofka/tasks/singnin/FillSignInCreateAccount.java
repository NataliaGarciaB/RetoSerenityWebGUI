package co.com.sofka.tasks.singnin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.signin.SignInCreateAccountPage.*;

public class FillSignInCreateAccount implements Task {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String zipCode;
    private String mobilePhone;
    private String futureAddress;

    public FillSignInCreateAccount wasFilledFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillSignInCreateAccount withTheEmail(String email){
        this.email = email;
        return this;
    }

    public FillSignInCreateAccount andTheLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public FillSignInCreateAccount andThePassword(String password){
        this.password = password;
        return this;
    }

    public FillSignInCreateAccount andTheAddress(String address){
        this.address = address;
        return this;
    }

    public FillSignInCreateAccount andTheCity(String city){
        this.city = city;
        return this;
    }

    public FillSignInCreateAccount andTheZipCode(String zipCode){
        this.zipCode = zipCode;
        return this;
    }

    public FillSignInCreateAccount andTheMobilePhone(String mobile){
        this.mobilePhone = mobile;
        return this;
    }

    public FillSignInCreateAccount andTheFutureAddress(String futureAddress){
        this.futureAddress = futureAddress;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Scroll.to(CREATE_EMAIL),
            Enter.theValue(email).into(CREATE_EMAIL),
            Click.on(CREATE_ACCOUNT_BUTTON),

            Scroll.to(FIRST_NAME),
            Enter.theValue(firstName).into(FIRST_NAME),
            Enter.theValue(lastName).into(LAST_NAME),
            Enter.theValue(password).into(CREATE_PASSWORD),
            Scroll.to(ADDRESS),
            Enter.theValue(address).into(ADDRESS),
            Enter.theValue(city).into(CITY),
            Scroll.to(STATE),
            Click.on(STATE),
            Click.on(STATE_CALIFORNIA),
            Enter.theValue(zipCode).into(ZIP_CODE),
            Scroll.to(MOBILE_PHONE),
            Enter.theValue(mobilePhone).into(MOBILE_PHONE),
            Scroll.to(ADDRESS_ALIAS),
            Enter.theValue(futureAddress).into(ADDRESS_ALIAS),
            Click.on(SUBMIT_ACCOUNT_BUTTON)
        );

    }
    public static FillSignInCreateAccount fillSignInCreateAccount () {
        return new FillSignInCreateAccount();
    }

}