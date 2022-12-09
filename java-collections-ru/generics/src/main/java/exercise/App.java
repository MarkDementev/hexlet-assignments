package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static <T> List<Map<T, T>> findWhere(List<Map<T, T>> books, Map<T, T> where) {
        List<Map<T, T>> outputList = new ArrayList<>();
        if (books.isEmpty()) {
            return outputList;
        }

        if (where.containsKey("title")) {
            for (Map<T, T> book : books) {
                if(book.get("author").equals(where.get("author"))
                        && book.get("year").equals(where.get("year")) && book.get("title").equals(where.get("title"))){
                    outputList.add(book);
                }
            }
        } else {
            for (Map<T, T> book : books) {
                if(book.get("author").equals(where.get("author")) && book.get("year").equals(where.get("year"))){
                    outputList.add(book);
                }
            }
        }
        return outputList;
    }
}
//END
