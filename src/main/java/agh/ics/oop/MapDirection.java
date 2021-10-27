package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        return switch(this){
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            default -> "Zachód";
        };
    }

    public MapDirection next(){
        return switch (this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            default -> NORTH;
        };
    }

    public MapDirection previous(){
        return switch (this){
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            default -> NORTH;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            default -> new Vector2d(-1,0);
        };
    }
}
