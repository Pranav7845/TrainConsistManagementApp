import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void testBubbleSort_CorrectOrder() {
        int[] input = {72, 56, 24, 70, 60};
        int[] result = sort(input);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, result);
    }

    @Test
    public void testBubbleSort_AlreadySorted() {
        int[] input = {10, 20, 30};
        int[] result = sort(input);

        assertArrayEquals(new int[]{10, 20, 30}, result);
    }

    @Test
    public void testBubbleSort_ReverseOrder() {
        int[] input = {5, 4, 3, 2, 1};
        int[] result = sort(input);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
    }

    @Test
    public void testBubbleSort_SingleElement() {
        int[] input = {10};
        int[] result = sort(input);

        assertArrayEquals(new int[]{10}, result);
    }

    @Test
    public void testBubbleSort_EmptyArray() {
        int[] input = {};
        int[] result = sort(input);

        assertArrayEquals(new int[]{}, result);
    }
}