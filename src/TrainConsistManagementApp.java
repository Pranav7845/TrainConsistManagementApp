import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("UC3 - Track Unique Bogie IDs");

        // Create HashSet
        Set<String> bogies = new HashSet<>();

        // Add bogie IDs (with duplicates)
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries
        bogies.add("BG101");
        bogies.add("BG102");

        // Display result
        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogies);

        System.out.println("\nDuplicates are automatically removed.");
    }
}