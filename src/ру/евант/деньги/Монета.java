package ру.евант.деньги;

import ру.евант.вв.КонсольПомошник;
import ру.евант.константы.Ошибка;
import ру.евант.утилиты.МассивУтилиты;

import static ру.евант.утилиты.МассивУтилиты.естьВМассиве;

/**
 * <b>Класс Монета</b>
 * Класс содержит:
 * характеристики монеты <b>номинальнаяСтоимость</b>, <b>имя</b>, <b>диаметр</b>, <b>вес</b> и <b>толщина</b>.
 * конструктор для создания экземпляров класса
 * методы для работы с экземплярами класса
 *
 * @version 1.0
 * @autor Евсеев Антон Владимирович
 */

public final class Монета implements Деньги {
    /**
     * <b>Константы</b>
     * /** Константа для поиска монет типа - копейка
     */
    public static final String КОПЕЙКА = "к";

    /**
     * Константа для поиска монет типа - рубль
     */
    public static final String РУБЛЬ = "р";

    /**
     * Константа для поиска монет типа - рублей и копеек
     */
    private static final String[] списокИменМонет = {
            "к", "к.", "коп", "коп.", "Коп", "Коп.", "копейку", "Копейка", "копеек", "Копеек",
            "р", "р.", "руб", "руб.", "Руб", "Руб.", "рубль", "Рубль", "рублей", "Рублей"};

    /**
     * Константа - индекс массива список монет, в котором содержится название монеты
     */
    private static final int ИМЯ = 0;

    /**
     * Константа - индекс массива список монет, в котором содержится диаметр монеты в миллиметрах
     */
    private static final int ДИАМЕТР = 1;

    /**
     * Константа - индекс массива список монет, в котором содержится вес монеты в граммах
     */
    private static final int ВЕС = 2;

    /**
     * Константа - индекс массива список монет, в котором содержится толщина монеты в миллиметрах
     */
    private static final int ТОЛЩИНА = 3;

    /**
     * <b>Поля</b>
     *
     * Поле - Номинальная стоимость монеты
     */
    private int номинальнаяСтоимость;

    /**
     * Поле - Название монеты
     */
    private String имя;

    /**
     * Поле - диаметр монеты
     */
    private double диаметр;

    /**
     * Поле - вес монеты
     */
    private double вес;

    /**
     * Поле - толщина монеты
     */
    private double толщина;

    /**
     * <b>Двумерный массив</b>
     * Содержит характеристики монеты:
     * <li>Имя(название)</li>
     * <li>Диаметр</li>
     * <li>Вес</li>
     * <li>Толщина</li>
     * Тип содержащихся данных - String
     */
    private final String[][] списокМонет = {
            //имя,    диаметр, вес, толщина
            // 0        1       2       3
            {"1к.", "15.5", "1.5", "1.25"},   // 0 индекс внешнего массива
            {"5к.", "18.5", "2.6", "1.45"},   // 1 индекс внешнего массива
            {"10к.", "17.5", "1.95", "1.25"}, // 2 индекс внешнего массива
            {"50к.", "19.5", "2.9", "1.5"},   // 3 индекс внешнего массива
            {"1р.", "20.5", "3.25", "1.5"},   // 4 индекс внешнего массива
            {"2р.", "23", "5.1", "1.8"},      // 5 индекс внешнего массива
            {"5р.", "25", "6.45", "1.8"},     // 6 индекс внешнего массива
            {"10р.", "22", "5.63", "2.2"}     // 7 индекс внешнего массива
            // имя - 0 индекс внутреннего массива
            // диаметр - 1 индекс внутреннего массива
            // вес - 2 индекс внутреннего массива
            // толщина - 3 индекс внутреннего массива
    };

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param номинальнаяСтоимость - Номинальная стоимость монеты
     * @param тип                  - тип монеты, копейка или рубль
     */
    public Монета(int номинальнаяСтоимость, String тип) {

        if (тип.charAt(0) == 'к') тип = КОПЕЙКА;
        if (тип.charAt(0) == 'р') тип = РУБЛЬ;

        присвоитьНоминальнаяСтоимость(номинальнаяСтоимость);
        присвоитьИмя(номинальнаяСтоимость, тип);
        присвоитьДиаметр(номинальнаяСтоимость, тип);
        присвоитьВес(номинальнаяСтоимость, тип);
        присвоитьТолщина(номинальнаяСтоимость, тип);
    }

