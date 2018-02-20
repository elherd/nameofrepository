package jeuDeRole;

public class Rocket implements Equipment {
	
	private String name = "roquette";
	private MyWorld myWorld;
	private Position position;
	private int powerAttaque = 15;
	private int powerDefence = 0;
	private int damage = 8;
	

	public Rocket(){
		
	}
	
	public Rocket(MyWorld myWorld, Position position) throws ExceptionPosition {
		this.position = position;
		this.myWorld = myWorld;
		this.myWorld.registerTangibleAt(this, position);
	}
	
	
	
	//methodes
	
	
	public void upgrade( Equipment e){
		this.powerAttaque = this.powerAttaque + e.getPowerAttaque();
		this.powerDefence = this.powerDefence + e.getPowerDefence();
		this.damage = this.damage + e.getDamage();
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public int getDamage() {
		return damage;
	}
	
	public int getPowerAttaque() {
		return powerAttaque;
	}

	public int getPowerDefence() {
		return powerDefence;
	}
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public String showEquipment() {
		// TODO Auto-generated method stub
		return "rocket (r) ";
	}
	public void caracteristiqueWeapon(){
		System.out.println("name: "+this.showEquipment()+" powerAttaque: "+powerAttaque+" powerDefence: "+powerDefence+" effet: "+damage);
	}


	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'r';
	}


	
}
