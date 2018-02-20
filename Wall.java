package jeuDeRole;


public class Wall extends Solid{

	public Wall(MyWorld world, Position pos) throws ExceptionPosition {
		super.world = world;
		super.pos = pos;
		super.world.registerTangibleAt(this, pos);
		
	}
	
	
	public char showAs() {
		return '#';
	}


	@Override
	public void interactWith(Player p) {
		WorldPrinter wp = p.myWorld.getWp();
		char c = wp.ask("Tu as:" + "\n" + p.getEquipment().showEquipment());
		if( c == 'c')
			try {
				world.unregisterTangibleAt(this.getPosition());
			} catch (ExceptionPosition e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if( ( c == 's' | c == 'd' | c == 'x' | c == 'e') )
			try {
				p.myWorld.moveClassic(p, c);
			} catch (ExceptionPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else wp.inform("tu ne peux pas faire cela");
	}
	
	
	


}
