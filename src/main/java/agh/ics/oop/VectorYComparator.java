package agh.ics.oop;

import java.util.Comparator;

public class VectorYComparator implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if (o1.y < o2.y) {
            return -1;
        }
        else if (o1.y > o2.y) {
            return 1;
        }
        return o1.x - o2.x;
    }
}
