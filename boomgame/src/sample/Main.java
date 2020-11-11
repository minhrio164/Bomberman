package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.*;


public class Main extends Application {

    Stage stage;
    Pane root = new Pane();
    Scene scene = new Scene(root);
    String Bomber_Path = "/Users/mac/Desktop/Code/boomgame/src/image/font.png";
    Image Bomber_image = new Image(new FileInputStream(Bomber_Path));
    ImageView Bomber_ImageView = new ImageView(Bomber_image);
    String Grass_Path = "/Users/mac/Desktop/Code/boomgame/src/image/Grass-01.png";
    Image Grass_Image = new Image(new FileInputStream(Grass_Path));
    ImageView Grass_ImageView = new ImageView(Grass_Image);
    String Wall_path = "/Users/mac/Desktop/Code/boomgame/src/image/Wall-01.png";
    Image Wall_image = new Image(new FileInputStream(Wall_path));
    ImageView Wall_ImageView = new ImageView(Wall_image);
    String Brick_path = "/Users/mac/Desktop/Code/boomgame/src/image/Brick-01.png";
    Image Brick_Image = new Image(new FileInputStream(Brick_path));
    ImageView Brick_ImageView = new ImageView(Brick_Image);
    Image Ballon_Image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/ballon-01.png"));
    ImageView Ballon_ImageView = new ImageView(Ballon_Image);
    Image Oneal_Image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Oneal-01.png"));
    ImageView Oneal_ImageView = new ImageView(Oneal_Image);
    int Pixel_Height = 40;
    int Pixel_Width = 40;
    ImageView[] imageviewofBomber = new ImageView[10000];
    List<Bomber> listofBomber = new ArrayList<Bomber>(1000);
    int bomberSpeed = Pixel_Width;
    ImageView[] imageviewofWall = new ImageView[10000];
    List<Wall> listofWall = new ArrayList<Wall>(1000);
    List<Grass> listofGlass = new ArrayList<Grass>(1000);
    ImageView[] imageviewofGlass = new ImageView[10000];
    ImageView[] imageviewofBrick = new ImageView[10000];
    List<Brick> listofBrick = new ArrayList<Brick>(1000);
    ImageView[] imageviewofBallon = new ImageView[10000];
    List<Ballon> listofBallon = new ArrayList<Ballon>(1000);
    int ballonSpeed = Pixel_Width;
    ImageView[] imageviewofOneal = new ImageView[10000];
    List<Oneal> listofOneal = new ArrayList<Oneal>(1000);
    public Main() throws FileNotFoundException {
    }




    /*Bomber bomber = new Bomber(50,50,Brick_ImageView);
    Bomber bomber1 = new Bomber(100,100,Bomber_ImageView);
    Brick brick = new Brick(100,100,Brick_ImageView);
    Grass grass = new Grass(50,50,Wall_ImageView);
    Grass grass1 = new Grass(100,100,Wall_ImageView);
    Wall wall = new Wall( 200, 200 , Wall_ImageView);
    Wall wall2 = new Wall( 300, 200 , Wall_ImageView);
    public void add(){
        listofGlass.add(grass);
        listofGlass.add(grass1);
    }*/

    public static void main(String[] args) {
        launch(args);
    }

    /*public void pri() {
        System.out.println(listofWall.size());
        System.out.println(listofBrick.size());
        System.out.println(listofGlass.size());
        System.out.println(listofBomber.size());
        System.out.println("a");

    }*/

