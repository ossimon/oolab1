package agh.ics.oop;

public class Animal {

    private MapDirection orient;
    private Vector2d pos;

    public Animal(){
        orient = MapDirection.NORTH;
        pos = new Vector2d(2, 2);
    }
    public String toString(){
        return orient.toString() + " " + pos.toString();
    }
    public boolean isAt(Vector2d position){
        return this.pos == position;
    }
    public void move(MoveDirection direction){
        Vector2d newPos;
        switch(direction){
            case LEFT -> orient = orient.previous();
            case RIGHT -> orient = orient.next();
            case FORWARD -> {
                newPos = pos.add(orient.toUnitVector());
                if(newPos.follows(new Vector2d(0, 0)) && newPos.precedes(new Vector2d(4, 4))){
                    pos = newPos;
                }
            }
            case BACKWARD -> {
                newPos = pos.subtract(orient.toUnitVector());
                if(newPos.follows(new Vector2d(0, 0)) && newPos.precedes(new Vector2d(4, 4))){
                    pos = newPos;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
