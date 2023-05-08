package actions;

import entity.Herbivore;
import game.GameMap;
import java.awt.*;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore> {
    public HerbivoreSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 45){
            rate = map.getMapSize()/45;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Herbivore spawnEntity(Point point) {
        return new Herbivore(point, map);
    }
}
