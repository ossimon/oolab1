package agh.ics.oop;
import java.util.*;

public class RectangularMap implements IWorldMap{

    private int width;
    private int height;
    private Vector2d leftDownBoundary;
    private Vector2d rightUpBoundary;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int w, int h){
        this.width = w;
        this.height = h;
        leftDownBoundary = new Vector2d(0,0);
        rightUpBoundary = new Vector2d(width - 1, height - 1);
    }
    public boolean canMoveTo(Vector2d position){
        return position.follows(new Vector2d(0, 0))
                && position.precedes(new Vector2d(this.width - 1, this.height - 1))
                && !isOccupied(position);
    }
    public boolean place(Animal animal){
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    public Object objectAt(Vector2d position){
        for (Animal animal: animals) {
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(leftDownBoundary, rightUpBoundary);me
    }
}
