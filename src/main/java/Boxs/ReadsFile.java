package Boxs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadsFile {
    public static void rearsFile(String[] boxs) {
        String filePath = "src/test/resources/posylka.txt";

        // Создаем список для хранения строк из файла
        List<String> lines = readFile(filePath);

        // Передаем список в метод processData для обработки
        processData(lines);
    }

    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            // Читаем файл построчно и добавляем строки в список
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }

        return lines;
    }

    public static void processData(List<String> lines) {
        // Пример обработки: выводим строки на консоль
        for (String line : lines) {
            System.out.println(line);
        }
    }
}