package jeuDeRole;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.swing.JOptionPane;

class MyWorld{
	
	private Position position; // POSITION DE CHARACTER.
	private final int width; // LARGEUR (COLONNE).
	private final int height; // HAUTEUR(LIGNE).
	private final Tangible[][] world; // UN MONDE DE TANGIBLE.
	private WorldPrinter wp;
	
	//CONSTRUCTEUR DE MON MONDE
	
	public MyWorld( int height,int width) {
		this.width = width;
		this.height = height;
		world = new Tangible[this.height][this.width];
	}
	
	// RAMASSE MIETTES
	

	
	public void garbageCollector(){
		int i, j;
		for(i=0; i<this.height; i++){
			for(j=0; j<this.width; j++){
				if(this.world[i][j] instanceof Character){
					if( ((Character)this.world[i][j]).getLife()<=0)
						this.world[i][j] = null;
				}			
			}
		}		
	}
	
	// VOIR SI UNE CASE EST VIDE
	
	public boolean isEmpty( Position pos) throws ExceptionPosition{
		if(!isInWorld(pos))
			throw new ExceptionPosition();
		return ( ( this.world[pos.getLine()][pos.getColumn()] ) == null );
	}
	
	//	WORLD LIMITE
	
	public boolean isInWorld(Position position){
		return ( 0<=position.getLine() & this.height>position.getLine() & 0<=position.getColumn() & this.width>position.getColumn() );
	}
	
		/*	VOIR SI NOUS AVONS AU MOINS UN ENNEMI	*/
	
	public boolean noEnemyInWorld(){
			int i, j;
			for(i=0; i<this.height; i++){
				for(j=0; j<this.width; j++){
					if( (this.world[i][j] instanceof Police) | (this.world[i][j] instanceof Soldier)  )
						return false;	
				}
			}
			return true;
		 }
		
		// METTRE UN TANGIBLE DANS MON MONDE (CONNAISSANT LA POSITION).
	public void registerTangibleAt (Tangible tangible, Position pos) throws ExceptionPosition{
			//TODO
			if( this.isEmpty(pos) )
				world[pos.getLine()][pos.getColumn()] = tangible;
			}

		
		// ENLEVER UN TANGIBLE A UNE POSITION (CONNAISSANT LA POSITION).
		
	public void unregisterTangibleAt(Position pos) throws ExceptionPosition{
			//TODO
			if( !(this.isEmpty(pos)) )
				world[pos.getLine()][pos.getColumn()] = null ;
		}
	
		// CALCUL DE LA POSITION 
	    
	public Position shift(Position pos, Direction d){
			//TODO
			Position newPos = null;
			switch(d){
			case NORTH :	newPos = new Position(pos.getLine()-1, pos.getColumn());
							break;
			case SOUTH : 	newPos = new Position(pos.getLine()+1, pos.getColumn());
							break;
			case EAST : 	newPos = new Position(pos.getLine(), pos.getColumn()+1);
							break;
			case WEST : 	newPos = new Position(pos.getLine(), pos.getColumn()-1);
							break;
			};	
			return newPos;
		}
		/*	TRANSFORME UN ENTIER EN CARACTERE	*/
		
	public static char intToChar(int n){
			char c = 'v';
			switch(n){
			case 0:	c = 'd';
					break;
			case 1:	c = 's';
					break;
			case 2: c = 'e';
					break;
			case 3:	c = 'x';
					break;
			default : System.out.println("there is a probleme with intToChar(int n)"); 
			}
			return c;
		}
		
		//TRANSFORME UN TYPE CHAR EN TYPE DIRECTION	
		
	public static Direction charToDirection( char c){
			Direction d = null;
			switch(c){
			case 'd':	d = Direction.EAST;
						break;
			case 's':	d = Direction.WEST;
						break;
			case 'e':	d = Direction.NORTH;
						break;
			case 'x':	d = Direction.SOUTH;
						break;
			default : System.out.println("there is a probleme with charToDirection(char c)");
			}
			return d;
		}
		
		/*	DEPLACEMENT ENNEMI	*/
		
	public void moveEnemy() throws ExceptionPosition{
			int i, j;
			Random random = new Random();
			char tmp;
			
			for(i=0; i<this.height; i++){
				for(j=0; j<this.width; j++){
					if( (this.world[i][j] instanceof Police) | (this.world[i][j] instanceof Soldier) | (this.world[i][j] instanceof Civil) ){
						tmp = MyWorld.intToChar(random.nextInt(4));
						this.moveClassic( (Character)this.world[i][j], tmp );	
					}			
				}
			}			
		}
	public int getWidth() {
			return width;
		}

	public Tangible[][] getWorld() {
			return world;
		}

