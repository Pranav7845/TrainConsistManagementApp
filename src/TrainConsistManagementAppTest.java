import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private boolean search(String[] arr, String key) {
        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test(expected = IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty() {
        search(new String[]{}, "BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        assertTrue(search(new String[]{"BG101","BG205"}, "BG101"));
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        assertTrue(search(new String[]{"BG101","BG205","BG309"}, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        assertFalse(search(new String[]{"BG101","BG205","BG309"}, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        assertTrue(search(new String[]{"BG101"}, "BG101"));
    }
}