package Truck;

public class Trucks {
    public static void main(String[] args) {
        // Создаем машину размером 8x8
        char[][] truck = createTruck();

        // Выводим машину
        printTruck(truck);
    }

    // Метод для создания машины
    public static char[][] createTruck() {
        // Размеры машины
        int rows = 7;
        int columns = 8;

        // Создаем двумерный массив для машины
        char[][] truck = new char[rows][columns];

        // Заполняем массив
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Проверяем, находится ли текущая ячейка на границе машины, кроме нижней границы
                if (i == rows - 1 || j == 0 || j == columns - 1) {
                    // Если на границе, то ставим "+"
                    truck[i][j] = '+';
                } else {
                    // В противном случае оставляем пробел, обозначающий пустое пространство внутри машины
                    truck[i][j] = ' ';
                }
            }
        }

        // Возвращаем созданный массив
        return truck;
    }

    // Метод для вывода машины на экран
    public static void printTruck(char[][] truck) {
        for (int i = 0; i < truck.length; i++) {
            for (int j = 0; j < truck[i].length; j++) {
                System.out.print(truck[i][j]);
            }
            System.out.println();
        }
    }
}
