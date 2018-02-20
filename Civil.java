package jeuDeRole;

import java.util.Random;

public class Civil	extends Character  {
	/*	CONSTRUCTOR	*/
	public Civil(MyWorld myWorld, Position position) throws ExceptionPosition{
		this.equip();
		super.myWorld = myWorld;
		super.position = position;
		super.myWorld.registerTangibleAt(this, position);
	}
	
	
	/*	METHODES	*/	
	protected void equip(){
		// initialisation of variables of instance
		super.unite = "Civil";
		super.precisionAttaque = 5;
		super.esquiveDefence = 4;
		super.life = 20;
		
		Waistcoat waistcoat = new Waistcoat();	
		super.equipment.addEquipment(waistcoat);
	}
	
		
	
	public void description(){
		System.out.println("ce personnage a les caracteristiques suivantes \nnom: "+super.unite+"\nprecision d'attaque: "+super.precisionAttaque+"\nl'esquive de defence: "+super.esquiveDefence+"\nvie: "+super.life+ "\ncomme equipements: "+super.equipment.showEquipmentAll());
	}
	
	public char showAs() {
		// TODO Auto-generated method stub
		return 'c';
	}


	@Override
	public void interactWith(Player p) {
	    WorldPrinter wp = p.myWorld.getWp();
		char c = wp.ask("" + "\n" + p.getEquipment().showEquipment());
		if( c == 'a' ){
			if( getSizeEquipment() == 0)
				wp.inform("<Civil>: D�sol� je n'ai plus d'armes");
			else{
				wp.inform("<Civil>: Vous etes chanceux, c'est ma derniere arme");
			}
			Equipment tmpEquipment = getEquipment().getElement(0);
			if( p.getEquipment().existInBag(tmpEquipment) )
				p.getEquipment().upgradeWeapon(tmpEquipment);
			else
				p.getEquipment().addEquipment(tmpEquipment);
			getEquipment().removeEquipment(tmpEquipment);
			
		}
		
		if(( c == 's' || c == 'd' || c == 'x' || c == 'e')){
			if( (new Random().nextInt(1)) == 0 )
				attackEnemy(p);						
			try {
				p.myWorld.moveClassic(p, c);
			} catch (ExceptionPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// TODO Auto-generated method stub
	
	}
	
		
	
	
}
