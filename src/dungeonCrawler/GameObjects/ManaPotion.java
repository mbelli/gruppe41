package dungeonCrawler.GameObjects;

import dungeonCrawler.GameElement;
import dungeonCrawler.GameObject;

/**
 * @author Tissen
 *
 */
public class ManaPotion extends GameObject {
	private int mana;

	public ManaPotion(int m) {
		this.mana = m;
	}
	
	@Override
	public void performOn(GameElement element) {
		// TODO Auto-generated method stub

	}

}
