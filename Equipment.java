package jeuDeRole;

public interface Equipment extends Tangible {
	public String showEquipment();
	public int getPowerAttaque();
	public int getPowerDefence();
	public int getDamage();
	public void upgrade(Equipment e);
	//public void caracteristiqueWeapon();
	public String getName();
	public Position getPosition() ;
	default public void interactWith(Player p) {
		WorldPrinter wp = p.myWorld.getWp();
		char c = wp.ask("" + "\n" + p.getEquipment().showEquipment());
		if(c == 'r'){
					if( p.getEquipment().existInBag(this) )
						p.getEquipment().upgradeWeapon(this);
					else
						p.getEquipment().addEquipment(this);
					wp.inform("Vous avez pris ou amelioré cet equipement <"+getName()+">. Il vient d'etre ajouté dans votre sac");
			}
		if(( c == 's' || c == 'd' || c == 'x' || c == 'e')){				
			try {
				p.myWorld.moveClassic(p, c);
			} catch (ExceptionPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
