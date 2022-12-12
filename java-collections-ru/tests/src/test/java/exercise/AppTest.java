package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3)); //maked input arr to test
        List<Integer> actualList = App.take(inputList, 1); //return list by using method being tested
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        //Integer[] expectedArr = new Integer[1];
        //expectedArr[0] = 1;
        //Integer[] actualArr = inputList.toArray();

        //Assertions.assertThat(actualList).isEqualTo(expectedList);
        // END
    }
}
