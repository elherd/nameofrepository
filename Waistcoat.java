package jeuDeRole;

public class Waistcoat implements Equipment {
	

	private String name = "gilet";
	private MyWorld myWorld;
	private Position position;
	private int powerAttaque = 0;
	private int powerDefence = 8;
	private int damage = 0;
	

	public Waistcoat(){
		
	}
	
	public Waistcoat(MyWorld myWorld, Position position) throws ExceptionPosition {
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
	public int getPowerAttaque() {
		return powerAttaque;
	}

	public int getPowerDefence() {
		return powerDefence;
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public String showEquipment() {
		// TODO Auto-generated method stub
		return "waistcoat (w)";
	}
	
	public void caracteristiqueWeapon(){
		System.out.println("name: "+this.showEquipment()+" powerAttaque: "+powerAttaque+" powerDefence: "+powerDefence+" effet: "+damage);
	}

	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'w';
	}
	@Override
	public Position getPosition() {
		return position;
	}

};


