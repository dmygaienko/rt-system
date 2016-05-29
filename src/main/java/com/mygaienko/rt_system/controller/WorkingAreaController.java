package com.mygaienko.rt_system.controller;

import com.mygaienko.rt_system.interpreter.Interpreter;
import com.mygaienko.rt_system.model.Lock;
import com.mygaienko.rt_system.model.WorkingArea;
import com.mygaienko.rt_system.model.alarm.Alarm;
import com.mygaienko.rt_system.model.interfaces.Image;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by enda1n on 23.05.2016.
 */
public class WorkingAreaController implements Initializable {

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    private Interpreter interpreter = new Interpreter();

    private final WorkingArea area = WorkingArea.getInstance();

    @FXML
    GridPane grid;

    @FXML
    TextArea commandArea;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        executor.scheduleWithFixedDelay(
                (Runnable) () ->
                        Platform.runLater(() -> {
                            Lock.lock();
                            redrawArea();
                            Lock.releaseLock();
                        }),
                1, 1, TimeUnit.SECONDS);
    }

    @FXML
    private void setAlarm(ActionEvent event) {
        area.setAlarm(Alarm.FIRE);
    }

    @FXML
    private void start(ActionEvent event) {
        area.startProcess();
    }

    private void clear() {
        ObservableList<Node> children = grid.getChildren();
        children.remove(1, children.size());

    }

    @FXML
    private void interpret(ActionEvent event) {
        executor.execute(() -> {
            interpreter.interpet(commandArea.getText());

            commandArea.clear();
        });
    }

    private void redrawArea(){
        clear();

        area.getPositionables().stream()
                .filter(Image::isShowing)
                .forEach(positionable -> grid.add(
                        new ImageView(positionable.getImageUrl()), positionable.getX(), positionable.getY()));
    }

}
