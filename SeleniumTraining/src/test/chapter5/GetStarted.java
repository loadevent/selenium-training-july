package chapter5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetStarted {

    @Test
    @DisplayName("Addition")
    void additionTest(){
        //initialize expected results
        int num1 = 5, num2 = 4;
        int expected = 9;

        //Act - get actual results
        int actual = num1 + num1;
        //Assert - compare expected results with actual results

//        assertEquals(expected,actual, num1 + " + " + num2 +
//                " should be equals to " + (num1 + num2));

        assertTrue(expected == actual);
    }
}
