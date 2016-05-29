package com.mygaienko.rt_system.controller;

import com.mygaienko.rt_system.interpreter.Interpreter;
import com.mygaienko.rt_system.model.WorkingArea;
import com.mygaienko.rt_system.model.interfaces.Image;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by enda1n on 23.05.2016.
 */
public class WorkingAreaController implements Initializable {

    private Interpreter interpreter = new Interpreter();

    @FXML
    GridPane grid;

    @FXML
    TextArea commandArea;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        redrawArea();
    }

    @FXML
    private void setAlarm(ActionEvent event) {
        System.out.println("alarm");
        grid.add(new Button("b1"), 0, 0);
        grid.add(new Button("b2"), 0, 1);

        grid.add(new ImageView("/image/box.jpg"), 0, 2);
    }

    @FXML
    private void clear(ActionEvent event) {
        clear();
    }

    private void clear() {
        ObservableList<Node> children = grid.getChildren();
       /* children.clear();*/
        children.remove(1, children.size());

    }

    @FXML
    private void interpret(ActionEvent event) {
        interpreter.interpet(commandArea.getText());

        commandArea.clear();

        redrawArea();
    }

    private void redrawArea(){
        clear();

        WorkingArea area = WorkingArea.getInstance();
        area.getPositionables().stream().
                filter(Image::isShowing).
                forEach(positionable -> grid.add(
                        new ImageView(positionable.getImageUrl()), positionable.getX(), positionable.getY()));
    }

}
