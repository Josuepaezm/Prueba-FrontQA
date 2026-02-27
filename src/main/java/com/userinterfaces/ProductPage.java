package com.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public static final Target ADD_TO_CART_BTN = Target.the("Botón Add to cart")
            .locatedBy("//a[text()='Add to cart']");
}