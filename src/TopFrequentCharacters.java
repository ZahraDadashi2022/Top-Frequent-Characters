import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopFrequentCharacters {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>(Arrays.asList("c", "a", "a", "b"
                , "b", "c", "c", "c", "a", "b", "c"));

        for (String i :
                topFrequent(input)) {
            System.out.println(i);
        }

    }

    static String[] topFrequent(List<String> input) {
        Map<String, Long> InputHashMap = (Map<String, Long>) input.stream().sorted()
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        Comparator<Map.Entry<String, Long>> valueComparator =
                Map.Entry.comparingByValue(Comparator.reverseOrder());
        System.out.println(input);
        System.out.println(InputHashMap);
        return InputHashMap.entrySet().stream()
                .sorted(valueComparator)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}

