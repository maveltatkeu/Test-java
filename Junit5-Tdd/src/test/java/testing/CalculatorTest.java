package testing;

import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.add(a, b);

        // Assert
        assertEquals(5, somme);
    }

    @Test
    void testAddTwoNegativeNumbers() {
        // Arrange
        int a = -2;
        int b = -3;
        Calculator calculator = new Calculator();

        //Act
        int somme = calculator.add(a, b);

        //Assert
        assertEquals(-5, somme);
    }

    @Test
    void testAddTwoZeroNumbers() {
        //Arrange
        int a = 0;
        int b = 0;
        Calculator calculator = new Calculator();

        //Act
        int somme = calculator.add(a, b);

        //Assert
        assertEquals(0, somme);
    }

    @Test
    void testMultiplyTwoPositiveNumbers() {
        //Arrange
        int a = 3;
        int b = 4;
        Calculator calculator = new Calculator();

        //Act
        int mult = calculator.multiply(a,b);

        //Assert
        assertEquals(12, mult);

    }
}