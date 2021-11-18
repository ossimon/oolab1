package agh.ics.oop;

import javax.management.ValueExp;

public class Animal {

    private MapDirection orient;
    private Vector2d pos;
    private IWorldMap map;

    public Animal(){
        orient = MapDirection.NORTH;
        pos = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map){
        orient = MapDirection.NORTH;
        pos = new Vector2d(2, 2);
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        orient = MapDirection.NORTH;
        pos = initialPosition;
        this.map = map;
    }
    public String toString(){
        return switch (this.orient){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }
    public boolean isAt(Vector2d position){
        return position.equals(this.pos);
    }
    public Vector2d getPosition(){
        return this.pos;
    }
    public void move(MoveDirection direction){
        Vector2d newPos;
        switch(direction){
            case LEFT -> orient = orient.previous();
            case RIGHT -> orient = orient.next();
            case FORWARD -> {
                newPos = pos.add(orient.toUnitVector());
                if (map.canMoveTo(newPos)){
                    pos = newPos;
                }
            }
            case BACKWARD -> {
                newPos = pos.subtract(orient.toUnitVector());
                if (map.canMoveTo(newPos)){
                    pos = newPos;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
