package jeuDeRole;

public class FactorySolid implements Factory2 {

	public Solid make(TypeObject object, MyWorld myWorld, Position position) throws ExceptionPosition{
		Solid s = null;
		switch(object){
		case wall:		s = new Wall(myWorld, position);
						break;
		}
		return s;
	}
}
