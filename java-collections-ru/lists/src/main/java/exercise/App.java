package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String inputCharString, String inputWord) {
        if (inputCharString.length() < inputWord.length()) {
            return false;
        }
        String[] inputCharStringArr = inputCharString.split("");
        ArrayList<String> inputWordList = new ArrayList<>();

        for (int i1 = 0; i1 < inputWord.length(); i1++) {
            inputWordList.add(inputWord.substring(i1, i1 + 1).toLowerCase());
        }

        for (int i2 = 0; i2 < inputCharStringArr.length; i2++) {
            inputCharStringArr[i2] = inputCharStringArr[i2].toLowerCase();
        }

        for (int i3 = 0; i3 < inputCharStringArr.length; i3++) {
            if (inputWordList.contains(inputCharStringArr[i3])) {
                inputWordList.remove(inputCharStringArr[i3]);
            }
        }

        if (inputWordList.size() == 0) {
            return true;
        }
        return false;
    }
}
//END
