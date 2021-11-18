package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void moveTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.toString(), "Zachód (1, 3)");
    }
    @Test
    public void boundaryTest(){
        Animal animal = new Animal();
        for(int i = 0; i < 4; i++){ animal.move(MoveDirection.FORWARD);}
        assertEquals(animal.toString(), "Północ (2, 4)");
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < 4; i++){ animal.move(MoveDirection.FORWARD);}
        assertEquals(animal.toString(), "Wschód (4, 4)");
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < 4; i++){ animal.move(MoveDirection.FORWARD);}
        assertEquals(animal.toString(), "Południe (4, 0)");
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < 4; i++){ animal.move(MoveDirection.FORWARD);}
        assertEquals(animal.toString(), "Zachód (0, 4)");
    }
}
