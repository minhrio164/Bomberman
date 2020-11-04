package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Image right = new Image(new FileInputStream("/Users/mac/IdeaProjects/Bomberman/src/Image/right.png"));
        Image left = new Image(new FileInputStream("/Users/mac/IdeaProjects/Bomberman/src/Image/leff.png"));
        Image font = new Image(new FileInputStream("/Users/mac/IdeaProjects/Bomberman/src/Image/font.png"));
        Image back = new Image(new FileInputStream("/Users/mac/IdeaProjects/Bomberman/src/Image/back.png"));

        ImageView imageView = new ImageView(right);
        imageView.setX(50);
        imageView.setY(50);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        imageView.setId("bomber");

        ImageView boom = new ImageView(right);
        boom.setFitWidth(50);
        boom.setFitHeight(50);
        boom.setPreserveRatio(true);


        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(0);
        rectangle1.setY(0);
        rectangle1.setWidth(600);
        rectangle1.setHeight(600);
        rectangle1.setId("rectangle1");
        Pane root = new Pane();
        root.getChildren().addAll(rectangle1, imageView, boom);

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("BomBerMan");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        imageView.setLayoutY(imageView.getLayoutY() - 10);
                        imageView.setImage(back);
                        System.out.println(imageView.getLayoutX());
                        break;
                    case DOWN:
                        imageView.setLayoutY(imageView.getLayoutY() + 10);
                        imageView.setImage(font);
                        break;

                    case RIGHT:
                        imageView.setLayoutX(imageView.getLayoutX() + 10);
                        imageView.setImage(right);
                        break;

                    case LEFT:
                        imageView.setLayoutX(imageView.getLayoutX() - 10);
                        imageView.setImage(left);
                        break;
                    case SPACE:
                        boom.setLayoutX(imageView.getLayoutX());
                        boom.setLayoutY(imageView.getLayoutY());
                        break;


                }
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
