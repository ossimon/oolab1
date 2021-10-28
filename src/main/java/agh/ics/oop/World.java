package agh.ics.oop;
import static java.lang.System.out;

public class World {

    public static Direction.direction[] translate(String[] args){

        int l = args.length;
        Direction.direction[] translation = new Direction.direction[l];

        for(int i = 0; i < l; i++){
            switch (args[i]) {
                case "f" -> translation[i] = Direction.direction.FORWARD;
                case "b" -> translation[i] = Direction.direction.BACKWARD;
                case "r" -> translation[i] = Direction.direction.RIGHT;
                case "l" -> translation[i] = Direction.direction.LEFT;
                default -> translation[i] = Direction.direction.NONE;
            }
        }

        return translation;
    }

    public static void run(Direction.direction[] args){

        for (Direction.direction arg : args) {
            switch (arg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
                case LEFT -> out.println("Zwierzak skręca w lewo");
            }
        }
    }
    public static void main(String[] args){

        out.println("Start");
        Direction.direction[] newArgs = translate(args);
        run(newArgs);
        out.println("Stop");
    }
}
