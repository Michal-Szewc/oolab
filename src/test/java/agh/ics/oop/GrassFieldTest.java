package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void test1(){
        String [] commands = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(2,-1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3,7)) instanceof Animal);
    }

    @Test
    void test2(){
        String[] commands = {"r","l","r","f","f","f","l","f","f","f","l","f","r","f","l","r","r","f","f","f","f","l","l","l","f","f","f","l","l","l","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new GrassField(12);
        Vector2d[] positions = { new Vector2d(3,3), new Vector2d(7,5), new Vector2d(2,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(5,4)));
        assertTrue(map.isOccupied(new Vector2d(5,3)));
        assertTrue(map.isOccupied(new Vector2d(4,3)));
        assertFalse(map.objectAt(new Vector2d(4,4)) instanceof Animal);
    }
}