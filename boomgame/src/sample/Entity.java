package sample;


import javafx.scene.image.ImageView;

public abstract class Entity {
    protected int x;
    protected int y;
    protected ImageView imageView ;


public Entity (int x, int y, ImageView imageView){
    this.x = x ;
    this.y = y;
    this.imageView = imageView ;
}
}
