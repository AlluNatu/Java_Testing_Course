package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    StudentRegister sr;

    @BeforeEach
    public void setUp() {
        sr = new StudentRegister();
    }

    @Test
    public void testGetAverageGrade() {
        assertEquals(3.5, sr.getAverageGrade("123"));
        assertEquals(2.1, sr.getAverageGrade("666"));
    }

    @Test
    public void testGetCourseName() {
        assertEquals("Ohjelmistotestauksen periaatteet", sr.getCourseName("CT60A4160"));
        assertEquals("Help 4 newbies", sr.getCourseName("CT60N00B"));
    }

    @Test
    public void testGetCourseInvalidCourseName() {
        assertEquals("Not Found", sr.getCourseName("CS62A3890"));
        assertEquals("Not Found", sr.getCourseName("CT33A3831"));
        assertEquals("Not Found", sr.getCourseName("BM42A38D2"));
    }

    @Test
    public void testGetCourseLongName() {
        assertEquals("Invalid id", sr.getCourseName("AVeryLongCourseId"));
        assertEquals("Invalid id", sr.getCourseName("AnotherLongCourseIdThatShouldFail"));
    }

    @Test
    public void testGetAverageGradeInvalidId() {
        assertAll("Empty characters",
                () -> assertEquals(0, sr.getAverageGrade("")),
                () -> assertEquals(0, sr.getAverageGrade(" ")),
                () -> assertEquals(0, sr.getAverageGrade("\t")),
                () -> assertEquals(0, sr.getAverageGrade("\n")));
    }

    @Test
    public void testGetCourseNull() {
        assertThrows(NullPointerException.class,
                () -> sr.getCourseName(null));
    }

}
