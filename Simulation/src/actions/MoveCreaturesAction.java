package actions;

import entity.Creature;
import game.GameMap;


public class MoveCreaturesAction extends Action{

    public MoveCreaturesAction(GameMap map) {
        super(map);
    }

    @Override
    public void perform() {
        for (Creature creature : map.getCreaturesList()) {
            creature.makeMove();
        }
    }
}
