package dungeonCrawler.GameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.EnumSet;

import dungeonCrawler.ElementType;
import dungeonCrawler.EventType;
import dungeonCrawler.GameElement;
import dungeonCrawler.GameEvent;
import dungeonCrawler.Vector2d;
import dungeonCrawler.App;

/**
 * @author Tissen
 *
 */
public class Exit extends GameElement {

	/**
	 * @param position
	 * @param size
	 */
	public Exit(Vector2d position, Vector2d size) {
		super(position, size, "EXIT", EnumSet.of(ElementType.IMMOVABLE, ElementType.WALKABLE));
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, size.getX(), size.getY());
	}

	@Override
	public void GameEventPerformed(GameEvent e) {
		if(e.element instanceof Player && e.type == EventType.COLLISION){
			e.gameLogic.app.currentLevel += 1;
			e.gameLogic.app.startGame();
			System.out.println("Ausgang");
		}
		// TODO Auto-generated method stub
		
	}

}
