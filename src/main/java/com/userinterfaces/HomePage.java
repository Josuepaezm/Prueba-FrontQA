package com.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target PRODUCT_LINK = Target.the("Link del producto {0}")
            .locatedBy("//a[text()='{0}']");
    public static final Target HOME_MENU = Target.the("Boton de inicio")
            .locatedBy("//a[contains(text(),'Home')]");
    public static final Target CART_MENU = Target.the("Menú Carrito")
            .locatedBy("#cartur");
}