package jeuDeRole;

import java.util.Random;

public class BuildLevel {
	public MyWorld buildLevel( MyWorld world, int number, TypeObject nameObject) throws ExceptionPosition{
		Random r = new Random();
		Position position = null;
		int line, column;
		for(int i=0; i<number; i++){
			line = r.nextInt(world.getHeight());
			column = r.nextInt(world.getWidth());
			position = new Position(line, column);
			
			if((line != 0 | column != 0) & world.isEmpty(position) )
				new FactoryCharacter().make( nameObject, world, position);
		}
		return world;
	}
}
