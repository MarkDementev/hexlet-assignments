package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> inputUsersList) {
        return inputUsersList.stream()
        .filter(gender -> gender.get("gender").equals("male"))
        .sorted((man1, man2) -> {
            LocalDate man1LocalDate = LocalDate.parse(man1.get("birthday"));
            LocalDate man2LocalDate = LocalDate.parse(man2.get("birthday"));
            return man1LocalDate.compareTo(man2LocalDate);
        })
        .map(man -> man.get("name"))
        .collect(Collectors.toList());

        /*return inputUsersList.stream()
        .filter(gender -> gender.get("gender").equals("male"))
        .sorted((man1, man2) -> man1.get("birthday").compareTo(man2.get("birthday")))
        .map(man -> man.get("name"))
        .collect(Collectors.toList());*/
    }
}
// END
