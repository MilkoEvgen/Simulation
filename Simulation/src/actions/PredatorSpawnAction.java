package actions;


import entity.Predator;
import game.GameMap;
import java.awt.*;

public class PredatorSpawnAction extends SpawnAction<Predator> {
    public PredatorSpawnAction(GameMap map) {
        super(map);
        rate = (map.width* map.height)/45;
    }

    @Override
    protected Predator spawnEntity(Point point) {
        return new Predator(point, map);
    }
}
