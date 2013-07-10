package dungeonCrawler.GameObjects;

import dungeonCrawler.GameElement;
import dungeonCrawler.GameObject;
import dungeonCrawler.GameElements.Enemy;
import dungeonCrawler.GameElements.Player;

/**
 * @author Tissen
 *
 */
public class HealthPotion extends GameObject {
	private int health;

	public HealthPotion(int h) {
		this.health = h;
	}
	
	@Override
	public void performOn(GameElement element) {
		// TODO Auto-generated method stub
		String name = element.getName();
		switch (name) {
		case "PLAYER": ((Player)element).increaseHealth(health); break;
		case "ENEMY": ((Enemy)element).increaseHealth(health); break;
		}
	}

}
