package actions;

import game.GameMap;

public abstract class Action {
    protected GameMap map;

    public Action(GameMap map) {
        this.map = map;
    }

    public abstract boolean perform();
}
