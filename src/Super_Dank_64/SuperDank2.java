/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Dank_64;

import static Super_Dank_64.Super_Dank_64_Ignacio.counter;
import static Super_Dank_64.Super_Dank_64_Ignacio.player;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author IgnacioS
 */
public class SuperDank2 extends BasicGameState {

    private static TiledMap grassMap;
    private static Camera camera;
    public ArrayList<Item> stuff = new ArrayList();
    public ArrayList<Item1> stuff1 = new ArrayList();
    public ArrayList<Itemwin> stuffwin = new ArrayList();
    public ArrayList<Enemy> enemiez = new ArrayList();
    private static final int SIZE = 64;
    public Orb magic8ball, orb1;

    SuperDank2(int xSize, int ySize) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getID() {
        return 4;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        gc.setTargetFrameRate(60);
        gc.setShowFPS(false);
        grassMap = new TiledMap("res/DANKgameIGNACIO.tmx");
        camera = new Camera(gc, grassMap);
        player = new Player();
        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int tileID = grassMap.getTileId(xAxis, yAxis, 0);
                String value = grassMap.getTileProperty(tileID, "blocked", "false");
                if ("true".equals(value)) {
                    Blocked.blocked[xAxis][yAxis] = true;
                }
            }
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        long delta = 0;
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
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            player.setDirection(2);
            player.sprite = player.down;
            if (!isBlocked(player.x, player.y + SIZE + fdelta)
                    || !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {
                player.sprite.update(delta);
                player.y += fdelta;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            player.setDirection(3);
            player.sprite = player.left;
            if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x - fdelta, player.y + SIZE - 1))) {
                player.sprite.update(delta);
                player.x -= fdelta;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.setDirection(1);
            player.sprite = player.right;

            if (cangoright && (!(isBlocked(player.x + SIZE + fdelta, player.y) || isBlocked(player.x + SIZE + fdelta, player.y + SIZE - 1)))) {
                player.sprite.update(delta);
                player.x += fdelta;
            }
        } else if (input.isKeyDown(Input.KEY_SPACE)) {

            orb1.settimeReal(1000);
            orb1.setX((int) player.x);
            orb1.setY((int) player.y);
            orb1.Hitbox.setX(orb1.getX());
            orb1.Hitbox.setY(orb1.getY());
            orb1.setIsVisible(!orb1.isIsVisible());

        }

        player.rect.setLocation(player.getplayershitboxX(), player.getplayershitboxY());
        for (Item ik : stuff) {
            if (player.rect.intersects(ik.hitbox)) {
                if (ik.isvisible) {
                    player.health += 10000;
                    ik.isvisible = false;
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

        for(Itemwin s : stuffwin) {
            if (player.rect.intersects(s.hitbox)) {
                if (s.isvisible) {
                    s.isvisible = false;
                    makevisible();
                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
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
                } else if (player.getDirection() == 2) {
                    orb1.setX((int) player.x);
                    orb1.setY(orb1.getY() + 5);
                } else if (player.getDirection() == 3) {
                    orb1.setX(orb1.getX() - 5);
                    orb1.setY(orb1.getY());
                } else if (player.getDirection() == 1) {
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
