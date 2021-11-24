package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class AbstractWorldMap implements IWorldMap{
    List<IMapElement> elements = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            elements.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element: elements){
            if(element.isAt(position))
                return element;
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public String toString() {
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(0,0);
        boolean first = true;
        for(IMapElement element: elements){
            if(first){
                lowerLeft = element.getPosition();
                upperRight = element.getPosition();
                first = false;
            }
            else{
                lowerLeft = lowerLeft.lowerLeft(element.getPosition());
                upperRight = upperRight.upperRight(element.getPosition());
            }
        }
        return new MapVisualizer(this).draw(lowerLeft,upperRight);
    }

    @Override
    public Vector2d emptyPosition(){
        Random rd = new Random();
        Vector2d position = new Vector2d(rd.nextInt(),rd.nextInt());
        while (isOccupied(position)){
            position = new Vector2d(rd.nextInt(),rd.nextInt());
        }
        return position;
    }
}
