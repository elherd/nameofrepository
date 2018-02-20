package jeuDeRole;

import java.util.Random;

public class Soldier extends Character {
	
	/*	CONSTRUCTOR	*/
	public Soldier(MyWorld myWorld, Position position) throws ExceptionPosition{
		this.equip();
		super.myWorld = myWorld;
		super.position = position;
		super.myWorld.registerTangibleAt(this, position);
	}
	
	
	/*	METHODES	*/	
	protected void equip(){
		// initialisation of variables of instance
		super.unite = "Militaire";
		super.precisionAttaque = 15;
		super.esquiveDefence = 7;
		super.life = 12;
		
		Waistcoat waistcoat = new Waistcoat();
		Rocket rocket = new Rocket();
		
		super.equipment.addEquipment(waistcoat);
		super.equipment.addEquipment(rocket);	
	}
	
		
	
	public void description(){
		System.out.println("ce personnage a les caracteristiques suivantes \nnom: "+super.unite+"\nprecision d'attaque: "+super.precisionAttaque+"\nl'esquive de defence: "+super.esquiveDefence+"\nvie: "+super.life+ "\ncomme equipements: "+super.equipment.showEquipmentAll());
	}
	
	
	public char showAs() {
		// TODO Auto-generated method stub
		return 's';
	}
	
	public Tangible getElement(Position pos){	return null;}


	@Override
	public void interactWith(Player p) {
		    WorldPrinter wp = p.myWorld.getWp();
			char c = wp.ask("" + "\n" + p.getEquipment().showEquipment());
			if(c == 'r' || c == 'g' || c == 'm' || c == 'l'){
				if( (new Random().nextInt(1)) == 0)
					attackEnemy(p);
				    p.attackPlayer(this, c);
				
				/*	VOIR SI L'ENNEMI ATTAQUE EST MORT	*/
				
				if(getLife() <= 0){
					c = wp.ask("\nvous l'avez tué pour prendre son arme d'attaque");
					if( c == 'p' ){
						Equipment tmpWeapon = equipment.getElement( equipment.sizeEquipment()-1 ) ;
						if( p.getEquipment().existInBag(tmpWeapon) )
							p.getEquipment().upgradeWeapon(tmpWeapon);
						else
							p.getEquipment().addEquipment(tmpWeapon);
						wp.inform("Vous avez pris son arme d'attaque <"+tmpWeapon.getName()+">. Elle vient d'etre ajouter dans votre sac");
					}
				}
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
