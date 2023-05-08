package game;

import actions.*;
import entity.Creature;
import entity.Grass;
import entity.Herbivore;
import entity.Predator;

import java.util.ArrayList;
import java.util.List;


public class Simulation {
    public GameMap map;
    public MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

    public Simulation(int width, int height) {
        this.map = new GameMap(width, height);
    }

    public void nextTurn() {
        List<Creature> creatures = map.getCreaturesList();
        for (Creature creature : creatures) {
            creature.makeMove(this);
        }


//        List<Predator> predatorList = map.getPredatorsList();
//        for (Predator predator : predatorList) {
//            predator.makeMove(this);
//        }
//
//        List<Herbivore> herbivoreList = map.getHerbivoresList();
//        for (Herbivore herbivore : herbivoreList) {
//            herbivore.makeMove(this);
//        }
    }

    public void startSimulation() {
        List<Action> spawnActions = new ArrayList<>();
        spawnActions.add(new GrassSpawnAction(map));
        spawnActions.add(new RockSpawnAction(map));
        spawnActions.add(new TreeSpawnAction(map));
        spawnActions.add(new PredatorSpawnAction(map));
        spawnActions.add(new HerbivoreSpawnAction(map));
        for (Action spawnAction : spawnActions) {
            spawnAction.perform();
        }

    }

    public void pauseSimulation() {
        mapConsoleRenderer.isPaused = true;
    }
}
