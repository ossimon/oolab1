package agh.ics.oop;
import agh.ics.oop.gui.App;

import java.util.*;


public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] directions;
    private final IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions, App app){
        this.directions = directions;
        this.map = map;
        for(Vector2d pos: positions){
            Animal animal = new Animal(map, pos);
            animal.addObserver(app);
            map.place(animal);
            animals.add(animal);
        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positions, App app){
        this.map = map;
        for(Vector2d pos: positions){
            Animal animal = new Animal(map, pos);
            animal.addObserver(app);
            map.place(animal);
            animals.add(animal);
        }
    }

    public void setDirections(MoveDirection[] directions){
        this.directions = directions;
    }

    public void run() {
        int n = animals.size();
        int moveDelay = 500;
        for(int i = 0; i < directions.length; i++){
            Animal animal = animals.get(i % n);
            animal.move(directions[i]);
//            System.out.println(map);
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
