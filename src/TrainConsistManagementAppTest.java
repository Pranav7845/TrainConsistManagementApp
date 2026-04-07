import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        Arrays.sort(input);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General","Luxury","Sleeper"},
                input
        );
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        Arrays.sort(input);

        assertArrayEquals(
                new String[]{"AC Chair","General","Luxury","Sleeper"},
                input
        );
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        Arrays.sort(input);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General"},
                input
        );
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        Arrays.sort(input);

        assertArrayEquals(
                new String[]{"AC Chair","General","Sleeper","Sleeper"},
                input
        );
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        Arrays.sort(input);

        assertArrayEquals(
                new String[]{"Sleeper"},
                input
        );
    }
}