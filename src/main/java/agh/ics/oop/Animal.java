package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction;
    private final IWorldMap map;

    public MapDirection getDirection() {
        return direction;
    }

    public Animal(IWorldMap map){
        position = new Vector2d(2,2);
        direction = MapDirection.NORTH;
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        position = initialPosition;
        direction = MapDirection.NORTH;
        this.map = map;
    }

    public String toString(){
        return direction.toString();
    }

    public void move(MoveDirection direction){
        Vector2d newPosition = position;
        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                if(map.canMoveTo(map.fit(this.position.add(this.direction.toUnitVector())))){
                    newPosition = map.fit(this.position.add(this.direction.toUnitVector()));
                }
                break;
            case BACKWARD:
                if(map.canMoveTo(map.fit(this.position.add(this.direction.toUnitVector().opposite())))){
                    newPosition = map.fit(this.position.add(this.direction.toUnitVector().opposite()));
                }
                break;
        }

        // Checks if there is grass to eat

        if(this.map.objectAt(newPosition) instanceof Grass){
            ((Grass) this.map.objectAt(newPosition)).setPosition(this.map.emptyPosition());
        }
        if(!position.equals(newPosition))
            positionChange(position,newPosition);
        this.position = newPosition;
    }
}
