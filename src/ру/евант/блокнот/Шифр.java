package ру.евант.блокнот;

public class Шифр {

    public static String зашифроватьТекст(String текст, String ключ){
        char[] массив = текст.toCharArray();
        char[] зашифрованыйТекст = new char[массив.length];
        for (int i = 0; i < массив.length; i++) {
            зашифрованыйТекст[i] = (char) (массив[i] + ключ.length());
        }
        return new String(зашифрованыйТекст);
    }

    public static String расшифроватьТекст(String текст, String ключ){
        char[] массив = текст.toCharArray();
        char[] расшифрованыйТекст = new char[массив.length];
        for (int i = 0; i < массив.length; i++) {
            расшифрованыйТекст[i] = (char) (массив[i] - ключ.length());
        }
        return new String(расшифрованыйТекст);
    }
}
