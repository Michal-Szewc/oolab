package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int n;

    GrassField(int n){
        this.n = n;
        for(int i = 0; i < n; i ++){
            elements.add(new Grass(emptyPosition()));
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            if(objectAt(animal.getPosition()) instanceof Grass){
                ((Grass) objectAt(animal.getPosition())).setPosition(emptyPosition());
            }
            elements.add(animal);
            return true;
        }
        return false;
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
