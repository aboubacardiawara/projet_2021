package jeu;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import jeu.board.tile.Desert;
import jeu.board.tile.Tile;
import jeu.character.Worker;
import jeu.player.*;
import java.util.ArrayList;
import jeu.strategy.*;
import jeu.board.*;
public class TestPlayer {
	private Player player;
	private Worker character;
	private Tile tile;
	private Board board;
	Strategy strategy ;

	@Before
	public void before() {
		strategy = new RandomStratWar(board);
		this.player = new PlayerWar("Diawara",strategy);
		this.tile = new Desert(1, 0, 2, 0, 3);
	}

	@Test
	public void testAddGold() {
		assertEquals(this.player.getGolds(), 0);
		this.player.addGold(50);
		assertEquals(this.player.getGolds(), 50);
	}

    @Test
    public void testGetName() {
		assertEquals(player.getName(), "Diawara");
    }

    @Test
	public void testDeploy() {
    	// precondition
		assertEquals(this.player.nummberOfCharacterDeployed(), 0);

		this.player.deployeCharacter(new Worker(this.player, null), this.tile);
		assertEquals(this.player.nummberOfCharacterDeployed(), 1);
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.TestPlayer.class);
	}

}
