package entity;

import java.awt.*;

public class Tree extends Entity{

    public Tree(Point point) {
        super(point);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83C\uDF33");
    }
}
