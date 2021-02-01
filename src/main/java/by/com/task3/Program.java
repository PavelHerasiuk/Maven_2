package by.com.task3;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Описание: SuffixingApp With Maven
 * Используйте maven для создания и управления простой программой Java с зависимостями.
 * Спецификация приложения:
 * Это приложение с суффиксами - небольшое Java-приложение, которое обращается к файлу конфигурации,
 * переименовывает набор файлов и переименовывает их, добавляя суффикс, указанный в той же конфигурации.
 * Детали:
 * Приложение должно прочитать файл конфигурации при запуске
 * Затем он должен убедиться, что все файлы из конфигурации существуют.
 * Затем он должен переименовать каждый файл, добавив суффикс из конфигурации к его имени
 * Он должен напечатать результаты переименования, например:   old_name -> new_name.
 * Шаги:
 * Создайте проект maven и укажите его настройки GAV, кодировку, уровень языка и т. Д.
 * Добавьте зависимость к некоторой библиотеке для чтения и анализа файлов JSON. (например, GSON)
 * Напишите код, реализующий спецификацию приложения.
 * Настройте проект maven для создания работающего jar-файла,содержащего приложение и его зависимости.
 */
public class Program {

    public static void renameFile() {
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            String suffix = model.getName();

            File file = new File("D:\\TestFile\\test.txt");    // создаем объект на файл test.txt
            String s = file.getName();
            //  исправить, как достать из название расширение файла
            StringBuilder newName = new StringBuilder(s);
            // исправить, как исправить  (s.length() - ".txt".length()
            newName.insert(s.length() - ".txt".length(), suffix);

            if (file.exists()) {                                    // если файл существует, то переименовываем его
                file.renameTo(new File("D:\\TestFile\\" + newName.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Program.renameFile();
    }
}

