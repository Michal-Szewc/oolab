package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void test1(){
        String[] commands = {"r","l","r","f","f","f","l","f","f","f","l","f","r","f","l","r","r","f","f","f","f","l","l","l","f","f","f","l","l","l","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new RectangularMap(12, 6);
        Vector2d[] positions = { new Vector2d(3,3), new Vector2d(7,5), new Vector2d(2,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(5,4)));
        assertTrue(map.isOccupied(new Vector2d(5,3)));
        assertTrue(map.isOccupied(new Vector2d(4,3)));
        assertTrue(!map.isOccupied(new Vector2d(4,4)));
    }

    @Test
    void test2(){
        String[] commands = {"r","l","r","f","f","f","l","f","l","f","r","f","f","f","f","l","l","l","f","l","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new RectangularMap(12, 6);
        Vector2d[] positions = { new Vector2d(3,3), new Vector2d(7,5) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1,6)));
        assertTrue(map.isOccupied(new Vector2d(5,4)));
    }
}