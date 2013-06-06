package dungeonCrawler.GameElements;

import java.awt.Graphics;
import java.util.EnumSet;

import dungeonCrawler.ElementType;
import dungeonCrawler.GameElement;
import dungeonCrawler.Vector2d;

/**
 * @author Tissen
 *
 */
public class Trap extends GameElement {

	/**
	 * @param position
	 * @param size
	 */
	public Trap(Vector2d position, Vector2d size) {
		super(position, size, "TRAP", EnumSet.of(ElementType.IMMOVABLE));
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

}
