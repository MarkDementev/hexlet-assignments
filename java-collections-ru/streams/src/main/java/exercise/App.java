package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> inputList) {
        String[] freeEmailsArr = {"gmail.com", "yandex.ru", "hotmail.com"};
        List<String> freeEmailsList = Arrays.asList(freeEmailsArr);
        long emailsCount = 0;

        for (String emailEnd: freeEmailsList) {
            emailsCount += inputList.stream()
            .filter(email -> email.endsWith(emailEnd))
            .count();
        }
        return emailsCount;
    }
}
// END
