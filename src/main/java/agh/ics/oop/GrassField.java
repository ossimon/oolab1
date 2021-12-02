package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grass = new HashMap<>();
    private final int boundary;

    public GrassField (int amount) {
        boundary = (int) sqrt(amount * 10) + 1;
        Random rng = new Random();
        Vector2d pos;
        for (int i = 0; i < amount; i++) {
            do {
                pos = new Vector2d(rng.nextInt(boundary + 1), rng.nextInt(boundary + 1));
            } while (!this.canMoveTo(pos));
            grass.put(pos, new Grass(pos));
        }
    }

    @Override
    public Object objectAt (Vector2d position) {

        Object object = super.objectAt(position);

        if (object != null) {
            return object;
        }
        else {
            return grass.get(position);
        }
    }

    @Override
    protected Vector2d[] findBoundaries() {
        Vector2d start = new Vector2d(0, 0);
        Vector2d end = new Vector2d(boundary, boundary);
        Vector2d animalPos;

        for (Animal animal: animals.values()) {
            animalPos = animal.getPosition();
            start = animalPos.lowerLeft(start);
            end = animalPos.upperRight(end);
        }

        return new Vector2d[]{start.subtract(new Vector2d(1, 1)), end.add(new Vector2d(1, 1))};
    }
}
