package jeuDeRole;

public class MachineGun implements Equipment {

	String name = "mitraillette";
	

	private MyWorld myWorld;
	private Position position;
	private int powerAttaque = 12;
	private int powerDefence = 0;
	private int damage = 5;
	
	public MachineGun(){
		
	}
	
	public MachineGun(MyWorld myWorld, Position position) throws ExceptionPosition {
		this.position = position;
		this.myWorld = myWorld;
		this.myWorld.registerTangibleAt(this, position);
		
		
	
	}

	//methodes
	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'm';
	}
	public String getName() {
		return name;
	}
	public void upgrade( Equipment e){
		this.powerAttaque = this.powerAttaque + e.getPowerAttaque();
		this.powerDefence = this.powerDefence + e.getPowerDefence();
		this.damage = this.damage + e.getDamage();
	}
	
	public Position getPosition() {
		return position;
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
	public String showEquipment() {
		// TODO Auto-generated method stub
		return "Machine-gun (m) ";
	}
	public String toString(){
		return ("name: "+this.showEquipment()+" powerAttaque: "+powerAttaque+" powerDefence: "+powerDefence+" effet: "+damage);
	}
	
	
}
