package ру.евант.вв;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b>Класс КонсольПомошник</b>
 * Класс содержит статические методы для обработки:
 * пользовательского ввода;
 * вывода данных в консоль
 *
 * @version 1.0
 * @autor Евсеев Антон Владимирович
 */
public final class КонсольПомошник {
    private static final BufferedReader считывательБуфера = new BufferedReader(new InputStreamReader(System.in));

    /* Вывод пустой строки в консоль */
    public static void нс() {
        System.out.println();
    }

    /* Вывод строки в консоль */
    public static void написатьСообщение(String сообщение) {
        System.out.println(сообщение);
    }

    /* Прочесть данные введенные пользователем, тип данных строка 'String' */
    public static String прочестьСтроку() {
        while (true) {
            try {
                String буфер = считывательБуфера.readLine();
                if (буфер != null) return буфер;
            } catch (IOException e){
                написатьСообщение("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }

    /* Прочесть данные введенные пользователем, тип данных вещественное число 'double' */
    public static double прочестьЧислоВещественное(){
        while (true){
            try {
                return Double.parseDouble(прочестьСтроку().trim());
            } catch (NumberFormatException e){
                написатьСообщение("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }

    /* Прочесть данные введенные пользователем, тип данных целое число 'int' */
    public static int прочестьЧислоЦелое(){
        while (true){
            try {
                return Integer.parseInt(прочестьСтроку().trim());
            } catch (NumberFormatException e){
                написатьСообщение("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}
