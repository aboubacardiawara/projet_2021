package jeu.action;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import jeu.player.*;
import jeu.character.*;
import jeu.character.Character;
import jeu.board.*;
import jeu.board.tile.*;
import jeu.util.Aleatoire;
import jeu.strategy.*;

/**
 * testConvert
 */
public class TestDeployeInArmyGame {
	private Board board; // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	private Player player;
	private Player player2;
	Strategy strategy ; // Il n'a pas d'importance ici, c'est juste des paramettre de nos classes ou methodes
	@Before
	public void before(){
		this.board = new BoardWarGame(10, 10);
		strategy = new RandomStratWar(this.board);
		this.player = new PlayerWar("timoleon", strategy);
		this.player2 = new PlayerWar("timoleon2", strategy);
	}

	@Test
	public void DeployeMustIncreaseThePlayerCharacterDeployed(){
		// precondition
		assertTrue(this.player.nummberOfCharacterDeployed() == 0);
		assertTrue(this.player2.nummberOfCharacterDeployed() == 0);
		int[] position = strategy.PositionToDeploye();
		Character army = new Army(2, player, position); 
		Tile tile;
		int x=0; /** <------------------- TO DO*/
		int y=0; /** <------------------- TO DO*/
		// choisir une tuile utilisable puis y placer le personnage.
		while (!(this.board.getTile(x, y) instanceof UsableTile)){
			x = Aleatoire.genererInt(0, 9);
			y = Aleatoire.genererInt(0, 9);
		}
		tile = this.board.getTile(y, x);
		// n'est t-il pas necessaire d'ajouter des attributs x et y aux tuiles ?
		this.player.deployeCharacter(army, tile);
		assertEquals(1, this.player.nummberOfCharacterDeployed());
	}

	@Test
	public void anArmyWthLowEffectifMustLoseTheHalfOfItsEffectif(){
		// precondition
		assertTrue(this.player.nummberOfCharacterDeployed() == 0);
		assertTrue(this.player2.nummberOfCharacterDeployed() == 0);
		int[] positionDeployement ; 
		positionDeployement = strategy.PositionToDeploye();
		Character army = new Army(4,player,positionDeployement); /** <------------------- TO DO*/
		positionDeployement = strategy.PositionToDeploye();
		Character army2 = new Army(2,player2,positionDeployement); /** <------------------- TO DO*/

		assertEquals(2, army2.getSize());
		assertEquals(4, army.getSize());

		Tile tile;
		int x=0; /** <------------------- TO DO*/
		int y=0; /** <------------------- TO DO*/
		// choisir une tuile utilisable puis y placer le personnage.
		while (!(this.board.getTile(x, y) instanceof UsableTile)){
			x = Aleatoire.genererInt(0, 9);
			y = Aleatoire.genererInt(0, 9);
		}
		tile = this.board.getTile(x, y);
		this.player.deployeCharacter(army, tile);

		// On cherche une tuile adjacente utilisable pour placer army2 (confrontation)
		int[][] positions = {{y, x-1}, {y+1, x}, {y, x+1}, {y-1, x}};
 		for(int position[]: positions) {
 			x = position[1];
			y = position[0];
			
			if (this.board.isValidPosition(y, x)){
				tile = this.board.getTile(y, x); //
				// on est sûr de trouver une tuile adjacente ('regles du plateau')
				if (tile instanceof UsableTile){
					break;
				}
			}
			 
		}

		// la tuile etant trouvee, y place le personnage et confronter les 2.
		// tile = this.board.getTile(x, y);
		this.player2.deployeCharacter(army2, tile);

		// army2 ayant une taille inferieure, elle a du perdre la moitiee de ses effectifs
		assertEquals(1, army2.getSize());
		assertEquals(4, army.getSize());
	}

}
