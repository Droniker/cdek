package Loadings;

import Truck.Trucks;

import java.util.List;

public class Loading1in1 {
//    private static final Logger LOGGER=  LoggerFactory.getLogger(Loading1in1.class);
    public static void parkTrucks(List<int[][]> boxsArrays) {

        // Создаем машину для каждой посылки и помещаем ее в машину
        for (int i = 0; i < boxsArrays.size(); i++) {
            int[][] boxsArray = boxsArrays.get(i);
            char[][] truck = Trucks.createTruck();
            putBoxsInTruck(truck, boxsArray);
            System.out.println("Trucks " + (i + 1) + ":");
            Trucks.printTruck(truck);
            System.out.println();
        }
//        LOGGER.info("Все машины поданы");
    }

    private static void putBoxsInTruck(char[][] truck, int[][] boxsArray) {
        int rows = boxsArray.length;
        int columns = boxsArray[0].length;

        // Находим границы занятой области в машине
        int occupiedRow = truck.length - 1;
        for (int i = truck.length - 1; i >= 0; i--) {
            if (isRowEmpty(truck[i])) {
                occupiedRow = i + 1;
                break;
            }

        }

        // Проверяем, может ли массив из Boxs поместиться в машину
        if (rows <= occupiedRow && columns <= truck[0].length - 2) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (truck[occupiedRow - rows + i][j + 1] == ' ') {
                        truck[occupiedRow - rows + i][j + 1] = (char) ('0' + boxsArray[i][j]);
                    }
                }
            }
//            LOGGER.info("Упаковали Бокс в Машину");
        }
        else {
            System.out.println("Массив из Boxs слишком большой для машины");
//            LOGGER.error("Слишком большая посылка нужна тачка побольше");
        }
    }
    // Метод для проверки строки на наличие пустых клеток
    private static boolean isRowEmpty(char[] row) {
        for (char cell : row) {
            if (cell != ' ') {
                return false;
            }
        }
        return true;
    }
}