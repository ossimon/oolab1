package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest{

    @Test
    public void testPrevious(){
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
    }
    @Test
    public void testNext(){
        MapDirection dir = MapDirection.NORTH;
        assertEquals(dir.next(), MapDirection.EAST);
        dir = MapDirection.WEST;
        assertEquals(dir.next(), MapDirection.NORTH);
        dir = MapDirection.SOUTH;
        assertEquals(dir.next(), MapDirection.WEST);
        dir = MapDirection.EAST;
        assertEquals(dir.next(), MapDirection.SOUTH);
    }

}