    public void rendermap() {
        File file = new File("/Users/mac/Desktop/Code/boomgame/src/map.txt");
        try {
            Scanner scanner = new Scanner(file);
            String firstline = scanner.nextLine();
            String[] mapsize = firstline.split(" ", 3);
            stage.setWidth(Integer.parseInt(mapsize[2]) * Pixel_Width);
            stage.setHeight(Integer.parseInt(mapsize[1]) * Pixel_Width);
            int temp = 1;
            while (scanner.hasNextLine()) {

                String data = scanner.nextLine();
                for (int i = 0; i < Integer.parseInt(mapsize[2]); i++) {
                    char key = data.charAt(i);
                    Grass grass = new Grass(i * Pixel_Width, (temp - 1) * Pixel_Height, Grass_ImageView);
                    listofGlass.add(grass);

                    if (key == '#') {
                        Wall wall = new Wall(i * Pixel_Width, (temp - 1) * Pixel_Height, Wall_ImageView);
                        listofWall.add(wall);
                    } else if (key == '*') {
                        Brick brick = new Brick(i * Pixel_Width, (temp - 1) * Pixel_Height, Brick_ImageView);
                        listofBrick.add(brick);
                    } else if (key == 'p') {
                        Bomber bomber = new Bomber(i * Pixel_Width, (temp - 1) * Pixel_Height, Bomber_ImageView);
                        listofBomber.add(bomber);
                    } else if (key == '1') {
                        Ballon ballon = new Ballon(i * Pixel_Width, (temp - 1) * Pixel_Height, Ballon_ImageView);
                        listofBallon.add(ballon);
                    } else if (key == '2') {
                        Oneal oneal = new Oneal(i * Pixel_Width, (temp - 1) * Pixel_Height, Oneal_ImageView);
                        listofOneal.add(oneal);
                    }

                }
                temp++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

    public void createEntity() throws FileNotFoundException {


        for (int i = 0; i < listofGlass.size(); i++) {
            imageviewofGlass[i] = new ImageView(Grass_Image);
            imageviewofGlass[i].setX(listofGlass.get(i).x);
            imageviewofGlass[i].setY(listofGlass.get(i).y);
            imageviewofGlass[i].setFitHeight(Pixel_Height);
            imageviewofGlass[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofGlass[i]);

        }
        for (int i = 0; i < listofWall.size(); i++) {
            imageviewofWall[i] = new ImageView(Wall_image);
            imageviewofWall[i].setX(listofWall.get(i).x);
            imageviewofWall[i].setY(listofWall.get(i).y);
            imageviewofWall[i].setFitHeight(Pixel_Height);
            imageviewofWall[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofWall[i]);

        }
        for (int i = 0; i < listofBrick.size(); i++) {
            imageviewofBrick[i] = new ImageView(Brick_Image);
            imageviewofBrick[i].setX(listofBrick.get(i).x);
            imageviewofBrick[i].setY(listofBrick.get(i).y);
            imageviewofBrick[i].setFitWidth(Pixel_Width);
            imageviewofBrick[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBrick[i]);

        }
        for (int i = 0; i < listofBomber.size(); i++) {
            imageviewofBomber[i] = new ImageView(Bomber_image);
            imageviewofBomber[i].setX(listofBomber.get(i).x);
            imageviewofBomber[i].setY(listofBomber.get(i).y);
            imageviewofBomber[i].setFitWidth(Pixel_Width);
            imageviewofBomber[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBomber[i]);

        }
        for (int i = 0; i < listofBallon.size(); i++) {
            imageviewofBallon[i] = new ImageView(Ballon_Image);
            imageviewofBallon[i].setX(listofBallon.get(i).x);
            imageviewofBallon[i].setY(listofBallon.get(i).y);
            imageviewofBallon[i].setFitWidth(Pixel_Width);
            imageviewofBallon[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBallon[i]);

        }
        for (int i = 0; i < listofOneal.size(); i++) {
            imageviewofOneal[i] = new ImageView(Oneal_Image);
            imageviewofOneal[i].setX(listofOneal.get(i).x);
            imageviewofOneal[i].setY(listofOneal.get(i).y);
            imageviewofOneal[i].setFitHeight(Pixel_Height);
            imageviewofOneal[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofOneal[i]);
        }

        Image imageofPortal = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/portal-01.png"));
        ImageView imageviewofPortal = new ImageView(imageofPortal);
        Random rd = new Random();
        int a = rd.nextInt(listofBrick.size());
        imageviewofPortal.setX(listofBrick.get(a).x);
        imageviewofPortal.setY(listofBrick.get(a).y);
        imageviewofPortal.setFitHeight(Pixel_Height);
        imageviewofPortal.setFitWidth(Pixel_Width);
        root.getChildren().add(imageviewofPortal);
    }

    public int check_move(double x, double y) {
        int a = 0;
        for (int i = 0; i < listofWall.size(); i++) {
            if ((x - imageviewofWall[i].getX()) == 0
                    && (y - imageviewofWall[i].getY()) == 0) {
                a++;
            }
            for (int k = 0; k < listofBrick.size(); k++) {
                if ((x - imageviewofBrick[k].getX() == 0
                        && (y - imageviewofBrick[k].getY()) == 0)) {
                    a++;
                    break;
                }
            }

        }
        return a;
    }

    public void ballon_move() {

            for(int i =0 ; i<listofBallon.size() ; i++){
                double move_left = imageviewofBallon[i].getX() - ballonSpeed ;
                double move_right = imageviewofBallon[i].getY() - ballonSpeed;
                if(check_move(move_left,imageviewofBallon[i].getY()) == 0 ){
                    imageviewofBallon[i].setX(move_left);
                }
                else {
                    imageviewofBallon[i].setX(move_right);
                }


            }



    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        rendermap();
        createEntity();
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ballon_move();
            }
        },1000,100);
        //pri();

        Pane mainScreen = new Pane();
        mainScreen.setId("pane");
        Scene sceneScreen = new Scene(mainScreen);
        stage.setScene(sceneScreen);
        stage.show();
        Button startButton = new Button();
        startButton.setLayoutX(100);
        startButton.setLayoutY(250);
        startButton.setPrefSize(200, 60);
        startButton.setId("startButton");
        mainScreen.getChildren().addAll(startButton);
        sceneScreen.getStylesheets().add(getClass().getResource("mainScreen.css").toExternalForm());
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                stage.show();
            }
        });

        stage.setTitle("BomberMan");
        stage.setResizable(false);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {

                    case UP:
                        double Up_move = imageviewofBomber[0].getY() - bomberSpeed;
                        if (check_move(imageviewofBomber[0].getX(), Up_move) == 0) {
                            imageviewofBomber[0].setY(Up_move);
                            Bomber_Path = "/Users/mac/Desktop/Code/boomgame/src/image/back.png";

                        }
                        break;
                    case DOWN:

                        double Down_move = (imageviewofBomber[0].getY() + bomberSpeed);
                        if (check_move(imageviewofBomber[0].getX(), Down_move) == 0) {
                            imageviewofBomber[0].setY(Down_move);
                        }
                        break;
                    case RIGHT:
                        double Right_move = (imageviewofBomber[0].getX() + bomberSpeed);
                        if (check_move(Right_move, imageviewofBomber[0].getY()) == 0) {
                            imageviewofBomber[0].setX(Right_move);
                        }
                        break;
                    case LEFT:
                        double Left_move = (imageviewofBomber[0].getX() - bomberSpeed);
                        if (check_move(Left_move, imageviewofBomber[0].getY()) == 0) {
                            imageviewofBomber[0].setX(Left_move);
                        }
                        break;


                }
            }
        });

    }
}




