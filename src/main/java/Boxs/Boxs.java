package Boxs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Boxs {
    private static final Logger LOGGER = Logger.getLogger(Boxs.class.getName());

    public static List<int[][]> readBoxsArrays() {
        String filePath = "src/main/resources/posylka";

        List<int[][]> arrays = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> lines = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                } else {
                    arrays.add(convertToMatrix(lines));
                    lines.clear();
                }
            }

            if (!lines.isEmpty()) {
                arrays.add(convertToMatrix(lines));
            }
        } catch (IOException e) {
            LOGGER.severe("ОШибка:  " + e.getMessage());
        }

        LOGGER.info("Нашли посылку " + arrays.size());
        return arrays;
    }

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
