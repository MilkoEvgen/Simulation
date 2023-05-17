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
        boolean isCreaturesMoved = true;
        while (isCreaturesMoved) {
            isCreaturesMoved = false;
            for (Action action : turnActions) {
                if (action.perform()){
                    isCreaturesMoved = true;
                }
            }
        }
        System.out.println("Симуляция завершена!");
    }

    public boolean makeOneMoveAllCreatures() {
        boolean isCreaturesMoved = false;
        for (Action action : turnActions) {
            if (action.perform()){
                isCreaturesMoved = true;
            }
        }
        if (!isCreaturesMoved) {
            System.out.println("Симуляция завершена!");
        }
        return isCreaturesMoved;
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
