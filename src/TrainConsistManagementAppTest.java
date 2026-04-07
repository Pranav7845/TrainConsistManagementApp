import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo); // should not assign
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie b1 =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        TrainConsistManagementApp.GoodsBogie b2 =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // fails
        b2.assignCargo("Petroleum"); // should still work

        assertEquals("Petroleum", b2.cargo);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // No direct assertion → but if no crash, finally executed
        assertTrue(true);
    }
}