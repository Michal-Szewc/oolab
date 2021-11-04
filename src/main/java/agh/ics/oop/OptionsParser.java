package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    static public MoveDirection[] parse(String[] strings){
        int count = 0;
        for(String string: strings){
            if(Arrays.asList("f","forward","b","backward","l","left","r","right").contains(string)){
                count += 1;
            }
        }
        MoveDirection[] commands = new MoveDirection[count];
        count = 0;
        for(String string: strings){
            switch (string) {
                case "f","forward"->commands[count++]=MoveDirection.FORWARD;
                case "b","backward"->commands[count++]=MoveDirection.BACKWARD;
                case "l","left"->commands[count++]=MoveDirection.LEFT;
                case "r","right"->commands[count++]=MoveDirection.RIGHT;
            }
        }
        return commands;
    }
}
