package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private Integer width;
    private Integer height;
    List<Animal> animals;

    RectangularMap(Integer width, Integer height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(fit(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition())){
            return false;
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public Vector2d fit(Vector2d position) {
        Vector2d temp = new Vector2d(position.x % (this.width + 1), position.y % (this.height + 1));
        temp = temp.add(new Vector2d(this.width + 1, this.height + 1));
        return new Vector2d(temp.x % (this.width + 1), temp.y % (this.height + 1));
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }
}
