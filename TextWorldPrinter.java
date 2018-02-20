package jeuDeRole;

import java.util.Scanner;

public class TextWorldPrinter extends WorldPrinter {
	
	private Scanner sc;
	
	public TextWorldPrinter(MyWorld myWorld){
		super(myWorld);
		sc = new Scanner (System.in);
	}
	
		
	public void inform (String message) {
		System.out.println(message);
	}
	public char ask(String message){
		    char c = 0;
		    
		    do {
  			     System.out.println(message);
			     System.out.println("Voulez vous:");
			     System.out.println("- aller vers (d = droite, s = gauche, e = haut, x = bas)");
		     	 System.out.println("- attaquer avec une des armes ");
		     	 System.out.println("- prendre ou ameliorer l'arme (r)");
		     	 System.out.println("- detruire le mur (c)");
		     	 System.out.println("- quitter (q)");
		    try{
				c = (sc.nextLine()).charAt(0);
			} catch(StringIndexOutOfBoundsException e){}
		} while( c!='c' && c!='d' && c!='e' && c!='s' && c!='x' && c!='q' &&  c!='g' && c!='r' && c!='m' && c!='l');
		    
		    return c;
	}

	// AFFICHE MYWORLD.
	public void print()throws ExceptionPosition{
		showLine();
		for(int i=0; i< myWorld.getWorld().length; i++){
			System.out.print('|');
			for(int j=0; j< myWorld.getWorld()[i].length; j++){
				Tangible tangible =  myWorld.getWorld()[i][j];
				System.out.print(tangible == null? ' ' : tangible.showAs());
			}
			System.out.println('|');
		}
		showLine();
	}
	
	//TABLEAU DE BORD
	public void tableauDeBord(Player player){
			showLine();
			System.out.println("Player Name : "+player.getUnite()+"\nLife : "+player.getLife());
			showLine();
	}
	
	// TRACER LA LIGNE DELIMITRICE.
	private	void showLine(){
					System.out.print('+');
					for(int i=0; i < this.myWorld.getWorld()[0].length; i++){
						System.out.print('-');
					}
					System.out.println('+');	
				}
}
