package actions;

import entity.Grass;
import game.GameMap;

import java.awt.*;

public class GrassSpawnAction extends SpawnAction<Grass> {

    public GrassSpawnAction(GameMap map) {
        super(map);
        rate = (map.width* map.height)/20;
    }

    @Override
    protected Grass spawnEntity(Point point) {
        return new Grass(point, map);
    }
}
