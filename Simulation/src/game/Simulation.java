package game;

import entity.Herbivore;
import entity.Predator;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class Simulation {
    public GameMap map = new GameMap();
    int stepCount;
    public MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();


    public void nextTurn() throws InterruptedException {
        Set<Point> herbivores = map.getHerbivorePoints();
        List<Predator> predatorList = map.returnPredators();
        for (Predator predator : predatorList) {
            predator.makeMove(herbivores, map);
            Thread.sleep(1000);
            mapConsoleRenderer.render(map);
        }

        Set<Point> grass = map.getGrassPoints();
        List<Herbivore> herbivoreList = map.returnHerbivores();
        for (Herbivore herbivore : herbivoreList) {
            herbivore.makeMove(grass, map);
            Thread.sleep(1000);
            mapConsoleRenderer.render(map);
        }
    }

    public void startSimulation(){

    }

    public void pauseSimulation(){

    }
}