    /**
     * Методы
     * <p>
     * Метод создания экземпляра монеты {@link Монета#Монета(int, String)}
     *
     * @return возвращает экземпляр монеты
     */
    public static Монета создать(int номинальнаяСтоимость, String тип) {
        if (естьВМассиве(списокИменМонет, тип) && тип.contains("к")) return new Монета(номинальнаяСтоимость, КОПЕЙКА);
        else if(естьВМассиве(списокИменМонет, тип) && тип.contains("р")) return new Монета(номинальнаяСтоимость, РУБЛЬ);
        else КонсольПомошник.написатьСообщение(Монета.class + "  " + Ошибка.ЭКЗЕМПЛЯР_НЕ_СОЗДАН);

        return null;
    }

    /**
     * Метод получения значения поля {@link Монета#номинальнаяСтоимость}
     *
     * @return возвращает номинальную стоимость монеты
     */
    public int получитьНоминальнаяСтоимость() {
        return номинальнаяСтоимость;
    }

    /**
     * Метод присвоения значения полю {@link Монета#номинальнаяСтоимость}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     */
    private void присвоитьНоминальнаяСтоимость(int номинальнаяСтоимость) {
        // если принимаемое значение больше нуля, присвоить полю 'номинальнаяСтоимость' полученное значение
        // иначе вывести в консоль сообщение об ошибке
        if (номинальнаяСтоимость > 0) this.номинальнаяСтоимость = номинальнаяСтоимость;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения значения поля {@link Монета#имя}
     *
     * @return возвращает название монеты
     */
    public String получитьИмя() {
        return имя;
    }

    /**
     * Метод присвоения значения полю {@link Монета#имя}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    private void присвоитьИмя(int номинальнаяСтоимость, String тип) {
        this.имя = МассивУтилиты.получитьИзДвумерногоМассива(списокМонет, номинальнаяСтоимость+тип, ИМЯ);
    }

    /**
     * Метод получения значения поля {@link Монета#диаметр}
     *
     * @return возвращает диаметр монеты
     */
    public double получитьДиаметр() {
        return диаметр;
    }

    /**
     * Метод присвоения значения полю {@link Монета#диаметр}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    private void присвоитьДиаметр(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокМонет, строка, ДИАМЕТР));

        // если значение больше нуля, присвоить полю 'диаметр' значение переменной 'тм'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.диаметр = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения значения поля {@link Монета#вес}
     *
     * @return возвращает вес монеты
     */
    public double получитьВес() {
        return вес;
    }

    /**
     * Метод присвоения значения полю {@link Монета#вес}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    public void присвоитьВес(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокМонет, строка, ВЕС));

        // если значение больше нуля, присвоить полю 'вес' значение переменной 'тмп'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.вес = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения значения поля {@link Монета#толщина}
     *
     * @return возвращает толщина монеты
     */
    public double получитьТолщина() {
        return толщина;
    }

    /**
     * Метод присвоения значения полю {@link Монета#толщина}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    public void присвоитьТолщина(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокМонет, строка, ТОЛЩИНА));

        // если значение больше нуля, присвоить полю 'толщина' значение переменной 'тмп'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.толщина = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения форматированной строки с характеристиками монеты
     * Содержит данные полей:
     * - название {@link Монета#имя}
     * - диаметр {@link Монета#диаметр}
     * - вес {@link Монета#вес}
     * - толщина {@link Монета#толщина}
     *
     * @return возвращает строку с информацией о экземпляре
     */
    public String получитьВсеПараметры() {
        return "Монета " + получитьИмя() +
                ": диаметр: " + получитьДиаметр() +
                ", вес: " + получитьВес() +
                ", толщина: " + получитьТолщина();
    }

    @Override
    public String toString() {
        return получитьВсеПараметры();
    }
}
