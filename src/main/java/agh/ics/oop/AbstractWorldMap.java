package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    public boolean canMoveTo (Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }
    public void place (Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)) {
            animals.put(pos, animal);
        }
        else {
            throw new IllegalArgumentException(pos.toString() + " is not a legal place specification");
        }
    }
    public boolean isOccupied(Vector2d position){
        return this.objectAt(position) != null;
    }
    public IMapElement objectAt(Vector2d position){
        return animals.get(position);
    }
    public abstract Vector2d[] findBoundaries();

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);

        Vector2d[] boundaries = findBoundaries();
        return visualizer.draw(boundaries[0], boundaries[1]);
    }
}
