package Super_Dank_64;


import org.newdawn.slick.*;

import org.newdawn.slick.state.*;



public class Main extends StateBasedGame{

   

   public static final String gamename = "Dank game";

   public static final int play = 0;

   public static final int xSize = 1000;

   public static final int ySize = 750;

   

   public Main(String gamename){

      super(gamename);

      this.addState(new Menu(xSize, ySize));

      this.addState(new Super_Dank_64_Ignacio(xSize, ySize));
      
      this.addState(new SuperDank2(xSize, ySize));
      
      this.addState(new lose(xSize, ySize));
      
      this.addState(new win(xSize, ySize));

   }

   

   public void initStatesList(GameContainer gc) throws SlickException{

      this.getState(play).init(gc, this);

      this.enterState(play);

   }

   

   public static void main(String[] args) {

      AppGameContainer appgc;

      try{

         appgc = new AppGameContainer(new Main(gamename));

         appgc.setDisplayMode(xSize, ySize, false);
         
         int maxFPS = 60;
        
         appgc.setTargetFrameRate(maxFPS);

         appgc.setTargetFrameRate(60);

         appgc.start();

      }catch(SlickException e){

         e.printStackTrace();

      }

   }

}