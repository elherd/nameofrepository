package jeuDeRole;

public class Player extends Character {
		
	//constructor
	public Player(MyWorld myWorld, Position position) throws ExceptionPosition{
		
		this.equip();
		super.myWorld = myWorld;
		super.position = position;
		super.myWorld.registerTangibleAt(this, position);
		
	}
	
	/*	METHODES	*/	
	protected void equip(){
		// initialisation of variables of instance
		super.unite = "Joueur";
		super.precisionAttaque = 10;
		super.esquiveDefence = 3;
		super.life = 100;
		
		Waistcoat waistcoat = new Waistcoat();
		Gun gun = new Gun();
		MachineGun machineGun = new MachineGun();
		
		super.equipment.addEquipment(waistcoat);
		super.equipment.addEquipment(gun);
		super.equipment.addEquipment(machineGun);

	}
	
	public void setPosition(Position p){
		super.position = p;
	}
	
	
	public void description(){
		System.out.println("ce personnage a les caracteristiques suivantes \nnom: "+super.unite+"\nprecision d'attaque: "+super.precisionAttaque+"\nl'esquive de defence: "+super.esquiveDefence+"\nvie: "+super.life+"\ncomme equipements: "+super.equipment.showEquipmentAll());
	}

	
	public char showAs() {
		return 'j';
	}

	@Override
	public void interactWith(Player p) {
		// TODO Auto-generated method stub
		
	}

	
	

}
