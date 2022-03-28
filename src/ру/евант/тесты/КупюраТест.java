package ру.евант.тесты;

import ру.евант.вв.КонсольПомошник;
import ру.евант.деньги.Купюра;
import ру.евант.деньги.Монета;

/**
 * <b>Класс МонетаТест</b>
 * Класс для тестирования класса Монета {@link Монета#Монета(int, String)}
 *
 * @version 1.0
 * @autor Евсеев Антон Владимирович
 */
public class КупюраТест {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Купюра купюра = Купюра.создать(1000);
            КонсольПомошник.написатьСообщение(купюра.получитьВсеПараметры());
        }

    }
}