/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Dank_64;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


class Player {
            //private int direction;
	public static float x = 230f;
        public static float y = 228f;
        public static int health = 100000;	
	public static float speed = .7f;
        static float hitboxX = x + 8f;
        static float hitboxY = y + 8f;
        private static int startX, startY, width = 30, height = 42;
	public static Shape rect = new Rectangle(getplayershitboxX(),
			getplayershitboxY(), width, height);
        private int direction;
	public static float pdelta;
        public static Animation playeranime,up,down,left,right,wait,sprite;     
        public Player() throws SlickException{SpriteSheet runningSS = new SpriteSheet(
                "res/DANKhero.png", 64, 64, 0);

            up = new Animation();
            up.setAutoUpdate(true);
            up.addFrame(runningSS.getSprite(0, 8), 330);
            up.addFrame(runningSS.getSprite(1, 8), 330);
            up.addFrame(runningSS.getSprite(2, 8), 330);
            up.addFrame(runningSS.getSprite(3, 8), 330);
            up.addFrame(runningSS.getSprite(4, 8), 330);
            up.addFrame(runningSS.getSprite(5, 8), 330);
            up.addFrame(runningSS.getSprite(6, 8), 330);
            up.addFrame(runningSS.getSprite(7, 8), 330);
            up.addFrame(runningSS.getSprite(8, 8), 330);
            down = new Animation();
            down.setAutoUpdate(false);
            down.addFrame(runningSS.getSprite(0, 10), 330);
            down.addFrame(runningSS.getSprite(1, 10), 330);
            down.addFrame(runningSS.getSprite(2, 10), 330);
            down.addFrame(runningSS.getSprite(3, 10), 330);
            down.addFrame(runningSS.getSprite(4, 10), 330);
            down.addFrame(runningSS.getSprite(5, 10), 330);
            down.addFrame(runningSS.getSprite(6, 10), 330);
            down.addFrame(runningSS.getSprite(7, 10), 330);
            down.addFrame(runningSS.getSprite(8, 10), 330);
            left = new Animation();
            left.setAutoUpdate(false);
            left.addFrame(runningSS.getSprite(0, 9), 330);
            left.addFrame(runningSS.getSprite(1, 9), 330);
            left.addFrame(runningSS.getSprite(2, 9), 330);
            left.addFrame(runningSS.getSprite(3, 9), 330);
            left.addFrame(runningSS.getSprite(4, 9), 330);
            left.addFrame(runningSS.getSprite(5, 9), 330);
            left.addFrame(runningSS.getSprite(6, 9), 330);
            left.addFrame(runningSS.getSprite(7, 9), 330);
            left.addFrame(runningSS.getSprite(8, 9), 330);
            right = new Animation();
            right.setAutoUpdate(false);
            right.addFrame(runningSS.getSprite(0, 11), 330);
            right.addFrame(runningSS.getSprite(1, 11), 330);
            right.addFrame(runningSS.getSprite(2, 11), 330);
            right.addFrame(runningSS.getSprite(3, 11), 330);
            right.addFrame(runningSS.getSprite(4, 11), 330);
            right.addFrame(runningSS.getSprite(5, 11), 330);
            right.addFrame(runningSS.getSprite(6, 11), 330);
            right.addFrame(runningSS.getSprite(7, 11), 330);
            right.addFrame(runningSS.getSprite(8, 11), 330);
            wait = new Animation();
            wait.setAutoUpdate(true);
            wait.addFrame(runningSS.getSprite(0, 14), 733);
            wait.addFrame(runningSS.getSprite(1, 14), 733);
            wait.addFrame(runningSS.getSprite(2, 14), 733);
            wait.addFrame(runningSS.getSprite(3, 14), 733);	
            sprite = wait;
}
        public static void setpdelta(float somenum) {
		pdelta = somenum;
}
	public static float getpdelta() {
		return pdelta;
}
	public static float getplayersX() {
		return x;

}
	public static float getplayersY() {
		return y;
}
	public static float getplayershitboxX() {
		return x + 18f;
}
	public static float getplayershitboxY() {
		return y + 18f;
}
	public static void setplayershitboxX() {
        	hitboxX = getplayershitboxX();
}
	public static void setplayershitboxY() {
		hitboxY = getplayershitboxY();
}
        public void setDirection(int i){
            this.direction = i;
}

        public int getDirection(){
            return this.direction;
}

}
//take static off