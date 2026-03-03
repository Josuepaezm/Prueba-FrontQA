package com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert; // Importa la interfaz Alert
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AcceptAlert implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("La alerta no apareció o tomó demasiado tiempo. Continuando flujo.");
        }
    }

    public static AcceptAlert now() {
        return Tasks.instrumented(AcceptAlert.class);
    }
}