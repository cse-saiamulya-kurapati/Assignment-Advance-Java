package com.capgemini.junitTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.capgemini.junit.LoginValidationSystem;

public class LoginValidationSystemTest {

    private LoginValidationSystem test;

    @BeforeEach
    void setup() {
        test = new LoginValidationSystem();
    }

//    @Test
//    void validUsername() {
//        assertTrue(test.isValidUsername("Ritika123"));
//    }
//
//    @Test
//    void specialUsername() {
//        assertFalse(test.isValidUsername("Ritik@123"));
//    }
//
//    @Test
//    void shortUsername() {
//        assertFalse(test.isValidUsername("sas"));
//    }
//    @Test
//    void emptyUsername() {
//    	assertFalse(test.isValidUsername(""));
//    }
//    @Test
//    void nullUsername() {
//    	assertFalse(test.isValidUsername(null));
//    }
//    
//    @Test
//    void validPassword() {
//    	assertTrue(test.isValidPassword("#Ritika1234"));
//    }
//    
//    @Test
//    void invalidPasswordWithoutSpecialCharacter() {
//    	assertFalse(test.isValidPassword("ritika"));
//    }
//    @Test
//    void emptyPassword() {
//    	assertFalse(test.isValidPassword(""));
//    }
//    @Test
//    void withoutDigit() {
//    	assertFalse(test.isValidPassword("Rit@#aa"));
//    }
//    @Test
//    void tooShort() {
//    	assertFalse(test.isValidPassword("rit1"));
//    }
//    @Test
//    void nullPassword() {
//    	assertFalse(test.isValidPassword(null));
//    }
//    
//    @Test
//    void validLogin() {
//    	assertTrue(test.login("Ritika", "Ritika@123"));
//    }
//    @Test
//    void invalidLogin() {
//    	assertFalse(test.login("Rit", "ri12"));
//    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {"Ritika","ritika123","riti011","login1234"})
    void validUsernames(String username) {
    	assertTrue(test.isValidUsername(username));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Rti","ri@#ne",""})
    void invalidUsernames(String username) {
    	assertFalse(test.isValidUsername(username));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Ritika#123","Use@rr123","#Sprxcnj4946"})
    void validPassword(String password) {
    	assertTrue(test.isValidPassword(password));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"ritika","1234","rit2332","qw",""})
    void invalidPassword(String password) {
    	assertFalse(test.isValidPassword(password));
    }
    
    @ParameterizedTest
    @CsvSource({ 
        "Ritika123, Ritika@123, true",
        "User1, User@1234, true",
        "Ri@, Ritika@123, false",
        "Ritika123, pass, false"
    })
    void loginTests(String username,
                    String password,
                    boolean expected) {

        assertEquals(expected,
            test.login(username, password));
    }

} 
