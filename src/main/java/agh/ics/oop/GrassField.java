package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grass = new HashMap<>();
    private final int boundary;
    private MapBoundary mapBoundary = new MapBoundary(this);

    public GrassField (int amount) {
        boundary = (int) sqrt(amount * 10) + 1;
        Random rng = new Random();
        Vector2d pos;
        for (int i = 0; i < amount; i++) {
            do {
                pos = new Vector2d(rng.nextInt(boundary + 1), rng.nextInt(boundary + 1));
            } while (!this.canMoveTo(pos));
            grass.put(pos, new Grass(pos));
            mapBoundary.add(pos);
        }
    }
    @Override
    public void place(Animal animal) {
        super.place(animal);
        mapBoundary.add(animal.getPosition());
    }

    @Override
    public IMapElement objectAt (Vector2d position) {

        IMapElement object = super.objectAt(position);

        if (object != null) {
            return object;
        }
        else {
            return grass.get(position);
        }
    }

    @Override
    public Vector2d[] findBoundaries() {

        Vector2d start = mapBoundary.getLowerLeftBoundary();
        Vector2d end = mapBoundary.getUpperRightBoundary();

        start = start.subtract(new Vector2d(1, 1));
        end = end.add(new Vector2d(1, 1));

        return new Vector2d[]{start, end};
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }
}
