package actions;

import entity.Creature;
import entity.Entity;
import game.GameMap;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MoveCreaturesAction extends Action{

    public MoveCreaturesAction(GameMap map) {
        super(map);
    }

    @Override
    public void perform() {
//        for (Creature creature : map.getCreaturesList()) {
//            creature.makeMove();
//        }
        for (Map.Entry<Point, Creature> entry : map.getCreaturesByClass(Creature.class).entrySet()){
            entry.getValue().makeMove();
        }
    }
}
