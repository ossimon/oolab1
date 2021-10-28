package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] dirList1 = {"f", "forward", "b", "backward", "l", "left", "r", "right", "try"};
        MoveDirection[] dirList = OptionsParser.parse(dirList1);
        assertEquals(dirList[0], MoveDirection.FORWARD);
        assertEquals(dirList[1], MoveDirection.FORWARD);
        assertEquals(dirList[2], MoveDirection.BACKWARD);
        assertEquals(dirList[3], MoveDirection.BACKWARD);
        assertEquals(dirList[4], MoveDirection.LEFT);
        assertEquals(dirList[5], MoveDirection.LEFT);
        assertEquals(dirList[6], MoveDirection.RIGHT);
        assertEquals(dirList[7], MoveDirection.RIGHT);
        assertEquals(dirList[8], null);
    }
}
