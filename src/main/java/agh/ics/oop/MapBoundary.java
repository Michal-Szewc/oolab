package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionObserver{
    Comparator<Vector2d> compX = (a, b) -> {
        if (a.x == b.x && a.y == b.y)
            return 0;
        if (a.x == b.x) {
            if (a.y > b.y)
                return 1;
            return -1;
        }
        if (a.x > b.x)
            return 1;
        return -1;
    };

    Comparator<Vector2d> compY = (a, b) -> {
        if (a.y == b.y && a.x == b.x)
            return 0;
        if (a.y == b.y) {
            if (a.x > b.x)
                return 1;
            return -1;
        }
        if (a.y > b.y)
            return 1;
        return -1;
    };

    SortedMap<Vector2d,IMapElement> x = new TreeMap<>(compX);
    SortedMap<Vector2d,IMapElement> y = new TreeMap<>(compY);

    public void add(IMapElement element){
        if(x.containsKey(element.getPosition()))
            throw new IllegalArgumentException("Object cannot be placed at " + element.getPosition());
        x.put(element.getPosition(),element);
        y.put(element.getPosition(),element);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = x.get(oldPosition);
        x.remove(oldPosition);
        y.remove(oldPosition);
        x.put(newPosition,element);
        y.put(newPosition,element);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(x.firstKey().x,y.firstKey().y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(x.lastKey().x,y.lastKey().y);
    }
}
