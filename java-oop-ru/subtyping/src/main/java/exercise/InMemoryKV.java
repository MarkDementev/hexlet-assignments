package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> valuesMap = new HashMap<>();

    public InMemoryKV(Map<String, String> inputMap) {
        valuesMap.putAll(inputMap);
    }

    @Override
    public void set(String key, String value) {
        valuesMap.put(key, value);
    }

    @Override
    public void unset(String key) {
        valuesMap.remove(key);
    }

    @Override
    public String get(String key, String defaultValue){
        return valuesMap.get(key) != null ? valuesMap.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap(){
        return new HashMap<>(valuesMap);
    }
}
// END
