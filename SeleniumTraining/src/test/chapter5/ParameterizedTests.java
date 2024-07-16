package chapter5;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*Allow methods that needs to be static to be trated as such*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {
   @ParameterizedTest
   @ValueSource(ints = {4,7,12,13,41,50})
    void checkEvenNumbers(int num){
       //init
       boolean expected = true;
       //actual
       boolean actual = (num %2 == 0);
       //Assert
       //assertEquals(expected,actual, num + " is not an even number");
       assertTrue(actual);
   }

   @ParameterizedTest(name = "Starts with M? {arguments}")
   @ValueSource(strings = {"Michael","Michelle","Jones","Smith","Misch"})
   void startWithM(String name){
       boolean expected = true;
       boolean actual = name.startsWith("M");
       System.out.println("name = " + name);
       assertEquals(expected,actual,name + " doesn't start with the letter (M)");
   }
   //Method with values of different types
    @ParameterizedTest
    @CsvSource(value = {"Kabelo,25,1.81","Jessica,23,1.77","James,28,1.85"})
    void stringAndNumbers(String name, int age, double height){
       //init
       boolean expected = true;
       //act
        boolean actual = age > 25;
        //assert
        //assertTrue(actual,name + " is not old enough");
        assertEquals(expected,actual,name + " is not old enough");

        System.out.println("name = " + name + ", age = " + age + ", height = " + height);
    }

    @ParameterizedTest
    @MethodSource(value = "veggies")
    void getVeggies(String veg){
        System.out.println("veg = " + veg);
    }
    List<String> veggies(){
       return Arrays.asList("Carrot", "Tomato", "Lettuce");
    }
}
