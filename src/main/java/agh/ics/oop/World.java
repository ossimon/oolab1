package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;


import static java.lang.System.exit;
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


        Application.launch(App.class, args);

    }
}
