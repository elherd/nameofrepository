package jeuDeRole;

public abstract class Character implements Tangible{
	protected String unite = "personnage";
	protected int precisionAttaque;
	protected int esquiveDefence;
	protected int life;
	
	protected EquipmentComposite equipment = new EquipmentComposite();
	protected MyWorld myWorld;
	protected Position position;
	
	
	//Accesseurs et Mutateurs
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public int getPrecisionAttaque() {
		return precisionAttaque;
	}
	public void setPrecisionAttaque(int precisionAttaque) {
		this.precisionAttaque = precisionAttaque;
	}
	public int getEsquiveDefence() {
		return esquiveDefence;
	}
	public void setEsquiveDefence(int esquiveDefence) {
		this.esquiveDefence = esquiveDefence;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setEquipment(EquipmentComposite equipment) {
		this.equipment = equipment;
	}
	public EquipmentComposite getEquipment() {
		return equipment;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getSizeEquipment(){
		return this.equipment.sizeEquipment();
	}
	public void setMyWorld(MyWorld myWorld) {
		this.myWorld = myWorld;
	}
	
	
	public int defence(){
		return esquiveDefence + equipment.getPowerDefence();
	}
	
	
	/*	methode attaque du joueur	*/
	public void attackPlayer(Character adversary, char c){
		
		int powerAttaque = this.precisionAttaque;
		Equipment weapon = null;
		
			/*	on switche toutes les armes du jeu	*/
		switch(c){
		case 'g':	weapon = new Gun();
					break;
		case 'r':	weapon = new Rocket();
					break;
		case 'l':	weapon = new Laser();
					break;
		case 'm':	weapon = new Laser();
					break;
		
		
		}
		
		powerAttaque += weapon.getPowerAttaque();
		if( powerAttaque > adversary.defence() )
			adversary.setLife( adversary.getLife() - weapon.getDamage() );
	}
	
	
	/*	methode attaque des enemis	*/
	public void attackEnemy(Character adversary){
		int powerAttaque = precisionAttaque;
		int lastElement = equipment.sizeEquipment()-1;
		powerAttaque += equipment.getElement(lastElement).getPowerAttaque();
		
		if( powerAttaque > adversary.defence() )
			adversary.setLife( adversary.getLife() - equipment.getElement(lastElement).getDamage() );
	}

	
	
	abstract protected void equip();
	abstract public void description();
	
	
	
}
