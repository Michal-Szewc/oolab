package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void MapDirectionTest(){
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);

        assertEquals(MapDirection.NORTH,MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST,MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH,MapDirection.WEST.previous());
        assertEquals(MapDirection.WEST,MapDirection.NORTH.previous());
    }
}