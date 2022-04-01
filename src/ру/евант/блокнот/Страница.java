package ру.евант.блокнот;

import javax.swing.*;

public class Страница extends JScrollPane {

    private static int счетчик = 0;

    private boolean этоОткрыто;

    private String путь;
    private final JTextArea текст;

    private String ключ = ""; // для шифрования

    public Страница(JTextArea текст, boolean этоОткрыто) {
        super(текст);
        this.текст = текст;
        this.этоОткрыто = этоОткрыто;
        счетчик++;
    }

    public Страница(JTextArea текст, String путь, boolean этоОткрыто) {
        super(текст);
        this.текст = текст;
        this.путь = путь;
        this.этоОткрыто = этоОткрыто;
        счетчик++;
    }
    public Страница(JTextArea текст, boolean этоОткрыто, String ключ) {
        super(текст);
        this.текст = текст;
        this.этоОткрыто = этоОткрыто;
        this.ключ = ключ;
        счетчик++;
    }

    public Страница(JTextArea текст, String путь, boolean этоОткрыто, String ключ) {
        super(текст);
        this.текст = текст;
        this.путь = путь;
        this.этоОткрыто = этоОткрыто;
        this.ключ = ключ;
        счетчик++;
    }

    public String получитьТекст() {
        return текст.getText();
    }

    public String получитьПуть() {
        return путь;
    }

    public boolean этоОткрыто() {
        return этоОткрыто;
    }

    public int получитьСчетчик() {
        return счетчик;
    }
}
