package com.capgemini.junitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.capgemini.junit.Calculator;

public class CalculatorTest {

    private Calculator c;

    @BeforeEach
    void setUp() {
        c = new Calculator();
    }

    // 🔹 Nested class for Addition tests
    @Nested
    @DisplayName("Addition Tests")
    class AdditionTestCases {

        @Test
        @DisplayName("Test sum of two positive numbers")
        public void testTwoAndTwoGivesFour() {
            assertEquals(4, c.addition(2, 2));
        }

        @RepeatedTest(3)
        @DisplayName("Test sum with repeated execution")
        public void testFiveAndFour() {
            assertEquals(9, c.addition(5, 4));
        }
    }

    // 🔹 Nested class for Subtraction tests
    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTestCases {

        @Test
        public void testThreeAndFour() {
            assertEquals(-1, c.subtraction(3, 4));
        }
    }

    // 🔹 Nested class for Age validation tests
    @Nested
    @DisplayName("Age Validation Tests")
    class AgeValidationTestCases {

        @Test
        void testValidAge_True() {
            assertTrue(c.validAge(20));
        }

        @Test
        void testValidAge_False() {
            assertFalse(c.validAge(15));
        }
    }

    // 🔹 Parameterized Test
    @ParameterizedTest 
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Test multiplication of numbers by 2")
    void testMultiplyByTwo(int number) {
        assertEquals(number * 2, c.multiply(number, 2));
    }
    
    @ParameterizedTest
    @CsvSource({"2,2,4","2,3,6","4,4,16"})
    void testMultiply(int x,int y,int expected) {
    	assertEquals(expected,c.multiply(x,y));
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-data.csv",numLinesToSkip = 1)
    @DisplayName("Test sum using CSV file")
    void testSumUsingCsvFile(int a,int b,int expectedSum) {
    	assertEquals(expectedSum, c.addition(a, b));
    }
}
 