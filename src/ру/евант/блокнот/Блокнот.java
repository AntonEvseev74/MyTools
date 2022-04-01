package ру.евант.блокнот;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Блокнот extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Блокнот());
    }

    JMenuBar менюБар = new JMenuBar();
    private JTabbedPane вкладки = new JTabbedPane();
    private JFileChooser выбратьФайл = new JFileChooser();

    public Блокнот() {
        создатьМенюФайл();
        создатьМенюШифр();
        создатьМенюПомощь();
        создатьГлавноеОкно(менюБар);
    }

    private void создатьГлавноеОкно(JMenuBar менюБар) {
        JFrame окно = new JFrame("Блокнот");
        окно.setSize(800, 600);
        окно.setJMenuBar(менюБар);
        окно.add(вкладки);
        окно.setResizable(false);
        окно.setLocationRelativeTo(null);
        окно.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        окно.setVisible(true);
    }

    private void создатьМенюШифр() {
        JMenu менюШифр = new JMenu("Шифр");
        JMenuItem зашифровать = new JMenuItem("Зашифровать");
        JMenuItem расшифровать = new JMenuItem("Расшифровать");

        менюШифр.add(зашифровать);
        менюШифр.add(расшифровать);
        менюБар.add(менюШифр);

        //
        зашифровать.addActionListener(e -> {
            зашифроватьФайл(); // переделать
        });
        расшифровать.addActionListener(e -> {
            расшифроватьФайл(); // переделать
        });
    }

    private void создатьМенюФайл() {
        JMenu менюФайл = new JMenu("Файл");
        JMenuItem новыйФайл = new JMenuItem("Создать");
        JMenuItem открытьФайл = new JMenuItem("Открыть");
        JMenuItem сохранитьФайл = new JMenuItem("Сохранить");
        JMenuItem сохранитьФайлКак = new JMenuItem("Сохранить как");
        JMenuItem закрытьВкладку = new JMenuItem("Закрыть вкладку");
        JMenuItem отступ = new JMenuItem(" ");
        JMenuItem выход = new JMenuItem("Выйти");

        менюФайл.add(новыйФайл);
        менюФайл.add(открытьФайл);
        менюФайл.add(сохранитьФайл);
        менюФайл.add(сохранитьФайлКак);
        менюФайл.add(закрытьВкладку);
        менюФайл.add(отступ);
        менюФайл.add(выход);
        менюБар.add(менюФайл);

        новыйФайл.addActionListener(e -> {
            создатьФайл();
        });

        сохранитьФайл.addActionListener(e -> {
            сохранитьФайл();
        });

        сохранитьФайлКак.addActionListener(e -> {
            сохранитьФайлКак();
        });

        открытьФайл.addActionListener(e -> {
            открытьФайл();
        });

        закрытьВкладку.addActionListener(e -> {
            закрытьВкладку();
        });

        выход.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void создатьМенюПомощь() {
        JMenu менюПомощь = new JMenu("Помощь");
        JMenuItem оПрограмме = new JMenuItem("О программе");

        менюПомощь.add(оПрограмме);
        менюБар.add(менюПомощь);

        оПрограмме.addActionListener(e -> {
            JOptionPane.showMessageDialog(Блокнот.this,
                    "<html><h2>Блокнот</h2><i>это просто блокнот для заметок</i>");
        });
    }

    private void создатьФайл() {
        Страница страница = new Страница(new JTextArea(), false);
        вкладки.addTab("Новый " + страница.получитьСчетчик(), страница);
    }

    private void сохранитьФайл() {
        Страница текст = (Страница) вкладки.getSelectedComponent();
        String вывод = текст.получитьТекст();

        if (вкладки.getSelectedComponent() != null) {
            if (текст.этоОткрыто()) {
                File файл = new File(текст.получитьПуть());
                записатьВФайл(файл, вывод);
            } else {
                выбратьФайл.showSaveDialog(null);
                File файл = выбратьФайл.getSelectedFile();
                записатьВФайл(файл, вывод);
            }
        }
    }

    private void сохранитьФайлКак() {
        if (вкладки.getSelectedComponent() != null) {
            Страница текст = (Страница) вкладки.getSelectedComponent();
            String вывод = текст.получитьТекст();

            выбратьФайл.showSaveDialog(null);
            File файл = выбратьФайл.getSelectedFile();
            записатьВФайл(файл, вывод);
        }
    }

    private void открытьФайл() {
        выбратьФайл.showOpenDialog(null);
        File файл = выбратьФайл.getSelectedFile();
        try {
            String ввод = new String(Files.readAllBytes(Paths.get(файл.getAbsolutePath())));

            JTextArea текст = new JTextArea(ввод);
            Страница страница = new Страница(текст, файл.getAbsolutePath(), true);
            вкладки.add(файл.getName(), страница);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void закрытьВкладку() {
        int активнаяВкладкак = вкладки.getSelectedIndex();
        if (активнаяВкладкак >= 0) {
            String текст = вкладки.getSelectedComponent().toString();
            if (текст.length() > 0 && текст.length() != 1221) {
                //System.out.println(текст.length());
                сохранитьФайл();
            }
            вкладки.removeTabAt(активнаяВкладкак);
        }
    }

    private void записатьВФайл(File файл, String текст) {
        try {
            FileOutputStream записывательФайла = new FileOutputStream(файл);
            записывательФайла.write(текст.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // шифр
    private void зашифроватьФайл() {

        Страница текст = (Страница) вкладки.getSelectedComponent();
        String вывод = текст.получитьТекст();

        if (вкладки.getSelectedComponent() != null) {
            if (текст.этоОткрыто()) {
                File файл = new File(текст.получитьПуть());
                вывод = Шифр.зашифроватьТекст(вывод, файл.getName());
                записатьВФайл(файл, вывод);
            } else {
                выбратьФайл.showSaveDialog(null);
                File файл = выбратьФайл.getSelectedFile();
                записатьВФайл(файл, вывод);
            }
        }
    }

    // шифр
    private void расшифроватьФайл() {
        выбратьФайл.showOpenDialog(null);
        File файл = выбратьФайл.getSelectedFile();
        try {
            String ввод = new String(Files.readAllBytes(Paths.get(файл.getAbsolutePath())));
            ввод = Шифр.расшифроватьТекст(ввод, файл.getName());

            JTextArea текст = new JTextArea(ввод);

            Страница страница = new Страница(текст, файл.getAbsolutePath(), true);
            вкладки.add(файл.getName(), страница);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
