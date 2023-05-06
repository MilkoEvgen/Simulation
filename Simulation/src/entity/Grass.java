package entity;

import java.awt.*;

public class Grass extends Entity {
    public Grass(Point point) {
        super(point);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83C\uDF3C");
    }
}
