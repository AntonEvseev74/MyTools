package ру.евант.грин;

import javax.swing.*;
import java.io.Serializable;

// Создать конструкторы на создание окна целиком

public class Кадр extends JFrame implements Serializable {
    private static int ВЫЙТИ_И_ЗАКРЫТЬ = WindowConstants.EXIT_ON_CLOSE;

    private JFrame кадр;

    public Кадр()  {
        кадр = new JFrame();
    }

    public Кадр(String имя)  {
        кадр = new JFrame(имя);
    }

    public Кадр(String имя, int ширина, int высота)  {
        кадр = new JFrame(имя);
        setSize(ширина, высота);
    }

    public Кадр(String имя, int ширина, int высота, boolean этоВидимое)  {
        кадр = new JFrame(имя);
        setSize(ширина, высота);
        setVisible(этоВидимое);
    }

    public Кадр(String имя, int ширина, int высота, boolean закрытиеПоУмолчанию, boolean этоВидимое)  {
        кадр = new JFrame(имя);
        setSize(ширина, высота);
        setVisible(этоВидимое);

        if (закрытиеПоУмолчанию) setDefaultCloseOperation(ВЫЙТИ_И_ЗАКРЫТЬ);
    }



}
