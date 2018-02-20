package jeuDeRole;

import javax.swing.JOptionPane;

public class Application {
	
	public static void main(String[] args) throws ExceptionPosition {
	
	String namePlayer = null;
	int r;
	Player gamer = null;
	BuildLevel level = new BuildLevel();
	MyWorld world;
	WorldPrinter wp;
	Position pos0 = new Position( 1, 1);
	char c = ' ';
	do {
		namePlayer = JOptionPane.showInputDialog("Entrez votre nom avant de commencer","your name please");
	} while(namePlayer == null);
	
	
	
	do{
		
		world = MyWorld.chargeWorld("niveau1.txt");
		wp = new TextWorldPrinter(world);
		world.setWp(wp);
		gamer = new Player(world,pos0);
		
		gamer.setUnite(namePlayer);
		world = level.buildLevel(world, 8, TypeObject.police);
		world = level.buildLevel(world, 2, TypeObject.civil);
		Laser laser = new Laser();
		gamer.getEquipment().addEquipment(laser);
		
		System.out.println("\n\n\n********************Vous avez commencé la partie 2************************");
		
		world.play(gamer);
				
		/*	AJOUTER 5 POINTS LORS DU PASSAGE AU NIVEAU SUIVANT	ET GAIN D'UNE NOUVELLE AMRE*/
			
		gamer.setLife(gamer.getLife() + 5);
		System.out.println("Vous avez eu comme nouvelle arme <"+laser.getName()+"> et gagnez 5 points de vie");
		world = MyWorld.chargeWorld("niveau2.txt");
		wp = new TextWorldPrinter(world);
		world.setWp(wp);
		gamer.setPosition(pos0);
		world.registerTangibleAt(gamer, pos0);
		world = level.buildLevel(world, 7, TypeObject.soldier);

		world.play(gamer);
		
		//fini ici!
		if( (r=world.play(gamer)) == 1)
				JOptionPane.showMessageDialog(null, "you are win !!!  END OF GAME", "Message", JOptionPane.INFORMATION_MESSAGE);
			if ( r == 2)
				System.out.println("\n\nVous avez abandonn� le jeu , merci d'avoir jouer");
		
		
		if ( r == 2)
			System.out.println("\n\nVous avez abandonn� le jeu , merci d'avoir jouer");
		
		/*	DEMANDE AU JOUEUR S'IL VEUT QUITTER LE JEU OU RECOMMENCER	*/
		c = wp.ask("Tu veux quitter?");
	
		} while(c == 'o');
	wp.inform("Vous avez quitterle jeu");
	}


}
