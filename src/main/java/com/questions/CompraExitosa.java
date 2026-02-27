package com.questions;

import com.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

    public class CompraExitosa implements Question<String> {
        @Override
        public String answeredBy(Actor actor) {
            return CarritoPage.SUCCESS_MESSAGE.resolveFor(actor).getText();
        }
        public static CompraExitosa message() {
            return new CompraExitosa();
        }
    }
