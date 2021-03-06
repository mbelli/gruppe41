package dungeonCrawler.GameElements;

import java.awt.Color;
import java.awt.Graphics;

import dungeonCrawler.GameElement;
import dungeonCrawler.GameEvent;
import dungeonCrawler.Vector2d;

public class StatusBar extends GameElement {
	private Player player;

	public StatusBar(Vector2d position, Vector2d size, GameElement player) {
		super(position, size);
		this.player = (Player) player;
	}

	@Override
	public void draw(Graphics g) {
		// health bar
		g.setColor(Color.RED);
		g.fillRect(30, 30, 200*player.getHealth()/player.maxHealth, 15);
		// armor bar
		g.setColor(Color.GREEN);
		g.fillRect(30, 30, 200*player.getShield()/player.maxShield, 15);
		// mana bar
		g.setColor(Color.BLUE);
		g.fillRect(270, 30, 200*player.getMana()/player.maxMana, 15);
		// bounds
		g.setColor(Color.BLACK);
		g.drawRect(30, 30, 200, 15);
		g.setColor(Color.BLACK);
		g.drawRect(270, 30, 200, 15);
		// bow
		/*if (player.hasBow()) {
			g.setColor(Color.BLACK);
			g.fillRect(245, 30, 10, 10);
		}*/
	}

	@Override
	public void GameEventPerformed(GameEvent e) {
	}

}
