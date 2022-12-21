package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, String> middleMap = new LinkedHashMap<>();

        for (Map.Entry<String, Object>  addingElement: firstMap.entrySet()) {
            middleMap.put(addingElement.getKey(), "deleted");
        }
        middleMap = putElementsFromSecondMap(secondMap, middleMap, firstMap);
        return middleMap;
    }

    static Map<String, String> putElementsFromSecondMap(Map<String, Object> secondMap,
    Map<String, String> middleMap, Map<String, Object> firstMap) {
        for (Map.Entry<String, Object> addingElement: secondMap.entrySet()) {
            if (!middleMap.containsKey(addingElement.getKey())) {
                middleMap.put(addingElement.getKey(), "added");
            } else if (middleMap.containsKey(addingElement.getKey())
             && addingElement.getValue().equals(firstMap.get(addingElement.getKey()))) {
                middleMap.put(addingElement.getKey(), "unchanged");
            } else {
                middleMap.put(addingElement.getKey(), "changed");
            }
        }
        return middleMap;
    }
}
//END
