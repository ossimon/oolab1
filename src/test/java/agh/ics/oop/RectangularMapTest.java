package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void placeTest(){
        try{
            RectangularMap map = new RectangularMap(3, 3);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            map.place(animal);
            map.place(animal);
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "(2, 2) is not a legal place specification");
        }
    }
    @Test
    public void canMoveToAndPlaceTest(){
        RectangularMap map = new RectangularMap(3, 3);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)), "zajete");
        assertFalse(map.canMoveTo(new Vector2d(5, 5)), "poza mapą");
        assertTrue(map.canMoveTo(new Vector2d(1, 1)), "wolne");
    }
    @Test
    public void isOccupiedTest(){
        RectangularMap map = new RectangularMap(3, 3);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }
    @Test
    public void objectAt(){
        RectangularMap map = new RectangularMap(3, 3);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertEquals(map.objectAt(new Vector2d(2, 2)), animal);

    }
}
