

import java.util.List;
import java.util.logging.Logger;

import Loadings.Loading1in1;
import Boxs.Boxs;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        List<int[][]> boxsArrays = Boxs.readBoxsArrays();
        Loading1in1.parkTrucks(boxsArrays);
        LOGGER.info("Метод завершился");
    }
}
