package com.capgemini.mockitounitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.mockitounit.Calculator;
import com.capgemini.mockitounit.MathService;

@ExtendWith(MockitoExtension.class)   
public class CalculatorTest {

    @Mock
    MathService ms;
 
    @InjectMocks
    Calculator c;

    @Test
    void testAdd() {

        // Mock behavior
        when(ms.add(10, 20)).thenReturn(30);

  
        // Assertion
        assertEquals(30, c.add(10, 20));

        // Verify interaction
        verify(ms).add(10, 20);
    }
}
 