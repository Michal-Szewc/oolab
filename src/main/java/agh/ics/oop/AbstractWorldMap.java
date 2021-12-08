package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionObserver{
    Map<Vector2d, IMapElement> elements = new HashMap<>();
    MapBoundary boundary = new MapBoundary();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            elements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            boundary.add(animal);
            return true;
        }
        throw new IllegalArgumentException("Animal can't be placed at " + animal.getPosition());
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
        return new MapVisualizer(this).draw(boundary.getLowerLeft(),boundary.getUpperRight());
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

    public Vector2d upperRight(){
        return boundary.getUpperRight();
    }

    public Vector2d lowerLeft(){
        return boundary.getLowerLeft();
    }
}
