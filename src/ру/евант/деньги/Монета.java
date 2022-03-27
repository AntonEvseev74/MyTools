package ру.евант.деньги;

import ру.евант.вв.КонсольПомошник;
import ру.евант.константы.Ошибка;
import ру.евант.утилиты.МассивУтилиты;

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

public final class Монета {
    /**
     * <b>Константы</b>
     * /** Константа для поиска монет типа - копейка
     */
    public static final String КОПЕЙКА = "коп";

    /**
     * Константа для поиска монет типа - рубль
     */
    public static final String РУБЛЬ = "руб";

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
     * <p>
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
            {"1коп.", "15.5", "1.5", "1.25"},   // 0 индекс внешнего массива
            {"5коп.", "18.5", "2.6", "1.45"},   // 1 индекс внешнего массива
            {"10коп.", "17.5", "1.95", "1.25"}, // 2 индекс внешнего массива
            {"50коп.", "19.5", "2.9", "1.5"},   // 3 индекс внешнего массива
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
        return new Монета(номинальнаяСтоимость, тип);
    }

    /**
     * Метод получения данных из массива типа String {@link Монета#списокМонет}
     * В методе выполняется обход массива <i>String[][] массив</i>
     * для получения данных из ячейки - <i>int номинальнаяСтоимость, String тип</i>
     * указанного столбца - <i>int столбец</i>
     *
     * @param столбец              - индекс столбца двумерного массива
     * @param массив               - двумерный массив
     * @param номинальнаяСтоимость - номинальная стоимость
     * @param тип                  - тип (копейка имлм рубль)
     * @return возвращает строку типа String содержащую запрашиваемые данные
     */
    private String получитьИзДвумерногоМассива(int столбец, String[][] массив, int номинальнаяСтоимость, String тип) {
        String результат = "";
        String данные = номинальнаяСтоимость + тип;
        for (String[] строки : массив) {        // внешний массив
            for (String колонка : строки) {     // вложенный массив
                if (колонка.contains(данные)) { // если в колонке содержатся данные
                    результат = строки[столбец];
                    break;
                }
            }
        }
        if (результат.length() == 0) КонсольПомошник.написатьСообщение(Ошибка.ДАННЫЕ_ОТСУТСТВУЮТ);
        return результат;
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
        this.имя = получитьИзДвумерногоМассива(ИМЯ, списокМонет, номинальнаяСтоимость, тип);
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
        String строка = номинальнаяСтоимость+тип;

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
        String строка = номинальнаяСтоимость+тип;

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
        String строка = номинальнаяСтоимость+тип;

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
     * @return возвращает строку с инйормацие о экземпляре
     */
    public String кСтроке() {
        return получитьИмя() +
                " \n\tдиаметр: " + получитьДиаметр() +
                "\n\tвес: " + получитьВес() +
                "\n\tтолщина:" + получитьТолщина();
    }
}
