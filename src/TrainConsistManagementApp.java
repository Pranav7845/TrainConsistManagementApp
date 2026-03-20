import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("UC5 - Preserve Insertion Order of Bogies");

        // Create LinkedHashSet
        Set<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Try adding duplicate
        formation.add("Sleeper");

        // Display formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        System.out.println("\nDuplicates are not allowed, order is preserved.");
    }
}