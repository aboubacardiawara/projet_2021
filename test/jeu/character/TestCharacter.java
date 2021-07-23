/**
 *
 */
package jeu.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import jeu.board.*;
import jeu.player.Player;
import jeu.player.*;
import jeu.board.tile.Tile;
import jeu.board.tile.Woods;
import jeu.character.Character;
import jeu.strategy.*;

public class TestCharacter {
	private Board board; // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	Strategy strategy ; // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private Player player;
	private Character character;
	private Tile tile;
	private int CharacSize;

	@Before
	public void before() {
		this.board = new BoardWarGame(10, 10);
		strategy = new RandomStratWar(this.board);
		this.tile = new Woods(1, 0, 0, 1,5);
		this.player = new PlayerWar("Steve",strategy);
		this.CharacSize = 3;

		int[] position = strategy.PositionToDeploye();
		this.character = new Army(this.CharacSize, player,position);
	}

	@Test
	public void testGetOwner() {
		assertSame(this.player, this.character.getOwner());
	}

	@Test
	public void testGetTile() {
		assertSame(this.tile, this.character.getTile());
	}

	@Test
	public void testCharacterSize() {
		assertEquals(this.CharacSize, this.character.getSize());
	}

	@Test
	public void setSizeMustChangeTheSizeOfTheCharacter() {
		// precondition: déjà fait, le test "testCharacterSize" fait bien cette étape.


		int newSize = 3;
		this.character.setSize(newSize);
		assertEquals(newSize, this.character.getSize());
	}

	@Test
	public void testChangeOwner() {
		
		// precondition: si le test "testGetOwner" passe, on est sûr qu'initialement Steve is the owner.
		Player anotherPlayer = new PlayerWar("Marc",this.strategy);
		this.character.changeOwner(anotherPlayer);
		assertSame(anotherPlayer, this.character.getOwner());
		assertNotSame(this.player, this.character.getOwner());

	}

	@Test
	public void testRewardQuantity() {
		assertTrue(this.character.getRewardValue() == 3);
	}

	@Test
	public void testQuitGame() {
		assertEquals(0, this.player.nummberOfCharacterDeployed()); // precondition

		this.player.deployeCharacter(this.character, this.tile);
		assertEquals(1, this.player.nummberOfCharacterDeployed());

		this.character.quitGame();
		assertEquals(0, this.player.nummberOfCharacterDeployed());
	}
}
