package agh.ics.oop;

public class OptionsParser {

    //public OptionsParser(){}
    public static MoveDirection[] parse(String[] inputDirs){
        int l = inputDirs.length;
        MoveDirection[] directions = new MoveDirection[l];

        for(int i = 0; i < l; i++){
            directions[i] = switch (inputDirs[i]){
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "l", "left" -> MoveDirection.LEFT;
                case "r", "right" -> MoveDirection.RIGHT;
                default -> null;
                //teścik
            };
        }

        return directions;
    }
}
