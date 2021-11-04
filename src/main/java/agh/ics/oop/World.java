package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        String[] stringList= {"r","f","forward","lol","f"};
        MoveDirection[] commands= OptionsParser.parse(stringList);
        out.println(animal);
        for(MoveDirection move: commands)
            animal.move(move);
        out.println(animal);
    }
}
