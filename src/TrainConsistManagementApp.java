import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        // Create HashMap
        Map<String, Integer> capacityMap = new HashMap<>();

        // Add bogies with capacity
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC", 50);
        capacityMap.put("FirstClass", 40);
        capacityMap.put("Cargo", 100);

        // Display all bogies with capacity
        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
        }

        // Access specific bogie
        System.out.println("\nCapacity of Sleeper: " + capacityMap.get("Sleeper"));

        System.out.println("\nUC6 operations completed successfully...");
    }
}