package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage inputStorage) {
        for (Map.Entry<String, String> inputMapElement : inputStorage.toMap().entrySet()) {
            inputStorage.set(inputMapElement.getValue(), inputMapElement.getKey());
            inputStorage.unset(inputMapElement.getKey());
        }
    }
}
// END
