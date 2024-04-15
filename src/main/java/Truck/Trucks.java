package Truck;

import java.util.logging.Logger;

public class Trucks {

    private static final Logger LOGGER = Logger.getLogger(Trucks.class.getName());

    public static char[][] createTruck() {
        int rows = 7;
        int columns = 8;

        char[][] truck = new char[rows][columns];
        LOGGER.info("Машина создана размером" + rows + "X" + columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == rows - 1 || j == 0 || j == columns - 1) {
                    truck[i][j] = '+';
                    LOGGER.info("Граница машина");
                } else {
                    truck[i][j] = ' ';
                }
                LOGGER.info("Рабочая зона машины");
            }
        }

        return truck;
    }

    public static void printTruck(char[][] truck) {
        for (int i = 0; i < truck.length; i++) {
            for (int j = 0; j < truck[i].length; j++) {
                System.out.print(truck[i][j]);
            }
            LOGGER.info("Рисуем тачку");
            System.out.println();
        }
    }
}
