
package com.example;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

public class AnimalTest {
    private Animal animal;

    @BeforeEach
    public void init(){
        animal = new Animal("expected", 0);
    }
    
    @Test
    public void testAnimalGetAge(){
        int expected = 0;
        int actual = animal.getAge();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAnimalGetName(){
        String expected = "expected";
        String actual = animal.getName();
        assertEquals(expected, actual);
    }


    @Test
    public void testAnimalShout(){
        String expected = "<default shout>";
        String actual = animal.shout();
        assertEquals(expected, actual);
    }


     @Test
    public void testAnimalInvalidAge(){
        animal = new Animal("expected", -6);
        int expected = 0;
        int actual = animal.getAge();
        assertEquals(expected, actual);
    }

    @Test
    public void testAnimalInvalidName(){
        animal = new Animal("", 0);
        String expected = "Undefined";
        String actual = animal.getName();
        assertEquals(expected, actual);
    }
}