	public int getHeight() {
			return height;
		}

		//DEPLACEMENT CLASSIQUE
		public void moveClassic(Character gamer, char c ) throws ExceptionPosition{
			
			Position newPosition = this.shift(gamer.getPosition(), MyWorld.charToDirection(c));
			if( this.isInWorld(newPosition) ){
				if( this.isEmpty(newPosition) ){
					this.registerTangibleAt(gamer, newPosition);
					this.unregisterTangibleAt(gamer.getPosition());
					gamer.setPosition(newPosition);
				}
			}
		}
		
		//EXISTANCE D'OBJET OU D'ENNEMI A COTE 
		
		public Position isBeside(Character gamer) {
			int i = gamer.getPosition().getLine();
			int j = gamer.getPosition().getColumn();
			
			for (int h=-1;h<=1; h++)
				for (int k=-1; k<=1;k++)
					if (!(h==0 && k==0) && isInWorld(new Position(i+h, j+k)))
						if( (this.world[i+h][j+k]) instanceof Character || this.world[i+h][j+k] instanceof Equipment || this.world[i+h][j+k] instanceof Wall )
							return  new Position(i+h, j+k);
			return null;		
}
		
		//DEPLACEMENT DES AUTRES OBJETS
		
		Position moveTangibleAtIn (Position pos, Direction d) throws ExceptionPosition{
			Position newpos = shift(pos, d);
			registerTangibleAt(world[pos.getLine()][pos.getColumn()], newpos);
			unregisterTangibleAt(pos);
			return newpos;
		}
		
		// TRACER LES DELIMITEUR DE MON MONDE.
		
		void showLine(){
			System.out.print('+');
			for(int i=0; i < world[0].length; i++){
				System.out.print('-');
			}
			System.out.println('+');	
		}
		
	
	//ACCESSEUR 
	public Position getPosition(){
		return position;
	}
	
	//GET ELEMENT
	public Tangible getElement(Position position){
		return this.world[position.getLine()][position.getColumn()];
	}
		
	/*	TROUVER LE JOUEUR DANS LE MONDE		*/
	public	Player findPlayer() throws ExceptionPosition{
		int i, j;
		for( i=0; i<this.height; i++){
			for(j=0; j<this.width; j++){
				if(this.world[i][j] instanceof Player)
					return new Player( this, new Position(i, j));
			}
		}
		return null;
	}
	
	/*	CHARGE LE MONDE		*/
	
	public static MyWorld chargeWorld(String filename) throws ExceptionPosition {
		List<String> l = new ArrayList<String>();
		 
		Path source = Paths.get(filename);
		
		int i, j;
		try{
			l = Files.readAllLines(source, StandardCharsets.UTF_8 );
		}catch( IOException e){
			System.out.println("fail with readAllLines");
			System.out.println(e.getMessage());
		}
		
		MyWorld world = new MyWorld(l.size(), l.get(0).length() );
		for(i = 0; i<l.size(); i++){
			for(j = 0; j<l.get(0).length(); j++){
				
				switch(l.get(i).charAt(j)){
				case '#':	new FactorySolid().make(TypeObject.wall, world, new Position (i, j));
							break;
				case ' ':   world.registerTangibleAt(null, new Position (i, j));
							break;
				default:   world.registerTangibleAt(null, new Position (i, j));
							break;
				}
			}
		}
		
		return world;

	}
	
	
	/*	LANCEMENT DE LA PARTIE	*/
	public int play(Player gamer) throws ExceptionPosition{
				
		Position positionEnemy = null;
		Tangible t = null; 
		char c = ' ';
		do{
			wp.print();
			wp.tableauDeBord(gamer);
			
			if(gamer.getLife() <= 0  || noEnemyInWorld() )
				break;
			
			positionEnemy = this.isBeside(gamer);
			if(positionEnemy == null){
				c = wp.ask("rien à coté");
				if(c != 'q') moveClassic(gamer, c);				
			}else{
				/*	SI NOUS SOMMES A COTE DE D'UN Ennemi	*/
				getElement(positionEnemy).interactWith(gamer);
			
				// Le reste distribué sur les différente interactions.
			}			
			moveEnemy();
			garbageCollector();
			
		} while(c!='q');
		if(c == 'q'){
			return 2;
		}
		
		if( gamer.getLife() <= 0){
			JOptionPane.showMessageDialog(null, "GAME OVER, you are lost", "Message", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}else{
			System.out.println("\n\n\n\nFin de la partie!!");
			return 1;
		}
	}

	public WorldPrinter getWp() {
		return wp;
	}

	public void setWp(WorldPrinter wp) {
		this.wp = wp;
	}
   
}

