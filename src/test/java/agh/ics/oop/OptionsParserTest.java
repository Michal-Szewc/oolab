package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void test(){
        String[]  strings = {"f","forward","l","left","r","right","b","backward"};
        MoveDirection[] commands = new OptionsParser().parse(strings);
        assertArrayEquals(commands,new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.FORWARD,
        MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.RIGHT,
        MoveDirection.BACKWARD,MoveDirection.BACKWARD});
    }

    @Test
    void testError(){
        String[]  strings = {"f","forward","l","left","r","right","b","backward","froward"};
        assertThrows(IllegalArgumentException.class,() -> {
            MoveDirection[] commands = new OptionsParser().parse(strings);
        });
    }
}