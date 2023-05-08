package actions;


import entity.Tree;
import game.GameMap;
import java.awt.*;

public class TreeSpawnAction extends SpawnAction<Tree> {
    public TreeSpawnAction(GameMap map) {
        super(map);
        rate = (map.width* map.height)/20;
    }

    @Override
    protected Tree spawnEntity(Point point) {
        return new Tree(point, map);
    }
}
