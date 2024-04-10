package Boxs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Boxs {
    // Метод для чтения данных из файла и сохранения в двумерный массив
    public static List<int[][]> readBoxsArrays() {
        String filePath = "src/main/resources/posylka";

        // Создаем список для хранения матриц из файла
        List<int[][]> arrays = new ArrayList<>();

        try {
            // Создаем объект FileReader для чтения файла
            FileReader fileReader = new FileReader(filePath);

            // Создаем объект BufferedReader для эффективного чтения строк
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            List<String> lines = new ArrayList<>();

            // Читаем файл построчно
            while ((line = bufferedReader.readLine()) != null) {
                // Если строка не пустая, добавляем ее в список строк
                if (!line.isEmpty()) {
                    lines.add(line);
                } else {
                    // Если встречаем пустую строку, преобразуем список строк в матрицу и добавляем ее в список матриц
                    arrays.add(convertToMatrix(lines));
                    lines.clear();
                }
            }

            // Добавляем последнюю матрицу, если файл не оканчивается пустой строкой
            if (!lines.isEmpty()) {
                arrays.add(convertToMatrix(lines));
            }

            // Закрываем ресурсы
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrays;
    }

    // Метод для преобразования списка строк в двумерный массив
    private static int[][] convertToMatrix(List<String> lines) {
        int rows = lines.size();
        int columns = lines.get(0).length();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        return matrix;
    }
}


//
//public class Boxs {
//    public static void main(String[] args) {
//        // Путь к файлу
//        String filePath = "src/main/resources/posylka";
//
//        // Создаем список для хранения строк из файла
//        List<String> lines = new ArrayList<>();
//
//        try {
//            // Создаем объект FileReader для чтения файла
//            FileReader fileReader = new FileReader(filePath);
//
//            // Создаем объект BufferedReader для эффективного чтения строк
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line;
//
//            // Читаем файл построчно и добавляем строки в список
//            while ((line = bufferedReader.readLine()) != null) {
//                lines.add(line);
//            }
//
//            // Закрываем ресурсы
//            bufferedReader.close();
//            fileReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Определяем размеры массива
//        int rows = lines.size();
//        int columns = 0;
//        for (String line : lines) {
//            String[] numbers = line.trim().split("\\s+");
//            if (numbers.length > columns) {
//                columns = numbers.length;
//            }
//        }
//
//        // Создаем двумерный массив
//        int[][] array = new int[rows][columns];
//
//        // Заполняем массив значениями из списка
//        for (int i = 0; i < rows; i++) {
//            String[] numbers = lines.get(i).trim().split("\\s+");
//            for (int j = 0; j < columns && j < numbers.length; j++) {
//                array[i][j] = Integer.parseInt(numbers[j]);
//            }
//        }
//
//        // Выводим содержимое массива (для проверки)
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }
//    }
//}
