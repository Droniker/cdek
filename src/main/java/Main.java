import Boxs.Boxs;
import Truck.Trucks;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем машину
        char[][] truck = Trucks.createTruck();

        // Получаем список массивов из класса Boxs
        List<int[][]> boxsArrays = Boxs.readBoxsArrays();

        // Помещаем массивы из Boxs в машину
        putBoxsInTruck(truck, boxsArrays);

        // Выводим машину с посылками
        Trucks.printTruck(truck);
    }

    // Метод для помещения массивов из Boxs в машину
    public static void putBoxsInTruck(char[][] truck, List<int[][]> boxsArrays) {
        // Определяем начальную строку для размещения массива из Boxs
        int startRow = truck.length-1;

        // Помещаем каждый массив из Boxs в машину
        for (int[][] boxsArray : boxsArrays) {
            // Находим размеры массива из Boxs
            int rows = boxsArray.length;
            int columns = boxsArray[0].length;

            // Находим границы занятой области в машине
            int occupiedRow = startRow;
            for (int i = truck.length - 1; i >= startRow; i--) {
                if (isRowEmpty(truck[i])) {
                    occupiedRow = i + 1;
                    break;
                }
            }

            // Проверяем, может ли массив из Boxs поместиться в машину
            if (rows <= occupiedRow && columns <= truck[0].length - 2) {
                // Помещаем массив из Boxs в машину
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
//                        if (truck[occupiedRow - rows + i][j + 1] == '+') { // Проверяем, является ли символ плюсом
//                            continue; // Если символ плюс, пропускаем итерацию
//                        }
                        truck[occupiedRow - rows + i][j + 1] = (char) ('0' + boxsArray[i][j]); // Здесь используется '0' + для преобразования числа в символ
                    }
                }
            } else {
                System.out.println("Массив из Boxs слишком большой для машины");
                // Прерываем цикл, если массив не может поместиться в машину
                break;
            }

            // Обновляем начальную строку для следующего массива из Boxs
            startRow = occupiedRow - rows;
        }
    }

    // Метод для проверки строки на наличие пустых клеток
    public static boolean isRowEmpty(char[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != ' ' ) { // Учитываем символ плюса как пустой
                return false;
            }
        }
        return true;
    }
    public static boolean containsPlus(char[] row) {
        for (char cell : row) {
            if (cell == '+') {
                return true;
            }
        }
        return false;
    }
}
