package jeu.board.tile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import jeu.board.*;
import jeu.player.*;
import jeu.player.Player;
import jeu.board.tile.resource.*;
import jeu.character.*;
import jeu.character.Character;
import jeu.exception.*;
import jeu.strategy.*;

public class TestTile {
	
	private int rewardCoefficient;
	private int relativeSizeBonus; // une armee sur une montagne voit sa taille augmentée de 2.
	private int bonusPoint;
	private int maxCharacter = 3;
	private Board board = new BoardWarGame(10, 10);
	private int resourceValueInFood; // une roche se convertie en 0 unités de nourriture
	private Tile moutain;
	private Resource rock;
	Strategy strategy = new RandomStratWar(this.board);
	private Player player = new PlayerWar("aboubacar",strategy);
	private Character character;
	

	@Before
	public void before() throws TileException{
		this.rewardCoefficient = 1;
		this.relativeSizeBonus = 2; // une armee sur une montagne voit sa taille augmentée de 2.
		this.bonusPoint = 4;
		this.resourceValueInFood = 0; // une roche se convertie en 0 unités de nourriture
		this.moutain = new Mountain(rewardCoefficient, relativeSizeBonus, bonusPoint, resourceValueInFood,maxCharacter);
		this.rock = new Rock(resourceValueInFood);
		int[] position = strategy.PositionToDeploye();
		this.character =  new Army(10, this.player,position);
		try {
			this.moutain.setCharacter(this.character);
			fail("Maximum size allowed exceded");
		} catch(Exception e) {
			assertTrue(e.getMessage().equals("Maximum size allowed exceded"));
		}
	}

	@Test
	public void precondition() {
		assertTrue(this.rewardCoefficient == 1);
		assertTrue(this.relativeSizeBonus == 2);
		assertTrue(this.bonusPoint == 4);
		assertTrue(this.resourceValueInFood == 0);
	}

	@Test
	public void testGetRessource() {
		assertEquals(this.rock, this.moutain.getResource());
	}

	@Test
	public void TestMaximumCharacterAllowedOnTheTile() {
		assertEquals(3, this.moutain.getMaxCharacterAllowed());
	}
	
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.board.tile.TestTile.class);
	}

}
