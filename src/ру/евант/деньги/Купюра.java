package ру.евант.деньги;

import ру.евант.вв.КонсольПомошник;
import ру.евант.константы.Ошибка;
import ру.евант.утилиты.МассивУтилиты;

import static ру.евант.утилиты.МассивУтилиты.естьВМассиве;

public class Купюра implements Деньги {

    private static String тип = "р";

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
    private static final int ШИРИНА = 1;

    /**
     * Константа - индекс массива список монет, в котором содержится вес монеты в граммах
     */
    private static final int ДЛИНА = 2;

    /**
     * Константа - индекс массива список монет, в котором содержится толщина монеты в миллиметрах
     */
    private static final int ТОЛЩИНА = 3;

    /**
     * <b>Поля</b>
     * <p>
     * Поле - Номинальная стоимость монеты
     */
    private int номинальнаяСтоимость;

    /**
     * Поле - Название купюры
     */
    private String имя;

    /**
     * Поле - диаметр купюры
     */
    private double ширина;

    /**
     * Поле - вес купюры
     */
    private double длина;

    /**
     * Поле - толщина купюры
     */
    private double толщина;

    /**
     * <b>Двумерный массив</b>
     * Содержит характеристики монеты:
     * <li>Имя(название)</li>
     * <li>Ширина</li>
     * <li>Длина</li>
     * <li>Толщина</li>
     * Тип содержащихся данных - String
     */
    private final String[][] списокКупюр = {
            //имя,  ширина, длина, толщина
            // 0        1       2       3
            {"10р.", "65", "150", "0.94"},   // 0 индекс внешнего массива
            {"50р.", "65", "150", "0.97"},   // 1 индекс внешнего массива
            {"100р.", "65", "150", "0.93"}, // 2 индекс внешнего массива
            {"200р.", "65", "150", "0.93"},   // 3 индекс внешнего массива
            {"500р.", "65", "150", "0.97"},   // 4 индекс внешнего массива
            {"1000р.", "69", "157", "1.04"},      // 5 индекс внешнего массива
            {"2000р.", "69", "157", "1.04"},     // 6 индекс внешнего массива
            {"5000р.", "69", "157", "1.04"}     // 7 индекс внешнего массива
            // имя - 0 индекс внутреннего массива
            // диаметр - 1 индекс внутреннего массива
            // вес - 2 индекс внутреннего массива
            // толщина - 3 индекс внутреннего массива
    };

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param номинальнаяСтоимость - Номинальная стоимость монеты
     */
    public Купюра(int номинальнаяСтоимость) {
        присвоитьНоминальнаяСтоимость(номинальнаяСтоимость);
        присвоитьИмя(номинальнаяСтоимость, тип);
        присвоитьДиаметр(номинальнаяСтоимость, тип);
        присвоитьВес(номинальнаяСтоимость, тип);
        присвоитьТолщина(номинальнаяСтоимость, тип);
    }

    /**
     * Методы
     * <p>
     * Метод создания экземпляра монеты {@link Купюра#Купюра(int)}
     *
     * @return возвращает экземпляр монеты
     */
    public static Купюра создать(int номинальнаяСтоимость) {
        if (естьВМассиве(списокИменМонет, тип) && тип.contains("р")) return new Купюра(номинальнаяСтоимость);
        else КонсольПомошник.написатьСообщение(Купюра.class + "  " + Ошибка.ЭКЗЕМПЛЯР_НЕ_СОЗДАН);

        return null;
    }

    /**
     * Метод получения значения поля {@link Купюра#номинальнаяСтоимость}
     *
     * @return возвращает номинальную стоимость купюры
     */
    public int получитьНоминальнаяСтоимость() {
        return номинальнаяСтоимость;
    }

    /**
     * Метод присвоения значения полю {@link Купюра#номинальнаяСтоимость}
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
     * Метод получения значения поля {@link Купюра#имя}
     *
     * @return возвращает название купюры
     */
    public String получитьИмя() {
        return имя;
    }

    /**
     * Метод присвоения значения полю {@link Купюра#имя}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    private void присвоитьИмя(int номинальнаяСтоимость, String тип) {
        this.имя = МассивУтилиты.получитьИзДвумерногоМассива(списокКупюр, номинальнаяСтоимость + тип, ИМЯ);
    }

    /**
     * Метод получения значения поля {@link Купюра#ширина}
     *
     * @return возвращает диаметр купюры
     */
    public double получитьШирину() {
        return ширина;
    }

    /**
     * Метод присвоения значения полю {@link Купюра#ширина}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    private void присвоитьДиаметр(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокКупюр, строка, ШИРИНА));

        // если значение больше нуля, присвоить полю 'диаметр' значение переменной 'тм'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.ширина = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения значения поля {@link Купюра#длина}
     *
     * @return возвращает вес купюры
     */
    public double получитьДлину() {
        return длина;
    }

    /**
     * Метод присвоения значения полю {@link Купюра#длина}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    public void присвоитьВес(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокКупюр, строка, ДЛИНА));

        // если значение больше нуля, присвоить полю 'вес' значение переменной 'тмп'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.длина = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения значения поля {@link Купюра#толщина}
     *
     * @return возвращает толщина купюры
     */
    public double получитьТолщина() {
        return толщина;
    }

    /**
     * Метод присвоения значения полю {@link Купюра#толщина}
     *
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип монеты (копейка или рубль)
     */
    public void присвоитьТолщина(int номинальнаяСтоимость, String тип) {
        // Сформировать строку для поиска в двумерном массиве
        String строка = номинальнаяСтоимость + тип;

        // получить значение диаметра из двумерного массива и привести значение к типу 'double'
        double тмп = Double.parseDouble(МассивУтилиты.получитьИзДвумерногоМассива(списокКупюр, строка, ТОЛЩИНА));

        // если значение больше нуля, присвоить полю 'толщина' значение переменной 'тмп'
        // иначе вывести в консоль сообщение об ошибке
        if (тмп > 0) this.толщина = тмп;
        else КонсольПомошник.написатьСообщение(Ошибка.МЕНЬШЕ_ИЛИ_РАВНО_НУЛЮ);
    }

    /**
     * Метод получения форматированной строки с характеристиками купюры
     * Содержит данные полей:
     * - название {@link Купюра#имя}
     * - диаметр {@link Купюра#ширина}
     * - вес {@link Купюра#длина}
     * - толщина {@link Купюра#толщина}
     *
     * @return возвращает строку с информацией о экземпляре
     */
    public String получитьВсеПараметры() {
        return "Купюра " + получитьИмя() +
                ": ширина: " + получитьШирину() +
                ", длина: " + получитьДлину() +
                ", толщина: " + получитьТолщина();
    }

    @Override
    public String toString() {
        return получитьВсеПараметры();
    }
}
