package jeuDeRole;

public class Gun implements Equipment {
	
	String name = "pistolet";
	
	private MyWorld myWorld;
	private Position position;

	private int powerAttaque = 6;
	private int powerDefence = 0;
	private int damage = 2;
	
	public Gun(){
		
	}
	
	public Gun(MyWorld myWorld, Position position) throws ExceptionPosition {
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
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}
	@Override
	public int getPowerAttaque() {
		// TODO Auto-generated method stub
		return powerAttaque;
	}
	@Override
	public int getPowerDefence() {
		// TODO Auto-generated method stub
		return powerDefence;
	}
	@Override
	public Position getPosition() {
		return position;
	}
	@Override
	public String showEquipment() {
		// TODO Auto-generated method stub
		return "gun (g) ";
	}
	public void caracteristiqueWeapon(){
		System.out.println("name: "+this.showEquipment()+" powerAttaque: "+powerAttaque+" powerDefence: "+powerDefence+" effet: "+damage);
	}

	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'g';
	}

	
	
}


	
	

