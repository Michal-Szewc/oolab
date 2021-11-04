package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void IntegratedTest(){
        Animal animal = new Animal();
        for(MoveDirection move: OptionsParser.parse(new String[]{"f","forward","rajt","r","bakword","b","l"}))
            animal.move(move);
        assertTrue(animal.isAt(new Vector2d(1,4)));
        assertEquals(animal.getDirection(),MapDirection.NORTH);
        for(MoveDirection move: OptionsParser.parse(new String[]{"f","f","f","r","f","f","f","f","f","f","r","f","f","f","f","f","f","f"})) {
            animal.move(move);
            assertTrue(animal.getPosition().proceeds(new Vector2d(4, 4)));
            assertTrue(animal.getPosition().follows(new Vector2d(0, 0)));
        }
        assertTrue(animal.isAt(new Vector2d(4,0)));
        for(MoveDirection move: OptionsParser.parse(new String[]{"forwad","frowad","frawod","frowda","forwadd","hogward","prosze rusz sie zwierzaczku","dlaczego to nie dziala","inne glupie teksty"}))
            animal.move(move);
        assertTrue(animal.isAt(new Vector2d(4,0)));
    }
}