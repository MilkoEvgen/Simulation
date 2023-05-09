package actions;


import entity.Rock;
import game.GameMap;
import java.awt.*;

public class RockSpawnAction extends SpawnAction<Rock>{
    public RockSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 20){
            rate = map.getMapSize()/10;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Rock spawnEntity(Point point) {
        return new Rock(point, map);
    }
}
