package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField (int amount) {
        int boundary = (int) sqrt(amount * 10) + 1;
        Random rng = new Random();
        Vector2d pos;
        for (int i = 0; i < amount; i++) {
            do {
                pos = new Vector2d(rng.nextInt(boundary + 1), rng.nextInt(boundary + 1));
            } while (!this.canMoveTo(pos));
            grasses.add(new Grass(pos));
        }
    }

    @Override
    public Object objectAt (Vector2d position) {

        Object object = super.objectAt(position);

        if (object != null) {
            return object;
        }
        else {
            Vector2d grassPos;
            for (Grass grass : grasses) {
                grassPos = grass.getPosition();
                if (grassPos.equals(position)) {
                    return grass;
                }
            }
        }
        return null;
    }

    @Override
    protected Vector2d[] findBoundaries() {
        Vector2d animalPos = animals.get(0).getPosition();
        Vector2d start = new Vector2d(animalPos.x, animalPos.y);
        Vector2d end = new Vector2d(animalPos.x, animalPos.y);

        for (Animal animal: animals) {
            animalPos = animal.getPosition();
            start = animalPos.lowerLeft(start);
            end = animalPos.upperRight(end);
        }

        return new Vector2d[]{start.subtract(new Vector2d(1, 1)), end.add(new Vector2d(1, 1))};
    }
}
