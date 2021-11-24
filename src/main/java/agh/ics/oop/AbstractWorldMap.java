package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animals = new ArrayList<>();

    public boolean canMoveTo (Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }
    public boolean place (Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        return this.objectAt(position) != null;
    }
    public Object objectAt(Vector2d position){
        for (Animal animal: animals) {
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
    protected abstract Vector2d[] findBoundaries();

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);

        Vector2d[] boundaries = findBoundaries();
        return visualizer.draw(boundaries[0], boundaries[1]);
    }
}
