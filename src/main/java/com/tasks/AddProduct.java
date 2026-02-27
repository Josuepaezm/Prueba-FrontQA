package com.tasks;

import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.support.ui.ExpectedConditions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.interactions.AcceptAlert;
import com.userinterfaces.HomePage;
import com.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Task {
    private final String productName;

    public AddProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Ir al producto
                WaitUntil.the(HomePage.PRODUCT_LINK.of(productName), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.PRODUCT_LINK.of(productName)),

                // 2. Agregar al carrito
                WaitUntil.the(ProductPage.ADD_TO_CART_BTN, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductPage.ADD_TO_CART_BTN),

                // 3. Esperar y Aceptar Alerta (Usando tu interacción validada)
                WaitUntil.the(ExpectedConditions.alertIsPresent()),

                AcceptAlert.now(),

                // Esperamos a que el menú sea visible tras cerrar el alert
                WaitUntil.the(HomePage.PRODUCT_LINK, isVisible()).forNoMoreThan(10).seconds(),

                // Usamos JavaScriptClick en lugar de Click normal si el anterior se queda pegado
                JavaScriptClick.on(HomePage.HOME_MENU)

        );
    }

    public static AddProduct toCart(String productName) {
        return Tasks.instrumented(AddProduct.class, productName);
    }
}