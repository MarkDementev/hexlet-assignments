package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String inputSentence) {
        String[] inputSentenceToArray = inputSentence.split(" ");
        Map<String, Integer> outputMap = new HashMap<>();

        if (inputSentence.equals("")) {
            return outputMap;
        }
        int i2;

        for (int i1 = 0; i1 < inputSentenceToArray.length; i1++) {
            i2 = wordCountCalculation(inputSentenceToArray, inputSentenceToArray[i1]);
            outputMap.put(inputSentenceToArray[i1], i2);
        }
        return outputMap;
    }

    public static int wordCountCalculation(String[] inputSentenceToArray, String countingWord) {
        int wordCount = 0;

        for (int i3 = 0; i3 < inputSentenceToArray.length; i3++) {
            if (inputSentenceToArray[i3].equals(countingWord)) {
                wordCount++;
            }
        }
        return wordCount;
    }
    public static String toString(Map<String, Integer> outputMap) {
        if (outputMap.size() == 0) {
            return "{}";
        }
        String result = "{\n";

        for (Map.Entry<String, Integer> word: outputMap.entrySet()) {
            result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        result = result + "}";
        return result;
    }
}
//END
