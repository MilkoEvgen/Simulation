package actions;

import entity.Creature;
import game.GameMap;

import java.awt.*;
import java.util.Map;


public class MoveCreaturesAction extends Action{

    public MoveCreaturesAction(GameMap map) {
        super(map);
    }

    @Override
    public void perform() {
        for (Map.Entry<Point, Creature> entry : map.getCreaturesByClass(Creature.class).entrySet()){
            entry.getValue().makeMove();
        }
    }
}
