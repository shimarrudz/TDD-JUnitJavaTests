package br.com.shima;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FirstTest {

    @Mock
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void sumTest() {
        int num1 = 10, num2 = 5;

        int result = num1 + num2;

        Assertions.assertThat(result).isEqualTo(15);
    }

    @Test
    public void shouldNotSumNegativeNumbers() {
        int num1 = -10, num2 = 5;

        calculator.sum(num1, num2);

        org.junit.jupiter.api.Assertions.assertThrows( RuntimeException.class, () -> calculator.sum(num1, num2));
    }

    @Test
    public void subTest() {
        int num1 = 15, num2 = 5;

        int result = calculator.substract(num1, num2);

        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    public void multTest() {
        int num1 = 2, num2 = 3;

        int result = calculator.multiply(num1, num2);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void divTest() {
        int num1 = 6, num2 = 3;

        float result = calculator.divide(num1, num2);

        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void shoudNotDividePerZero() {
        int num1 = 10, num2 = 0;

        calculator.divide(num1, num2);

        org.junit.jupiter.api.Assertions.assertThrows( ArithmeticException.class, () -> calculator.divide(num1, num2));
    }


    class Calculator {

        int sum(int num, int num2) {
            if (num < 0 || num2 < 0) {
                throw new RuntimeException("Sum is not able to sum negative numbers");
            }
            return num + num2;
        }

        int substract(int num, int num2) {
            return num - num2;
        }

        int multiply(int num, int num2) {
            return num * num2;
        }

        int divide(int num, int num2) {
            return num / num2;
        }
    }
}
