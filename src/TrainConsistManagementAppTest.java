import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    @Test
    public void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(binarySearch(arr, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(binarySearch(arr, "BG205"));
    }
}