package jeuDeRole;

public abstract class Solid implements Tangible{
	protected MyWorld world;
	protected Position pos;
	public Position getPosition(){
		return pos;
	}
}
