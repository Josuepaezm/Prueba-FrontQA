package com.tasks;

import com.userinterfaces.HomePage;
import com.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Checkout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.CART_MENU),
                WaitUntil.the(CarritoPage.PLACE_ORDER_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.PLACE_ORDER_BTN),
                WaitUntil.the(CarritoPage.NAME_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("Juan Perez").into(CarritoPage.NAME_INPUT),
                Enter.theValue("Colombia").into(CarritoPage.COUNTRY_INPUT),
                Enter.theValue("Bogota").into(CarritoPage.CITY_INPUT),
                Enter.theValue("1234567890123456").into(CarritoPage.CARD_INPUT),
                Enter.theValue("12").into(CarritoPage.MONTH_INPUT),
                Enter.theValue("2026").into(CarritoPage.YEAR_INPUT),
                Click.on(CarritoPage.PURCHASE_BTN)
        );
    }
    public static Checkout theCart() {
        return Tasks.instrumented(Checkout.class);
    }
}