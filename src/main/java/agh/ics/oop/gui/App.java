package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage){

        MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw());
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        for(int y = map.lowerLeft().y; y <= map.upperRight().y + 1; y++)
            grid.getRowConstraints().add(new RowConstraints(15));

        for(int x = map.lowerLeft().x; x <= map.upperRight().x + 1; x++)
            grid.getColumnConstraints().add(new ColumnConstraints(15));

        grid.add(new Label("y/x"),0, 0,1,1);
        for(int x = map.lowerLeft().x; x <= map.upperRight().x; x++) {
            Label l = new Label(((Integer) x).toString());
            GridPane.setHalignment(l, HPos.CENTER);
            grid.add(l, x - map.lowerLeft().x + 1, 0, 1, 1);
        }
        for(int y = map.lowerLeft().y; y <= map.upperRight().y; y++){
            Label l = new Label(((Integer)y).toString());
            GridPane.setHalignment(l, HPos.CENTER);
            grid.add(l ,0,y - map.lowerLeft().y + 1,1,1);
            for(int x = map.lowerLeft().x; x <= map.upperRight().x; x++){
                if(map.isOccupied(new Vector2d(x, y))){
                    l = new Label(map.objectAt(new Vector2d(x, y)).toString());
                    GridPane.setHalignment(l, HPos.CENTER);
                    grid.add(l, x - map.lowerLeft().x + 1, y - map.lowerLeft().y + 1,1,1);
                }
            }
        }




        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
