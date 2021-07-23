package jeu.board.tile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import jeu.player.Player;
import jeu.player.*;
import jeu.board.*;
import jeu.board.tile.resource.Resource;
import jeu.board.tile.resource.Rock;
import jeu.character.*;
import jeu.character.Character;
import jeu.exception.*;
import jeu.strategy.*;

public class TestUsableTile {
	private Board board; // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private int rewardCoefficient;
	private int relativeSizeBonus; // une armee sur une montagne voit sa taille augmentée de 2.
	private int bonusPoint;
	private int resourceValueInFood; // une roche se convertie en 0 unités de nourriture
	private int maxCharacter= 3;
	private Tile moutain;
	private Resource rock;
	Strategy strategy = new RandomStratWar(this.board);
	private Player player = new PlayerWar("aboubacar",strategy);  // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private Character character;


	@Before
	public void before(){
		this.board = new BoardWarGame(10, 10);
		this.rewardCoefficient = 1;
		this.relativeSizeBonus = 2; // une armee sur une montagne voit sa taille augmentée de 2.
		this.bonusPoint = 4;
		this.resourceValueInFood = 0; // une roche se convertie en 0 unités de nourriture
		this.moutain = new Mountain(rewardCoefficient, relativeSizeBonus, bonusPoint, resourceValueInFood,maxCharacter);
		this.rock = new Rock(resourceValueInFood);
		int[] position = this.strategy.PositionToDeploye();
		this.character =  new Army(3, this.player, position);
	}


	@Test
	public void TestTheDisponibilityOfTheTile() throws TileException {
		assertTrue(!this.moutain.isBusy());
		this.character.setSize(10);
		try {
			this.moutain.setCharacter(this.character);
			fail("Maximum size allowed exceded");
		} catch(Exception e) {
			assertTrue(e.getMessage().equals("Maximum size allowed exceded"));
		}
		this.character.setSize(3);
	}

	@Test
	public void testSetCharacter() {
		int[] position = this.strategy.PositionToDeploye();
		Character anotherCharacter = new Army(2, this.player,position);
		try {
			this.moutain.setCharacter(anotherCharacter);
		} catch(Exception e) {

		}
		assertEquals(anotherCharacter, this.moutain.getCharacter());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.board.tile.TestUsableTile.class);
	}


}
