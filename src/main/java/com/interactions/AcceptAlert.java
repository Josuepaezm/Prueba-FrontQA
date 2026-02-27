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
        // 1. Definimos la espera usando Duration (Correcto para Selenium 4)
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));

        // 2. Esperamos y capturamos el Alert en una sola línea
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // 3. Aceptamos
        alert.accept();
    }

    public static AcceptAlert now() {
        return Tasks.instrumented(AcceptAlert.class);
    }
}