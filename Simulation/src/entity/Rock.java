package entity;

import java.awt.*;

public class Rock extends Entity {
    public Rock(Point point) {
        super(point);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83D\uDDFB");
    }
}
