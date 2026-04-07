import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testException_ValidCapacityCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertEquals(72, bogie.capacity);
    }

    @Test(expected = TrainConsistManagementApp.InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws Exception {
        new TrainConsistManagementApp.PassengerBogie("Sleeper", -10);
    }

    @Test(expected = TrainConsistManagementApp.InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws Exception {
        new TrainConsistManagementApp.PassengerBogie("Sleeper", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new TrainConsistManagementApp.PassengerBogie("Sleeper", -5);
            fail("Exception not thrown");
        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        assertEquals("AC Chair", bogie.type);
        assertEquals(56, bogie.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        TrainConsistManagementApp.PassengerBogie b2 =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}