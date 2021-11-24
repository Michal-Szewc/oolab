package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private Integer width;
    private Integer height;

    RectangularMap(Integer width, Integer height){
        this.width = width;
        this.height = height;
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

    @Override
    public Vector2d emptyPosition(){
        for(int x = 0; x < width; x ++){
            for(int y = 0; y < height; y ++){
                if(isOccupied(new Vector2d(x,y)))
                    return new Vector2d(x,y);
            }
        }
        return null;
    }
}
