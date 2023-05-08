package actions;

import entity.Herbivore;
import game.GameMap;
import java.awt.*;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore> {
    public HerbivoreSpawnAction(GameMap map) {
        super(map);
        rate = (map.width* map.height)/45;
    }

    @Override
    protected Herbivore spawnEntity(Point point) {
        return new Herbivore(point, map);
    }
}
