package agh.ics.oop;

import org.junit.jupiter.api.Test;
import agh.ics.oop.World.*;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest{

    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(1,2);
        assertTrue(v1.equals(v1), "1");
        assertFalse(v1.equals(v2), "2");
        assertTrue(v1.equals(v3), "3");
    }
    @Test
    public void testToString(){
        Vector2d v = new Vector2d(1, 2);
        assertEquals(v.toString(), "(1, 2)");
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,2);
        assertTrue(v1.precedes(v1));
        assertTrue(v1.precedes(v2));
        assertFalse(v1.precedes(v3));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,1);
        assertTrue(v1.follows(v1));
        assertFalse(v1.follows(v2));
        assertTrue(v1.follows(v3));
    }
    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,2);
        assertEquals(v1.upperRight(v1), new Vector2d(1,2));
        assertEquals(v1.upperRight(v2), new Vector2d(2,2));
        assertEquals(v1.upperRight(v3), new Vector2d(1,2));
    }
    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,3);
        assertEquals(v1.lowerLeft(v1), new Vector2d(1, 2));
        assertEquals(v1.lowerLeft(v2), new Vector2d(1, 2));
        assertEquals(v1.lowerLeft(v3), new Vector2d(0, 2));
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,1);
        assertEquals(v1.add(v1), new Vector2d(2, 4));
        assertEquals(v1.add(v2), new Vector2d(3, 4));
        assertEquals(v1.add(v3), new Vector2d(1, 3));
    }
    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(0,1);
        assertEquals(v1.subtract(v1), new Vector2d(0, 0));
        assertEquals(v1.subtract(v2), new Vector2d(-1, 0));
        assertEquals(v1.subtract(v3), new Vector2d(1, 1));
    }
    @Test
    public void testOpposite() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 2);
        Vector2d v3 = new Vector2d(0, 1);
        assertEquals(v1.opposite(), new Vector2d(-1, -2));
        assertEquals(v2.opposite(), new Vector2d(-2, -2));
        assertEquals(v3.opposite(), new Vector2d(-0, -1));
    }
}
