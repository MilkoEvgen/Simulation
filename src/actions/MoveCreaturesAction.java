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
    public boolean perform() {
        boolean isCreatureMoved = false;
        for (Map.Entry<Point, Creature> entry : map.getEntitiesByClass(Creature.class).entrySet()){
            if (entry.getValue().makeMove()){
                isCreatureMoved = true;
            }

        }
        return isCreatureMoved;
    }
}
