package actions;


import entity.Rock;
import game.GameMap;
import java.awt.*;

public class RockSpawnAction extends SpawnAction<Rock>{
    public RockSpawnAction(GameMap map) {
        super(map);
        rate = (map.width* map.height)/20;
    }

    @Override
    protected Rock spawnEntity(Point point) {
        return new Rock(point, map);
    }
}
