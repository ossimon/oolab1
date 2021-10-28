package agh.ics.oop;

import java.util.Map;

import static java.lang.System.out;

public class World {

    public static class Vector2d{
        public final int x;
        public final int y;

        public Vector2d(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "(" + this.x + ", " + this.y + ")";
        }
        public boolean precedes(Vector2d other){
            return this.x <= other.x && this.y <= other.y;
        }
        public boolean follows(Vector2d other){
            return this.x >= other.x && this.y >= other.y;
        }
        public Vector2d upperRight(Vector2d other){
            int x;
            int y;
            x = Math.max(this.x, other.x);
            y = Math.max(this.y, other.y);
            return new Vector2d(x, y);
        }
        public Vector2d lowerLeft(Vector2d other){
            int x;
            int y;
            x = Math.min(this.x, other.x);
            y = Math.min(this.y, other.y);
            return new Vector2d(x, y);
        }
        public Vector2d add(Vector2d other){
            return new Vector2d(this.x + other.x, this.y + other.y);
        }
        public Vector2d subtract(Vector2d other){
            return new Vector2d(this.x - other.x, this.y - other.y);
        }
        public boolean equals(Object other){
            if(this == other)
                return true;
            if(!(other instanceof Vector2d))
                return false;

            Vector2d that = (Vector2d) other;
            return this.x == that.x && this.y == that.y;
        }
        public Vector2d opposite(){
            return new Vector2d(-this.x, -this.y);
        }
    }
    enum MoveDirection{
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }
    public enum MapDirection{
        NORTH,
        SOUTH,
        WEST,
        EAST;

        public String toString(){
            return switch (this) {
                case NORTH -> "Północ";
                case SOUTH -> "Południe";
                case WEST -> "Zachód";
                case EAST -> "Wschód";
            };
        }
        public MapDirection next(){
            return switch (this){
                case NORTH -> EAST;
                case EAST -> SOUTH;
                case SOUTH -> WEST;
                case WEST -> NORTH;
            };
        }
        public MapDirection previous(){
            return switch (this){
                case NORTH -> WEST;
                case WEST -> SOUTH;
                case SOUTH -> EAST;
                case EAST -> NORTH;
            };
        }
        public Vector2d toUnitVector(){
            return switch (this) {
                case NORTH -> new Vector2d(0, 1);
                case WEST -> new Vector2d(-1, 0);
                case SOUTH -> new Vector2d(0, -1);
                case EAST -> new Vector2d(1, 0);
            };
        }
    }

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

        out.println("Zwierzak idzie do przodu");

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
