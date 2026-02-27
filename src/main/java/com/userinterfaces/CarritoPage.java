package com.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {
    public static final Target PLACE_ORDER_BTN = Target.the("Botón Place Order")
            .locatedBy("//button[text()='Place Order']");
    public static final Target NAME_INPUT = Target.the("Input Nombre").locatedBy("#name");
    public static final Target COUNTRY_INPUT = Target.the("Input País").locatedBy("#country");
    public static final Target CITY_INPUT = Target.the("Input Ciudad").locatedBy("#city");
    public static final Target CARD_INPUT = Target.the("Input Tarjeta").locatedBy("#card");
    public static final Target MONTH_INPUT = Target.the("Input Mes").locatedBy("#month");
    public static final Target YEAR_INPUT = Target.the("Input Año").locatedBy("#year");
    public static final Target PURCHASE_BTN = Target.the("Botón Purchase")
            .locatedBy("//button[text()='Purchase']");
    public static final Target SUCCESS_MESSAGE = Target.the("Mensaje de éxito")
            .locatedBy("//h2[text()='Thank you for your purchase!']");
}