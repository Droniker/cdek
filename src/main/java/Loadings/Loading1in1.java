package Loadings;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

import Truck.Trucks;

public class Loading1in1 {
    private static final Logger LOGGER = Logger.getLogger(Loading1in1.class.getName());

    public static void parkTrucks(List<int[][]> boxsArrays) {
        List<char[][]> trucks = new ArrayList<>();

        for (int[][] boxsArray : boxsArrays) {
            char[][] truck = Trucks.createTruck();
            putBoxsInTruck(truck, boxsArray);
            trucks.add(truck);
        }

        for (int i = 0; i < trucks.size(); i++) {
            LOGGER.info("Машина номер " + (i + 1) + ":");
            Trucks.printTruck(trucks.get(i));
        }
    }

    private static void putBoxsInTruck(char[][] truck, int[][] boxsArray) {
        int rows = boxsArray.length;
        int columns = boxsArray[0].length;

        int occupiedRow = truck.length - 1;
        for (int i = truck.length - 1; i >= 0; i--) {
            if (isRowEmpty(truck[i])) {
                occupiedRow = i + 1;
                break;
            }
        }

        if (rows <= occupiedRow && columns <= truck[0].length - 2) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (truck[occupiedRow - rows + i][j + 1] == ' ') {
                        truck[occupiedRow - rows + i][j + 1] = (char) ('0' + boxsArray[i][j]);
                    }
                }
            }
        } else {
            LOGGER.warning("каробка слишком велика ");
        }
    }

    private static boolean isRowEmpty(char[] row) {
        for (char cell : row) {
            if (cell != ' ') {
                return false;
            }
        }
        return true;
    }
}
