package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void placeTest(){
        try{
            GrassField map = new GrassField(10);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            map.place(animal);
            map.place(animal);
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "(2, 2) is not a legal place specification");
        }
    }
    @Test
    public void canMoveToAndPlaceTest(){
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(55, 55)));
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
    }
    @Test
    public void isOccupiedTest(){
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }
    @Test
    public void objectAt(){
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assertEquals(map.objectAt(new Vector2d(2, 2)), animal);

    }
}
