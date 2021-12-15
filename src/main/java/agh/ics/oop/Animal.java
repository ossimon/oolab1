package agh.ics.oop;

import javax.management.ValueExp;
import java.util.*;

public class Animal implements IMapElement{

    private List<IPositionChangeObserver> observers = new ArrayList<>();
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
        addObserver((IPositionChangeObserver) map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){

        orient = MapDirection.NORTH;
        pos = initialPosition;
        this.map = map;
        addObserver((IPositionChangeObserver) map);
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

    @Override
    public String getImageFile() {

        return switch (this.orient) {
            case NORTH -> "src/main/resources/up.png";
            case EAST -> "src/main/resources/right.png";
            case SOUTH -> "src/main/resources/down.png";
            case WEST -> "src/main/resources/left.png";
        };
    }

    public Vector2d getPosition(){
        return this.pos;
    }
    public void move(MoveDirection direction){
        Vector2d newPos;
        switch(direction){
            case LEFT -> {
                orient = orient.previous();
                positionChanged(pos, pos);
            }
            case RIGHT -> {
                orient = orient.next();
                positionChanged(pos, pos);
            }
            case FORWARD -> {
                newPos = pos.add(orient.toUnitVector());
                if (map.canMoveTo(newPos)){
                    positionChanged(pos, newPos);
                    pos = newPos;
                }
            }
            case BACKWARD -> {
                newPos = pos.subtract(orient.toUnitVector());
                if (map.canMoveTo(newPos)){
                    positionChanged(pos, newPos);
                    pos = newPos;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
}
