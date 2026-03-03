package com.tasks;

import java.time.Duration;
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
                WaitUntil.the(HomePage.PRODUCT_LINK.of(productName), isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                net.serenitybdd.screenplay.actions.Scroll.to(HomePage.PRODUCT_LINK.of(productName)),
                Click.on(HomePage.PRODUCT_LINK.of(productName)),

                WaitUntil.the(ProductPage.ADD_TO_CART_BTN, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                WaitUntil.the(ProductPage.ADD_TO_CART_BTN, isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(ProductPage.ADD_TO_CART_BTN),

                AcceptAlert.now(),

                WaitUntil.the(ExpectedConditions.not(ExpectedConditions.alertIsPresent()))
                        .forNoMoreThan(Duration.ofSeconds(5)),

                WaitUntil.the(HomePage.HOME_MENU, isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                JavaScriptClick.on(HomePage.HOME_MENU),

                WaitUntil.the(HomePage.PRODUCT_LINK.of(productName), isVisible()).forNoMoreThan(Duration.ofSeconds(5)));
    }

    public static AddProduct toCart(String productName) {
        return Tasks.instrumented(AddProduct.class, productName);
    }
}