package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import javafx.scene.text.TextBuilder;
import javafx.util.Duration;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameCode extends Application{
    public Label username;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    private Button startButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        Scene scene = new Scene(root,300,300);

        primaryStage.setTitle("Simon Says");
        primaryStage.setScene(scene);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(10);

        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");

        buttonContainer.getChildren().addAll(button1, button2, button3, button4);

        HBox controlContainer = new HBox();
        controlContainer.setAlignment(Pos.CENTER);
        controlContainer.setSpacing(10);
        final TextField name = new TextField();
        name.setPromptText("Enter your username.");
        name.setPrefColumnCount(10);
        name.getText();

        startButton = new Button("Start Game");
        startButton.setStyle("-fx-min-width: 80px;" + "-fx-max-width: 80px;");
        controlContainer.getChildren().addAll(startButton, name);


        root.getChildren().addAll(buttonContainer, controlContainer);
        scene.getStylesheets().add(this.getClass().getResource("Display.css").toExternalForm());

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controlContainer.getChildren().removeAll(startButton, name);

                new AnimationTimer() {
                    private long tick;
                    private int round = 1;

                    @Override
                    public void handle(long now) {
                        if (this.tick == 0) this.tick = now;
                        long dt = now - this.tick;
                        int i=0;

                        if (dt > 0.5 * 1e9) {
                            button1.setStyle("-fx-background-color: white;");
                            button2.setStyle("-fx-background-color: white;");
                            button3.setStyle("-fx-background-color: white;");
                            button4.setStyle("-fx-background-color: white;");
                        }

                        if (dt > 1 * 1e9) {
                            System.out.println("Per 3s");
                            int r = ((int)(Math.random() * 4) + 1);
                            if (r == 1) {
                                button1.setStyle("-fx-background-color: yellow;");
                            }
                            if (r == 2) {
                                button2.setStyle("-fx-background-color: yellow;");
                            }
                            if (r == 3) {
                                button3.setStyle("-fx-background-color: yellow;");
                            }
                            if (r == 4) {
                                button4.setStyle("-fx-background-color: yellow;");
                            }

                            }
                        }
                }.start();
            }
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public void lightUp()
    {
        int round = 0;
        for(int i = 1; i< round + 1;i++)
        {
            int r = (int)((Math.random() *4) + 1);
            System.out.println(i);
            if(r == 1)
            {
                button1.setStyle("-fx-background-color: yellow;");
            }
            if(r == 2)
            {
                button2.setStyle("-fx-background-color: yellow;");
            }
            if(r == 3)
            {
                button3.setStyle("-fx-background-color: yellow;");
            }
            if(r == 4)
            {
                button4.setStyle("-fx-background-color: yellow;");
            }

        }
    }



}
