package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int n;

    public GrassField(int n){
        this.n = n;
        for(int i = 0; i < n; i ++){
            Vector2d pos = emptyPosition();
            Grass grass = new Grass (pos);
            elements.put(pos,grass);
            grass.addObserver(this);
            grass.addObserver(boundary);
            boundary.add(grass);
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            if(objectAt(animal.getPosition()) instanceof Grass){
                ((Grass) objectAt(animal.getPosition())).setPosition(emptyPosition());
            }
            elements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            boundary.add(animal);
            return true;
        }
        throw new IllegalArgumentException("Animal can't be placed at " + animal.getPosition());
    }

    @Override
    public Vector2d fit(Vector2d position) {
        return position;
    }

    @Override
    public Vector2d emptyPosition(){
        Random rd = new Random();
        Vector2d position = new Vector2d(rd.nextInt((int)Math.sqrt(n * 10)),rd.nextInt((int)Math.sqrt(n * 10)));
        while (isOccupied(position)){
            position = new Vector2d(rd.nextInt((int)Math.sqrt(n * 10)),rd.nextInt((int)Math.sqrt(n * 10)));
        }
        return position;
    }
}
