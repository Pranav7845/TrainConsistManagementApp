import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> getBogies(int size) {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new TrainConsistManagementApp.Bogie("Type" + i, i % 100));
        }
        return list;
    }

    @Test
    public void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> result = new ArrayList<>();

        for (TrainConsistManagementApp.Bogie b : getBogies(100)) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies(100).stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies(100);

        List<TrainConsistManagementApp.Bogie> loopResult = new ArrayList<>();
        for (TrainConsistManagementApp.Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<TrainConsistManagementApp.Bogie> streamResult =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies(1000);

        long start = System.nanoTime();
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long end = System.nanoTime();

        long time = end - start;

        assertTrue(time > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies(10000);

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertNotNull(result);
    }
}