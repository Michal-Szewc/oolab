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
        /*out.println("start");
        String commands[] = {"f","f","l","r"};
        run(trans(commands));
        out.println("stop");*/
        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/
        out.println(new Vector2d(2,-576).upperRight(new Vector2d(-234,4)));
        out.println(new Vector2d(2,0).upperRight(new Vector2d(-234,-4)));
    }
}
