package dungeonCrawler.GameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.EnumSet;

import dungeonCrawler.ElementType;
import dungeonCrawler.EventType;
import dungeonCrawler.GameElement;
import dungeonCrawler.GameEvent;
import dungeonCrawler.Vector2d;

/**
 * @author Dominik
 *
 */
public class Enemy extends GameElement {

	/**
	 * @param position
	 * @param size
	 */
	public Enemy(Vector2d position, Vector2d size) {
		super(position, size, "Enemy", EnumSet.of(ElementType.MOVABLE));
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillRect(0, 0, size.getX(), size.getY());
	}
	
	public void setPosition(Vector2d pos) {
		this.position = pos;
	}

	@Override
	public void GameEventPerformed(GameEvent e) {
		// TODO Auto-generated method stub
		if(e.element instanceof Player && e.type == EventType.COLLISION){
			System.out.println("autsch!");
			Player elementPlayer = (Player) e.element;
			elementPlayer.reduceHealth(10, e.gameLogic);
		}
		if(e.type == EventType.TIMER){
			e.gameLogic.moveElement(this, new Vector2d((int)(Math.random()*4-2),(int)(Math.random()*4-2)));
		}
	}

}
