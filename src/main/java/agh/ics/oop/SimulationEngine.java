package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private MoveDirection[] commands;
    private IWorldMap map;
    private Vector2d[] positions;

    SimulationEngine(MoveDirection[] commands, IWorldMap map, Vector2d[] positions){
        this.commands = commands;
        this.map = map;
        this.positions = positions;
        for(Vector2d position: positions){
            this.map.place(new Animal(this.map,position));
        }
        System.out.println(this.map);
    }

    @Override
    public void run() {
        Integer i = 0;
        for(MoveDirection command: commands){
            if(this.map.objectAt(positions[i]) instanceof Animal){
                Animal animal = (Animal)(this.map.objectAt(positions[i]));
                animal.move(command);
                positions[i] = animal.getPosition();
            }
            i = (i + 1) % positions.length;
            System.out.println(this.map.toString());
        }
    }
}
