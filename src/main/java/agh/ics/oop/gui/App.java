package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.*;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static java.lang.System.exit;
import static java.lang.System.out;

public class App extends Application implements IPositionChangeObserver{

    Label label;
    GridPane grid;
    Scene scene;
    IWorldMap map;
    int leftBoundary;
    int rightBoundary;
    int bottomBoundary;
    int topBoundary;
    int height;
    int width;
    SimulationEngine engine;
    Thread engineThread;


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setTitle("Fajna giera B)");

        grid = new GridPane();

        TextField textField = new TextField();
        Button button = new Button("   Start!   ");
        VBox vBox = new VBox(textField, button);button.setOnAction(value ->  {
            String[] text = textField.getText().split(" ");
            MoveDirection[] directions = OptionsParser.parse(text);

            engine.setDirections(directions);

            engineThread = new Thread(engine);
            engineThread.start();
        });

        HBox hBox = new HBox(vBox, grid);

        this.updateScene();

        for (int i = 0; i < width; i++) grid.getColumnConstraints().add(new ColumnConstraints(40));
        for (int i = 0; i < height; i++) grid.getRowConstraints().add(new RowConstraints(40));

        scene = new Scene(hBox, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void updateScene() throws FileNotFoundException {

        grid.setGridLinesVisible(false);
        grid.setGridLinesVisible(true);

        label = new Label("y/x");
        grid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);

        Vector2d[] boundaries = map.findBoundaries();
        leftBoundary = boundaries[0].x;
        rightBoundary = boundaries[1].x;
        bottomBoundary = boundaries[0].y;
        topBoundary = boundaries[1].y;
        height = topBoundary - bottomBoundary + 2;
        width = rightBoundary - leftBoundary + 2;


        for (int i = bottomBoundary; i <= topBoundary; i++) {
            for (int j = leftBoundary; j <= rightBoundary; j++) {
                label = new Label(Integer.toString(i));
                grid.add(label, 0, topBoundary + 1 - i);
                GridPane.setHalignment(label, HPos.CENTER);

                label = new Label(Integer.toString(j));
                grid.add(label, 1 + j - leftBoundary, 0);
                GridPane.setHalignment(label, HPos.CENTER);

                IMapElement mapElement = (IMapElement) map.objectAt(new Vector2d(j, i));

                if (mapElement != null) {
                    VBox box = new GuiElementBox(mapElement).toBox();
                    grid.add(box, 1 - leftBoundary + j, topBoundary + 1 - i);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }
    }

    public void init() {

        try {
            map = new GrassField(10);
            //map = new RectangularMap(5, 5);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

            engine = new SimulationEngine(map, positions, this);

        } catch(IllegalArgumentException ex) {
            out.println(ex.getMessage());
            exit(0);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            try {
                this.updateScene();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
