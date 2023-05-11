package actions;


import entity.Predator;
import game.GameMap;
import java.awt.*;

public class PredatorSpawnAction extends SpawnAction<Predator> {
    public PredatorSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 45){
            rate = map.getMapSize()/45;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Predator spawnEntity(Point point) {
        return new Predator(point, map);
    }
}
