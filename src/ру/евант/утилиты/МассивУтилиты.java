package ру.евант.утилиты;

import ру.евант.вв.КонсольПомошник;
import ру.евант.константы.Ошибка;

/**
 * <b>Класс МассивУтилита</b>
 * Класс методы для работы с массивами
 *
 * @version 1.0
 * @autor Евсеев Антон Владимирович
 */
public final class МассивУтилиты {

    /**
     * Метод получения из массива данные из яцейки [строка][столбец]
     * Для корректно работы метода ячейка нулевого индекса каждого столбца должна содержать уникальную строку
     *
     * Пример массива
     * String[][] сотрудник{
     *            0          1             2              3        индексы
     *      {"Сотрудник1", "Иван",     "Иванович",    "Иванов"},      0
     *      {"Сотрудник2", "Петр",     "Петрович",    "Петров"},      1
     *      {"Сотрудник3", "Сергей",   "Сергеевич",   "Сергеев"}      2
     * }
     *
     * Пример запроса:
     * получитьИзДвумерногоМассива(сотрудник, Сотрудник3, 2);
     * метод вернет строку "Сергеевич"
     *
     * @param массив  - двумерный массив
     * @param строка  - строка
     * @param столбец - индекс столбца двумерного массива
     * @return возвращает строку типа String содержащую запрашиваемые данные
     */
    public static String получитьИзДвумерногоМассива(String[][] массив, String строка, int столбец) {
        String результат = "";
        for (String[] строки : массив) {        // внешний массив
            for (String колонка : строки) {     // вложенный массив
                if (колонка.contains(строка)) { // если в колонке содержатся данные
                    результат = строки[столбец];
                    break;
                }
            }
        }
        if (результат.length() == 0) КонсольПомошник.написатьСообщение(Ошибка.ДАННЫЕ_ОТСУТСТВУЮТ);
        return результат;
    }

    /**
     * Метод проверки есть ли в массиве запрашиваемый элемент
     * @param массив - массив в котором производим поиск
     * @param запрос - что ищем в массиве
     *
     * @return возвращает true, есть такой тип имеется в массиве
     * @return возвращает false, есть такой тип отсутствует в массиве
     */
    public static boolean естьВМассиве(String[] массив, String запрос) {

        for (String элемент : массив) {
            if (элемент.equals(запрос)) return true;
        }
        return false;
    }
}
