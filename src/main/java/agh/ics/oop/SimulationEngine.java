package agh.ics.oop;
import java.util.*;


public class SimulationEngine implements IEngine {

    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for(Vector2d pos: positions){
            Animal animal = new Animal(map, pos);
            map.place(animal);
            animals.add(animal);
        }
    }

    public void run() {
        int n = animals.size();
        for(int i = 0; i < directions.length; i++){
            Animal animal = animals.get(i % n);
            animal.move(directions[i]);
            System.out.println(map);
        }
    }
}
