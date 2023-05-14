package Homework5;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(Arrays.asList("Peter", "John", "Julie", "Mark", "Mark", "Debi",
                "Peter", "John", "John", "Debi", "John", "John", "Peter"));
        HashMap<String, Integer> namesMap = new HashMap<>();
        System.out.println(names);
        for (int i = 0; i < names.size(); i++) {
            if (namesMap.containsKey(names.get(i))) {
                namesMap.put(names.get(i), namesMap.get(names.get(i)) + 1);
            } else {
                namesMap.put(names.get(i), 1);
            }
        }
        Map<String, Integer> sortedNamesMap = namesMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        for (String key : sortedNamesMap.keySet()) {
            System.out.printf("%s\t -> \t%s%n", key, namesMap.get(key));
        }

    }
}
