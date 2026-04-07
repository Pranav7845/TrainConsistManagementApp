import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.GoodsBogie> getValidBogies() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        return list;
    }

    @Test
    public void testSafety_AllBogiesValid() {
        boolean result = getValidBogies().stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        assertTrue(result);
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"));

        boolean result = list.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        assertFalse(result);
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        list.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        boolean result = list.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        assertTrue(result);
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")); // invalid

        boolean result = list.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        assertFalse(result);
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();

        boolean result = list.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        assertTrue(result); // empty → true
    }
}