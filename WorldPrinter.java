package jeuDeRole;

public abstract class WorldPrinter {
	  protected MyWorld myWorld;
      public abstract void print() throws ExceptionPosition;
      public abstract void tableauDeBord(Player player);
      public abstract char ask(String message);
      public abstract void inform (String message);
      
      
      public WorldPrinter (MyWorld myWorld) {
    	  this.myWorld=myWorld;
      }
}
