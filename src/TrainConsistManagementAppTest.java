import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSorting() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        Collections.sort(bogies,
                (TrainConsistManagementApp.Bogie b1,
                 TrainConsistManagementApp.Bogie b2)
                        -> b1.capacity - b2.capacity
        );

        assertEquals(24, bogies.get(0).capacity);
        assertEquals(56, bogies.get(1).capacity);
        assertEquals(72, bogies.get(2).capacity);
    }
}