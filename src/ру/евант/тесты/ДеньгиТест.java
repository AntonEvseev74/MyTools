package ру.евант.тесты;

import ру.евант.вв.КонсольПомошник;
import ру.евант.деньги.Деньги;
import ру.евант.деньги.Купюра;
import ру.евант.деньги.Монета;

public class ДеньгиТест {
    public static void main(String[] args) {
        Деньги купюра = Купюра.создать(50);
        Деньги монета = Монета.создать(5,"рублей");
        Деньги монета2 = new Монета(10,"копеек");

        КонсольПомошник.написатьСообщение(купюра.получитьИмя());
        КонсольПомошник.написатьСообщение(монета.получитьИмя());
        КонсольПомошник.написатьСообщение(монета2.получитьИмя());
    }
}
