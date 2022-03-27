package ру.евант.тесты;

import ру.евант.вв.КонсольПомошник;
import ру.евант.деньги.Монета;

/**
 * <b>Класс МонетаТест</b>
 * Класс для тестирования класса Монета {@link Монета#Монета(int, String)}
 *
 * @version 1.0
 * @autor Евсеев Антон Владимирович
 */
public class МонетаТест {

    public static void main(String[] args) {
        Монета монета = Монета.создать(5, Монета.КОПЕЙКА);
        КонсольПомошник.написатьСообщение(Монета.КОПЕЙКА);
        КонсольПомошник.написатьСообщение(монета.получитьИмя());
        КонсольПомошник.нс();
        КонсольПомошник.написатьСообщение(монета.кСтроке());
    }
}