package testing;

import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

  private static Instant startedAt;
  private Calculator calculator;

  @BeforeAll
  static void beforeAll() {
    System.out.println("@BeforeAll");
    startedAt = Instant.now();
  }

  @AfterAll
  static void afterAll() {
    System.out.println("@AfterAll");
    Instant finished = Instant.now();
    long elapsed = Duration.between(startedAt, finished).toMillis();
    System.out.println("Elapsed: " + elapsed + " ms");
  }

  @BeforeEach
  public void setup() {
    System.out.println("Starting Calculator Test");
    calculator = new Calculator();
  }

  @AfterEach
  public void tearDown() {
    System.out.println("Finished ==> Calculator Test");
    calculator = null;
  }

  //Nous allons fournir les différents entrants possibles avec l'annotation @ValueSource.
  @ParameterizedTest(name = "{0} x 0 = 0")
  @ValueSource(ints = {1, 2, 4, 5, 23, 67})
  public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
    // Arrange -- Tout est prêt !

    // Act -- Multiplier par zéro
    int actualResult = calculator.multiply(arg, 0);

    // Assert -- ça vaut toujours zéro !
    assertThat(actualResult).isEqualTo(0);
  }

  //Nous allons fournir les différents entrants possibles avec l'annotation @CsvSource.
  @ParameterizedTest(name = "{0} + {1} should equal to {2}")
  @CsvSource({"1,1,2", "2,3,5", "42,57,99"})
  public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
    // Arrange -- Tout est prêt !

    // Act
    int actualResult = calculator.add(arg1, arg2);

    // Assert
    assertThat(actualResult).isEqualTo(expectResult);
  }

  @Test
  void testAddTwoPositiveNumbers() {
    // Arrange
    int a = 2;
    int b = 3;

    // Act
    int somme = calculator.add(a, b);

    // Assert
    assertThat(somme).isEqualTo(5);
  }

  @Test
  void testAddTwoNegativeNumbers() {
    // Arrange
    int a = -2;
    int b = -3;

    //Act
    int somme = calculator.add(a, b);

    //Assert
    assertThat(somme).isEqualTo(-5);
  }

  @Test
  void testAddTwoZeroNumbers() {
    //Arrange
    int a = 0;
    int b = 0;

    //Act
    int somme = calculator.add(a, b);

    //Assert
    assertThat(somme).isEqualTo(0);     //AssertJ
    assertEquals(0, somme);             //Junit5
  }

  @Test
  void testMultiplyTwoPositiveNumbers() {
    //Arrange
    int a = 3;
    int b = 4;

    //Act
    int mult = calculator.multiply(a, b);

    //Assert
    assertThat(mult).isEqualTo(12);
    assertEquals(12, mult);

  }

  //L'annotation @Timeout permet de décider de faire échouer le test à partir d'un délai que vous estimez trop long.
  @Timeout(3)
  @Test
  public void longCalcul_shouldComputeInLessThan1Second() {
    // Arrange

    // Act
    calculator.longCalculation();

    // Assert
    // ...
  }

  @Test
  public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {
    // GIVEN
    int number = 95897;

    // WHEN
    Set<Integer> actualDigits = calculator.digitsSet(number);

    // THEN
    assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
  }
}