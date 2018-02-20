package jeuDeRole;

import java.util.ArrayList;
import java.util.List;

public class EquipmentComposite implements Equipment {
	
	private Position position;
	private String name = "bag";
	
	public List<Equipment> equipements = new ArrayList<Equipment>();
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getPowerDefence() {
		// TODO Auto-generated method stub
		int power = equipements.stream()
				               .mapToInt(Equipment::getPowerDefence)
                               .sum();
		return power;
	}
	public boolean existInBag(Equipment e){
		//Equipment tmp = null;
		for(int i = 0; i < this.equipements.size(); i++){
			if( this.equipements.get(i).getClass() == e.getClass() )
				return true;
		}
		return false;
	}
	
	public void upgradeWeapon(Equipment e){
		for(int i = 0; i < this.equipements.size(); i++){
			if( this.equipements.get(i).getClass() == e.getClass() ){
				this.equipements.get(i).upgrade(e);
				break;
			}
		}
		
	}
	@Override
	public String showEquipment(){
		String listArme = "";
		for(Equipment e : equipements){
			if( (e instanceof Gun) | (e instanceof Rocket) | (e instanceof Laser) | (e instanceof MachineGun) )
				listArme += e.showEquipment();
		}
		return listArme;
	}
	
	public String showEquipmentAll(){
		String listArme = "";
		for(Equipment e : equipements){
				listArme += e.showEquipment();
		}
		return listArme;
	}
	public void addEquipment(Equipment equipment){
		equipements.add(equipment);
	}
	public void removeEquipment(Equipment equipment){
		equipements.remove(equipment);
	}
	public Equipment getElement(int i){
		return equipements.get(i);
	}
	public int sizeEquipment(){
		return equipements.size();
	}
	@Override
	public char showAs() {
		// TODO Auto-generated method stub
		return 'b';
	}
	
	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public int getPowerAttaque() {	return 0;}
	@Override
	public int getDamage() {	return 0; }
	public void upgrade(Equipment e){}
	public void caracteristiqueWeapon(){}
	
	
	
}
