package ua.ivanyshen.renderer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ua.ivanyshen.logic.Cell;

import java.util.ArrayList;

public class Renderer extends Application {

    private final int rows = 10;
    private final int columns = 10;
    private final int cellSize = 30;

    private ArrayList<Cell> cells;

    public Renderer() {
        cells = new ArrayList<>();
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int finalRow = row;
                int finalCol = col;
                Cell cell = createCell(finalCol, finalRow);
                cell.setOnMouseClicked(event -> {
                    changeState(cell, finalCol, finalRow);
                });

                cells.add(cell);
                grid.add(cell, col, row);
            }
        }

        Scene scene = new Scene(grid, columns * cellSize, rows * cellSize);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Editable Grid");
        primaryStage.show();
    }

    private void changeState(Cell cell, int x, int y) {
        if(cell.isAlive()) {
            cell.die();
        }
        else {
            cell.live();
        }

        System.out.println(cells.toString());
    }

    private Cell createCell(int x, int y) {
        Cell cell = new Cell(cellSize);
        cell.x = x;
        cell.y = y;
        return cell;
    }

    public void render() {
        launch();
    }
}