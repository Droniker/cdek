//import org.assertj.core.api.Assumptions;
//import org.testng.annotations.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
//
//public class PackageManualTest {
//
//    @Test
//    public void ManualFistTest() {
//        int[][] res ={{9,9,9,0,0,0}};
//        int[][] result = PackageManual.ManualOneCarOnePackege(999);
//        int[][] result2 = PackageManual.ManualOneCarOnePackege(666);
//        List<Object> sumres = Arrays.asList(result,result2);
//        assertThat(sumres).isEqualTo(res);
//    }
//
//    @Test
//    public void ManualThrownTest() {
//        Throwable thrown = catchThrowable(() -> PackageManual.ManualOneCarOnePackege(0));
//        Assumptions.assumeThat(thrown).hasMessageContaining("Нет посылок, я на чиле");
//    }
//
//    @Test
//    public void ManualToLongTest1() {
//        Throwable thrown = catchThrowable(() -> PackageManual.ManualOneCarOnePackege(1111111));
//        Assumptions.assumeThat(thrown).hasMessageContaining("Закажи фуру побольше");
//    }
//}
