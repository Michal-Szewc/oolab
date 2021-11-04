package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection direction;

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Animal(){
        position = new Vector2d(2,2);
        direction = MapDirection.NORTH;
    }

    public String toString(){
        return "pozycjia: " + position + ", kierunek: " + direction;
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
                if (this.position.add(this.direction.toUnitVector()).proceeds(new Vector2d(4, 4)) && this.position.add(this.direction.toUnitVector()).follows(new Vector2d(0, 0))) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                if (this.position.add(this.direction.toUnitVector().opposite()).proceeds(new Vector2d(4,4)) && this.position.add(this.direction.toUnitVector().opposite()).follows(new Vector2d(0,0))){
                    this.position = this.position.add(this.direction.toUnitVector().opposite());
                }
                break;
        }
    }
}
