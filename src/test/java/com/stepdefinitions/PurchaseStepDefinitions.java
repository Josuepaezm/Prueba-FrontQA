package com.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.questions.CompraExitosa;
import com.tasks.AddProduct;
import com.tasks.Checkout;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    @Before
    public void setTheStage() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el cliente se encuentra en la pagina de inicio")
    public void queElClienteSeEncuentraEnLaPaginaDeInicio() {
        OnStage.theActorCalled("Cliente").wasAbleTo(Open.url("https://www.demoblaze.com/"));
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProduct.toCart(producto));
    }

    @When("completa el formulario de compra")
    public void completaElFormularioDeCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(Checkout.theCart());
    }

    @Then("deberia ver el mensaje de confirmacion {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El mensaje de compra", CompraExitosa.message(), equalTo(mensajeEsperado)));
    }
}



