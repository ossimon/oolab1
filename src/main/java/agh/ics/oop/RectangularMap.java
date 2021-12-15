package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    private final Vector2d leftDownBoundary;
    private final Vector2d rightUpBoundary;

    public RectangularMap(int w, int h){
        leftDownBoundary = new Vector2d(0,0);
        rightUpBoundary = new Vector2d(w - 1, h - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(leftDownBoundary)
                && position.precedes(rightUpBoundary)
                && super.canMoveTo(position);
    }

    @Override
    public Vector2d[] findBoundaries() {
        return new Vector2d[]{this.leftDownBoundary, this.rightUpBoundary};
    }
}
