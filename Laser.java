package jeuDeRole;

public class Laser implements Equipment {
	
	private String name = "laser";
	private MyWorld myWorld;
	private Position position;
	private int powerAttaque = 20;
	private int powerDefence = 0;
	private int damage = 8;
	
	public Laser(){
		
	}
	
	public Laser(MyWorld myWorld, Position position) throws ExceptionPosition {
		this.position = position;
		this.myWorld = myWorld;
		this.myWorld.registerTangibleAt(this, position);
	}
	
	
	
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
	public Position getPosition() {
		return position;
	}
	@Override
	public int getDamage() {
		return damage;
	}
	@Override
	public int getPowerAttaque() {
		return powerAttaque;
	}
	@Override
	public int getPowerDefence() {
		return powerDefence;
	}
	@Override
	public String showEquipment() {
		// TODO Auto-generated method stub
		return "Laser (l) ";
	}
	public void caracteristiqueWeapon(){
		System.out.println("name: "+this.showEquipment()+" powerAttaque: "+powerAttaque+" powerDefence: "+powerDefence+" effet: "+damage);
	}

	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'l';
	}

	

	

}
