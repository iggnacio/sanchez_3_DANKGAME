package Super_Dank_64;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;








public class Super_Dank_64_Ignacio extends BasicGameState {
   
    public static Player player;
    public Item healthpotion, healthpotion1;
    public Item1 speedpotion, speedpotion1;
    public Itemwin antidote;
    public Orb magic8ball, orb1;
    public Enemy jackson;
    public ArrayList<Item> stuff = new ArrayList();
    public ArrayList<Item1> stuff1 = new ArrayList();
    public ArrayList<Itemwin> stuffwin = new ArrayList();
    public ArrayList<Enemy> enemiez = new ArrayList();
    private boolean[][] hostiles;
    private static TiledMap grassMap;
    private static AppGameContainer app;
    private static Camera camera;
    public static int counter = 0;
    private static final int SIZE = 64;
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 750;
    public Super_Dank_64_Ignacio(int xSize, int ySize) {
}


private StateBasedGame game;
public Image startimage;




    public void init(GameContainer gc, StateBasedGame sbg)
        throws SlickException {
           
            gc.setTargetFrameRate(60);
            gc.setShowFPS(false);
            grassMap = new TiledMap("res/mem.tmx");
                camera = new Camera(gc, grassMap);
                player = new Player();
                Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
        for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {            
             int tileID = grassMap.getTileId(xAxis, yAxis, 0);
                String value = grassMap.getTileProperty(tileID,"blocked", "false");
                if ("true".equals(value)) {
                    Blocked.blocked[xAxis][yAxis] = true;
}
}
}     
    hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
        for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
             int xBlock = (int) xAxis;
             int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                if (yBlock % 7 == 0 && xBlock % 15 == 0) {
                    Item i = new Item(xAxis * SIZE, yAxis * SIZE);
                    stuff.add(i);
                      
    hostiles[xAxis][yAxis] = true;
}
}
}
}

    for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
    for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
         int xBlock = (int) xAxis;
         int yBlock = (int) yAxis;
            if (!Blocked.blocked[xBlock][yBlock]) {
            if (xBlock % 9 == 0 && yBlock % 25 == 0) { Item1 h = new Item1(xAxis * SIZE, yAxis * SIZE);                  
                stuff1.add(h);
                hostiles[xAxis][yAxis] = true;
}
}
}
}

    for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
    for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
         int xBlock = (int) xAxis;
         int yBlock = (int) yAxis;
            if (!Blocked.blocked[xBlock][yBlock]) {
            if (yBlock % 7 == 0 && xBlock % 15 == 0) {
                Enemy e = new Enemy(xAxis * SIZE, yAxis * SIZE);
                    enemiez.add(e);                       
                    hostiles[xAxis][yAxis] = true;
}
}
}
}

    healthpotion = new Item(100, 100);
    healthpotion1 = new Item(450, 400);
    stuff.add(healthpotion);
    jackson = new Enemy((int) player.x + 142, (int) player.y + 142);
    orb1 = new Orb((int) player.x, (int) player.y);       
    speedpotion = new Item1(100, 150);
    speedpotion1 = new Item1(450, 100);
    stuff1.add(speedpotion);
    stuff1.add(speedpotion1);
    antidote = new Itemwin(3004, 92);
    stuffwin.add(antidote);
}

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
              
 camera.centerOn((int) player.x, (int) player.y);
                camera.drawMap();
                camera.translateGraphics();        
                player.sprite.draw((int) player.x, (int) player.y);      
                    g.drawString("Health: " + player.health / 1000, camera.cameraX + 10,camera.cameraY + 10);
                    g.drawString("speed: " + (int) (player.speed * 10), camera.cameraX + 10, camera.cameraY + 25);
                    //g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);        
                        for (Item i : stuff) {
                            if (i.isvisible) {
                                i.currentImage.draw(i.x, i.y);
}
}

    for (Item1 h : stuff1) {
        if (h.isvisible) {
            h.currentImage.draw(h.x, h.y);             
}
}

    for (Itemwin w : stuffwin) {
        if (w.isvisible) {
            w.currentImage.draw(w.x, w.y);             
}
}

    if (orb1.isIsVisible()) {
        orb1.orbpic.draw(orb1.getX(), orb1.getY());
}

    for (Enemy e : enemiez) {
        if (e.isvisible) {
            e.currentanime.draw(e.Bx, e.By);
}
}
}

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
                counter += delta;
                Input input = gc.getInput();
                float fdelta = delta * player.speed;
                player.setpdelta(fdelta);
                double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);      
                    float projectedright = player.x + fdelta + SIZE;
                    boolean cangoright = projectedright < rightlimit;       
                        
                    if (input.isKeyDown(Input.KEY_UP)) {
                            player.setDirection(0);
                            player.sprite = player.up;
                            float fdsc = (float) (fdelta - (SIZE * .15));
                            
                            if (!(isBlocked(player.x, player.y - fdelta) || isBlocked(
                                (float) (player.x + SIZE + 1.5), player.y - fdelta))) {
                                player.sprite.update(delta);
                                player.y -= fdelta;
}
} 
    else if (input.isKeyDown(Input.KEY_DOWN)) {
        player.setDirection(2);
        player.sprite = player.down;
            if (!isBlocked(player.x, player.y + SIZE + fdelta)
            || !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {
                player.sprite.update(delta);
                player.y += fdelta;
}
} 
    else if (input.isKeyDown(Input.KEY_LEFT)) {
        player.setDirection(3);
        player.sprite = player.left;
            if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x- fdelta, player.y + SIZE - 1))) {
                player.sprite.update(delta);
                player.x -= fdelta;
}
} 
    else if (input.isKeyDown(Input.KEY_RIGHT)) {
        player.setDirection(1);
        player.sprite = player.right;           
            
    if (cangoright&& (!(isBlocked(player.x + SIZE + fdelta, player.y) || isBlocked(player.x + SIZE + fdelta, player.y+ SIZE - 1)))) {
        player.sprite.update(delta);
        player.x += fdelta;
} 
} 
    else if (input.isKeyDown(Input.KEY_SPACE)) {
            
            orb1.settimeReal(1000);
            orb1.setX((int) player.x);
            orb1.setY((int) player.y);
            orb1.Hitbox.setX(orb1.getX());
            orb1.Hitbox.setY(orb1.getY());
            orb1.setIsVisible(!orb1.isIsVisible());
            
}

    player.rect.setLocation(player.getplayershitboxX(),player.getplayershitboxY());              
        for (Item i : stuff) {
            if (player.rect.intersects(i.hitbox)) {            
            if (i.isvisible) {
                player.health += 10000;
                i.isvisible = false;
}
}
}
    for (Item1 h : stuff1) {
        if (player.rect.intersects(h.hitbox)) {    
        if (h.isvisible) {
            player.speed += .1f;
            h.isvisible = false;
}
}
}

    for (Itemwin w : stuffwin) {
        if (player.rect.intersects(w.hitbox)) {          
        if (w.isvisible) {
            w.isvisible = false;
            makevisible();
            sbg.enterState(4, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
}
}
}

    for (Enemy e : enemiez) {
        if (orb1.Hitbox.intersects(e.rect)) {
            e.isvisible = false;
}
}

    if (orb1.isIsVisible()) {
    
    if (orb1.gettimeReal() > 0) {
    
    if (player.getDirection() == 0) {
        orb1.setX((int) player.x);
        orb1.setY(orb1.getY() - 5);
} 
    else if (player.getDirection() == 2) {
        orb1.setX((int) player.x);
        orb1.setY(orb1.getY() + 5);
} 
    else if (player.getDirection() == 3) {
        orb1.setX(orb1.getX() - 5);
        orb1.setY(orb1.getY());
} 
    else if (player.getDirection() == 1) {
        orb1.setX(orb1.getX() + 5);
        orb1.setY(orb1.getY());
}

    orb1.Hitbox.setX(orb1.getX());
    orb1.Hitbox.setY(orb1.getY());
    orb1.countdown();
} else {
    orb1.setIsVisible(false);
}
}

    player.health -= counter / 1000;
        if (player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
}
}

    public int getID() {
        return 1;

}

    public void makevisible() {
        for (Item1 h : stuff1) {
            h.isvisible = true;
}
    for (Item i : stuff) {
         i.isvisible = true;
}
}

    private boolean isBlocked(float tx, float ty) {
        int xBlock = (int) tx / SIZE;
        int yBlock = (int) ty / SIZE;
            return Blocked.blocked[xBlock][yBlock];    
}
}


