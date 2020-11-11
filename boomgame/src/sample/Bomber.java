package sample;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class Bomber extends Entity {
    public int speed = 10;
    public Bomber(int x, int y, ImageView imageView){
        super(x,y,imageView);
    }
}
