package agh.ics.oop;

import java.util.Map;

public class Animal {
    private Vector2d position;
    private MapDirection direction;
    private IWorldMap map;

    public Vector2d getPosition() {
        return position;
    }

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

    public boolean isAt(Vector2d position){return this.position.equals(position);}

    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                if(map.canMoveTo(map.fit(this.position.add(this.direction.toUnitVector())))){
                    this.position = map.fit(this.position.add(this.direction.toUnitVector()));
                }
                break;
            case BACKWARD:
                if(map.canMoveTo(map.fit(this.position.add(this.direction.toUnitVector().opposite())))){
                    this.position = map.fit(this.position.add(this.direction.toUnitVector().opposite()));
                }
                break;
        }
    }
}
