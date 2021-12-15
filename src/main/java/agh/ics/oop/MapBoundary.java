package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private final Comparator<Vector2d> xComparator = new VectorXComparator();
    private final SortedSet<Vector2d> vectorsByX = new TreeSet<>(xComparator);

    private final Comparator<Vector2d> yComparator = new VectorYComparator();
    private final SortedSet<Vector2d> vectorsByY = new TreeSet<>(yComparator);

    private GrassField grassField;

    public MapBoundary(GrassField grassField) {
        this.grassField = grassField;
    }

    public void add(Vector2d position) {
        vectorsByX.add(position);
        vectorsByY.add(position);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (grassField.objectAt(oldPosition) == null) {
            vectorsByX.remove(oldPosition);
            vectorsByY.remove(oldPosition);
        }
        vectorsByX.add(newPosition);
        vectorsByY.add(newPosition);
    }
    public Vector2d getLowerLeftBoundary() {
        Vector2d first = vectorsByX.first();
        int x = first.x;
        first = vectorsByY.first();
        int y = first.y;
//        System.out.println(vectorsByX.size());
//        System.out.println(x);
//        System.out.println(y);
        return new Vector2d(x, y);
    }
    public Vector2d getUpperRightBoundary() {
        Vector2d last = vectorsByX.last();
        int x = last.x;
        last = vectorsByY.last();
        int y = last.y;

//        System.out.println(vectorsByX.size());
//        System.out.println(x);
//        System.out.println(y);

        return new Vector2d(x, y);
    }
}
