package jeuDeRole;

public interface Factory {
	public Character make( TypeObject o, MyWorld myWorld, Position position) throws ExceptionPosition;
}
