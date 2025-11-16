package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DateTest {

    // Testing between two random dates within a month ////////////////////////////////////
    @Test
    void eleventhToFifteenthShouldReturnFive(){
        var date = new Date();
        assertEquals(5, date.calculateDaysBetween("11.01 - 15.01"));
    }

    @Test
    void eighteenthToThirtyFirstShouldReturnFourteen(){
        var date = new Date();
        assertTrue(date.calculateDaysBetween("18.07 - 31.07") == 14);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    // Testing with transitions from one month to the other ///////////////////////////////
    @Test
    void twentyNinthOfJanToThirdOfFebShouldReturnSix(){
        var date = new Date();
        assertEquals(6, date.calculateDaysBetween("29.01 - 03.02"));
    }

    @Test
    void twentyNinthOfAprilToThirdOfMaiShouldReturnFive(){
        var date = new Date();
        assertEquals(5, date.calculateDaysBetween("29.04 - 03.05"));
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    // Should throw an Illegal Argument Exception if the date is formatted wrong //////////
    @Test
    void illegalArgumentExceptionBecauseOfMissingDots(){
        var date = new Date();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    date.checkDateFormatting("0108");
                });
    }

    @Test
    void illegalArgumentExceptionBecauseOfBackslashInsteadOfDots(){
        var date = new Date();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    date.checkDateFormatting("15/05");
                });
    }

    @Test
    void testShouldPassSinceValidFormat(){
        var date = new Date();
        assertTrue(date.checkDateFormatting("28.09"));
    }
    ///////////////////////////////////////////////////////////////////////////////////////
}