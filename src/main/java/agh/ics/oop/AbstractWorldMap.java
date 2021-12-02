package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionObserver{
    Map<Vector2d, IMapElement> elements = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            elements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public String toString() {
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(0,0);
        boolean first = true;
        for(Vector2d position: elements.keySet()){
            if(first){
                lowerLeft = position;
                upperRight = position;
                first = false;
            }
            else{
                lowerLeft = lowerLeft.lowerLeft(position);
                upperRight = upperRight.upperRight(position);
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

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        elements.put(newPosition,elements.get(oldPosition));
        elements.remove(oldPosition);
    }
}
