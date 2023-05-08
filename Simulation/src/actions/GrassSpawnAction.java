package actions;

import entity.Entity;
import entity.Grass;
import game.GameMap;

import java.awt.*;
import java.util.HashMap;

public class GrassSpawnAction extends SpawnAction<Grass> {

    @Override
    public void perform() {
        int currentRate = 0;
        HashMap<Point, Entity> entities = map.getEntitiesMap();
        for (Point point : entities.keySet()) {
            if (entities.get(point) instanceof Grass){
                currentRate++;
            }
        }

        while (currentRate < rate){
            Point point = getEmptyRandomPoint();
            map.setEntity(point, spawnEntity(point));
            currentRate++;
        }
    }

    public GrassSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 20){
            rate = map.getMapSize()/20;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Grass spawnEntity(Point point) {
        return new Grass(point, map);
    }
}
