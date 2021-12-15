package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    Image image;
    ImageView imageView;
    Label label;

    GuiElementBox(IMapElement mapElement) throws FileNotFoundException {

        image = new Image(new FileInputStream(mapElement.getImageFile()));

        imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        label = new Label(mapElement.getPosition().toString());

    }

    public VBox toBox() {

        VBox box = new VBox(imageView, label);
        box.setAlignment(Pos.CENTER);
        return box;
    }
}
