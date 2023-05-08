package actions;


import entity.Tree;
import game.GameMap;
import java.awt.*;

public class TreeSpawnAction extends SpawnAction<Tree> {
    public TreeSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 20){
            rate = map.getMapSize()/20;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Tree spawnEntity(Point point) {
        return new Tree(point, map);
    }
}
