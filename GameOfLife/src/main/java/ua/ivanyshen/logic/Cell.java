package ua.ivanyshen.logic;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Cell extends Rectangle {
    public int x;
    public int y;

    @Getter
    private boolean alive;
    private ArrayList<Cell> neighbours;

    public Cell(int size) {
        super(size, size);
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }

    public Cell() {
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }

    public void live() {
        this.alive = true;
        setFill(Color.GREEN);
    }

    public void die() {
        this.alive = false;
        setFill(Color.WHITE);
    }
}

