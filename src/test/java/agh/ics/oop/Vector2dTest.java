package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void equalsTest(){
        assertTrue(new Vector2d(2,1).equals(new Vector2d(2,1)));
    }

    @Test
    void toStringTest(){
        assertEquals(new Vector2d(2,1).toString(),"(2,1)");
        assertEquals(new Vector2d(-3,0).toString(),"(-3,0)");
        assertEquals(new Vector2d(0,15).toString(),"(0,15)");
    }

    @Test
    void proceedsTest(){
        assertTrue(new Vector2d(2,1).proceeds(new Vector2d(3,4)));
        assertTrue(!new Vector2d(2,1).proceeds(new Vector2d(3,-1)));
        assertTrue(new Vector2d(1,1).proceeds(new Vector2d(1,1)));
    }

    @Test
    void followsTest(){
        assertTrue(!new Vector2d(2,1).follows(new Vector2d(3,4)));
        assertTrue(!new Vector2d(2,1).follows(new Vector2d(3,-1)));
        assertTrue(new Vector2d(1,1).follows(new Vector2d(1,1)));
    }

    @Test
    void upperRightTest(){
        assertEquals(new Vector2d(2,-576).upperRight(new Vector2d(-234,4)),new Vector2d(2,4));
        assertEquals(new Vector2d(2,0).upperRight(new Vector2d(-234,-4)),new Vector2d(2,0));
    }

    @Test
    void lowerLeftTest(){
        assertEquals(new Vector2d(2,-576).lowerLeft(new Vector2d(-234,4)),new Vector2d(-234,-576));
        assertEquals(new Vector2d(2,0).lowerLeft(new Vector2d(-234,-4)),new Vector2d(-234,-4));
    }

    @Test
    void addTest(){
        assertEquals(new Vector2d(2,1).add(new Vector2d(3,-4)),new Vector2d(5,-3));
        assertEquals(new Vector2d(-2,-1).add(new Vector2d(1,2)),new Vector2d(-1,1));
    }

    @Test
    void subtractTest(){
        assertEquals(new Vector2d(2,1).subtract(new Vector2d(3,-4)),new Vector2d(-1,5));
        assertEquals(new Vector2d(-2,-1).subtract(new Vector2d(1,2)), new Vector2d(-3,-3));
    }

    @Test
    void oppositeTest(){
        assertEquals(new Vector2d(2,0).opposite(),new Vector2d(-2,0));
        assertEquals(new Vector2d(-3,4).opposite(),new Vector2d(3,-4));
    }
}