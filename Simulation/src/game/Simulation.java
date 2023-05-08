package game;

import actions.*;
import entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Simulation {
    public GameMap map;
    private final List<Action> spawnActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();

    public Simulation(int width, int height) {
        this.map = new GameMap(width, height);
    }

    public void startSimulation() {
        initActions();
        for (Action spawnAction : spawnActions) {
            spawnAction.perform();
        }
        while (map.isMapChanged) {
            map.isMapChanged = false;
            for (Action action : turnActions) {
                action.perform();
            }
        }
        System.out.println("Симуляция завершена!");
    }

    private void initActions(){
        spawnActions.add(new GrassSpawnAction(map));
        spawnActions.add(new RockSpawnAction(map));
        spawnActions.add(new TreeSpawnAction(map));
        spawnActions.add(new PredatorSpawnAction(map));
        spawnActions.add(new HerbivoreSpawnAction(map));
        turnActions.add(new MoveCreaturesAction(map));
        turnActions.add(new GrassSpawnAction(map));
    }

}
