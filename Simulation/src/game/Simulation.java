package game;

import entity.Grass;
import entity.Herbivore;
import entity.Predator;
import java.util.List;


public class Simulation {
    public GameMap map = new GameMap();
    public MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();


    public void nextTurn() {
        List<Predator> predatorList = map.getPredatorsList();
        for (Predator predator : predatorList) {
            predator.makeMove(this, Herbivore.class);
        }

        List<Herbivore> herbivoreList = map.getHerbivoresList();
        for (Herbivore herbivore : herbivoreList) {
            herbivore.makeMove(this, Grass.class);
        }
    }

    public void startSimulation() {

    }

    public void pauseSimulation() {
        mapConsoleRenderer.isPaused = true;
    }
}
