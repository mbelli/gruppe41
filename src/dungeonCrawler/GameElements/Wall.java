package dungeonCrawler.GameElements;

import java.awt.Graphics;
import java.util.EnumSet;

import dungeonCrawler.ElementType;
import dungeonCrawler.GameElement;
import dungeonCrawler.Vector2d;

/**
 * @author Mattes
 *
 */
public class Wall extends GameElement {

	/**
	 * @param position
	 * @param size
	 */
	public Wall(Vector2d position, Vector2d size) {
		super(position, size, "WALL", EnumSet.of(ElementType.IMMOVABLE));
	}

	/* (non-Javadoc)
	 * @see dungeonCrawler.Drawable#draw()
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

}
