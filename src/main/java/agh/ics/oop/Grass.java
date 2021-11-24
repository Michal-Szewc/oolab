package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

    public void setPosition(Vector2d newPosition){
        this.position = newPosition;
    }

    public Grass(Vector2d initialPosition){
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return "*";
    }
}
