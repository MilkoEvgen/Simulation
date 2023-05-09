package game;

import actions.*;
import java.util.ArrayList;
import java.util.List;


public class Simulation {
    public GameMap map;
    private final List<Action> spawnActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();

    public Simulation(int width, int height) {
        this.map = new GameMap(width, height);
    }

    public void startSimulation() {
        while (map.isMapChanged()) {
            map.setMapChanged(false);
            for (Action action : turnActions) {
                action.perform();
            }
        }
        System.out.println("Симуляция завершена!");
    }

    public boolean makeOneMoveAllCreatures() {
        map.setMapChanged(false);
        for (Action action : turnActions) {
            action.perform();
        }
        if (!map.isMapChanged()) {
            System.out.println("Симуляция завершена!");
        }
        return map.isMapChanged();
    }

    public void initActions() {
        spawnActions.add(new GrassSpawnAction(map));
        spawnActions.add(new RockSpawnAction(map));
        spawnActions.add(new TreeSpawnAction(map));
        spawnActions.add(new PredatorSpawnAction(map));
        spawnActions.add(new HerbivoreSpawnAction(map));
        turnActions.add(new MoveCreaturesAction(map));
        turnActions.add(new GrassSpawnAction(map));
        for (Action spawnAction : spawnActions) {
            spawnAction.perform();
        }
    }

}
