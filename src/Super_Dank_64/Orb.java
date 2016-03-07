
package Super_Dank_64;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Orb {
    private int x,y,width,height;
    private int dmg,hitboxX,hitboxY,hitboxwidth,hitboxheight,timeReal;
    private boolean isVisible;
    Image orbpic; 
    Shape Hitbox;

public Orb (int a,int b) throws SlickException{
    this.x = a;
    this.y = b;
    this.isVisible = false;
    this.orbpic = new Image("res/orbs/Ninja_12.png");
    this.Hitbox = new Rectangle(a,b,32,32);
    this.isVisible = false;
}   
public void settimeReal(int t){
    this.timeReal= t;
}
public int gettimeReal(){
    return this.timeReal;
}
public void countdown(){
        this.timeReal--;
    }
/*
Getters and setters are a common concept in java
A design guideline in Java, and object oriented
programming in general,is to encapsulate/isolate
values as much as possible.
Getters - are methods used to query the value of
instance variables.
*/

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHitboxX() {
        return hitboxX;
    }

    public void setHitboxX(int hitboxX) {
        this.hitboxX = hitboxX;
    }

    public int getHitboxY() {
        return hitboxY;
    }

    public void setHitboxY(int hitboxY) {
        this.hitboxY = hitboxY;
    }

    public int getHitboxwidth() {
        return hitboxwidth;
    }

    public void setHitboxwidth(int hitboxwidth) {
        this.hitboxwidth = hitboxwidth;
    }

    public int getHitboxheight() {
        return hitboxheight;
    }

    public void setHitboxheight(int hitboxheight) {
        this.hitboxheight = hitboxheight;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Image getOrbpic() {
        return orbpic;
    }

    public void setOrbpic(Image orbpic) {
        this.orbpic = orbpic;
    }

    public Shape getHitbox() {
        return Hitbox;
    }

    public void setHitbox(Shape Hitbox) {
        this.Hitbox = Hitbox;
    }

  

}
