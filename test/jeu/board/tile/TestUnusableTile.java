/**
 *
 */
package jeu.board.tile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import jeu.player.*;
import jeu.board.*;
import jeu.player.Player;
import jeu.board.tile.resource.Resource;
import jeu.board.tile.resource.Rock;
import jeu.character.Army;
import jeu.character.Character;
import jeu.strategy.*;

/**
 * @author
 *
 */
public class TestUnusableTile {

	private Board board = new BoardWarGame(10, 10); // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private Tile ocean;
	Strategy strategy = new RandomStratWar(this.board); // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private Player player = new PlayerWar("aboubacar",strategy);
	private Character character;

	@Before
	public void before(){
		int[] position = strategy.PositionToDeploye();
		this.ocean = new Ocean();
		this.character =  new Army(3, this.player,position);  // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	}


	@Test
	public void TestTheDisponibilityOfTheTile() {
		assertFalse(this.ocean.isBusy());
		try {
			this.ocean.setCharacter(this.character);
			fail("Tile already used");
		} catch(Exception e) {
			assertTrue(e.getMessage().equals("Tile already used"));
		}
		assertFalse(this.ocean.isBusy());
	}
	
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.board.tile.TestUnusableTile.class);
	}

}
