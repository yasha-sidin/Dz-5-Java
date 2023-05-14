import java.util.HashMap;
import java.util.Map;
public class Ex000 {
    public static void main(String[] args) {
        ex0();

    }

    private static void ex0() {
        Map<String, String> employeeMap = new HashMap<>(20);
        employeeMap.put("1234", "Ivanov");
        employeeMap.put("1432", "Petrov");
        employeeMap.put("3234", "Romancev");

        for (Map.Entry<String, String> entry : employeeMap.entrySet()) {
            System.out.printf("%s\t -> \t%s%n", entry.getKey(), entry.getValue());
        }

        for (String key : employeeMap.keySet()) {
            System.out.printf("%s\t -> \t%s%n", key, employeeMap.get(key));
        }

        Map<Integer, String> testMap = Map.of(
                12, "A",
                43, "B",
                65, "Y"
        ); // fixed Map
        Map<Integer, String> testMap2 = Map.ofEntries(
                Map.entry(246, "4666"),
                Map.entry(5656, "122")
        );
    }

}
