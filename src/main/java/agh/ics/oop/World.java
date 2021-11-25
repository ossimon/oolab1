package agh.ics.oop;

import java.util.Map;

import static java.lang.System.out;

public class World {

    public static Direction[] translate(String[] args){

        int l = args.length;
        Direction[] translation = new Direction[l];

        for(int i = 0; i < l; i++){
            switch (args[i]) {
                case "f" -> translation[i] = Direction.FORWARD;
                case "b" -> translation[i] = Direction.BACKWARD;
                case "r" -> translation[i] = Direction.RIGHT;
                case "l" -> translation[i] = Direction.LEFT;
                default -> translation[i] = Direction.NONE;
            }
        }

        return translation;
    }

    public static void run(Direction[] args){

        out.println("Zwierzak idzie do przodu");

        for (Direction arg : args) {
            switch (arg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
                case LEFT -> out.println("Zwierzak skręca w lewo");
            }
        }
    }
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        //IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
    }
}
