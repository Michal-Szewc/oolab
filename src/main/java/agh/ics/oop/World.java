package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static Direction[] trans(String [] args){
        Direction commands[] = new Direction[args.length];
        for(int i = 0; i < args.length; i++){
            commands[i] = switch(args[i]){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.ERROR;
            };
        }
        return commands;
    }
    public static void run(Direction [] args){
        for(Direction argument : args) {
            String message = switch (argument) {
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tyłu";
                case LEFT -> "W lewo";
                case RIGHT -> "W prawo";
                default -> "Nieznana komenda";
            };
            if(argument != Direction.ERROR) out.println("Zwierzak idzie " + message);
            else out.println(message);
        }

    }
    public static void main(String[] args) {
        out.println("start");
        String commands[] = {"f","f","l","r"};
        run(trans(commands));
        out.println("stop");
    }
}
