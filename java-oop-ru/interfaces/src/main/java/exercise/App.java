package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> inputList, int elementsCount) {
        return inputList.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .limit(elementsCount)
                .map(x -> x.toString())
                .collect(Collectors.toList());
    }
}
// END
