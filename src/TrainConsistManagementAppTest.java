import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    String trainRegex = "TRN-\\d{4}";
    String cargoRegex = "PET-[A-Z]{2}";

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(trainRegex, "TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(trainRegex, "TRAIN12"));
        assertFalse(Pattern.matches(trainRegex, "TRN12A"));
        assertFalse(Pattern.matches(trainRegex, "1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(cargoRegex, "PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(cargoRegex, "PET-ab"));
        assertFalse(Pattern.matches(cargoRegex, "PET123"));
        assertFalse(Pattern.matches(cargoRegex, "AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(trainRegex, "TRN-123"));
        assertFalse(Pattern.matches(trainRegex, "TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(cargoRegex, "PET-Ab"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(trainRegex, ""));
        assertFalse(Pattern.matches(cargoRegex, ""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(Pattern.matches(trainRegex, "TRN-1234XYZ"));
        assertFalse(Pattern.matches(cargoRegex, "PET-ABCD"));
    }
}