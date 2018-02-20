package jeuDeRole;

public class FactoryCharacter implements Factory{
	
	public Character make( TypeObject object, MyWorld myWorld, Position position) throws ExceptionPosition{
		Character c = null;
		switch(object){
		
		case police:	c = new Police(myWorld, position);
						break;
		case civil:		c = new Civil(myWorld, position);
						break;
		case soldier:	c = new Soldier(myWorld, position);
						break;
		}
		return c;
	}

}
