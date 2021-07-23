package jeu.action;

import jeu.board.Board;
import jeu.board.tile.Tile;
import jeu.board.tile.UsableTile;
import jeu.character.Army;
import jeu.character.Character;
import jeu.player.Player;

import jeu.strategy.*;
import java.util.Scanner;

/**
 * allow to a player to deploy an army on the board.
 */
public class DeployeArmy implements Action {
    private Board board;

    /**
     * @constructor
     * @param board
     */
    public DeployeArmy(Board board){
        this.board = board;
    }

    final String RED_BOLD = "\033[1;31m";
    final String ANSI_CYAN = "\u001B[36m";
    final String GREEN_BOLD = "\033[1;32m";
    final String ANSI_RESET = "\u001B[0m";




    /**
    * allow to perform the action.
     * @param player a player to deploy army
     */
    public void realiser(Player player) {
        int x, y;
        boolean canSupportSize;
        Tile tile;
        boolean deployed;
        Character other_army, character;
        int other_army_size, other_army_RelatSize, armyRelativeSize;
        int armySize ;
        Strategy strategy = player.getStrategy();
        int[] position;
		int maxSizePossible;

		// ----------------

		if (player.canDeploye()) {
			position = strategy.PositionToDeploye();
	        x = position[0];
	        y = position[1];
	        tile = this.board.getTile(y, x);
			maxSizePossible = Math.min(35-player.sizeCharacterDeployed(), tile.getMaxCharacterAllowed());
			armySize = strategy.characterSize(maxSizePossible);
			character = new Army(armySize, player,position);
			canSupportSize = tile.canSupportSize(character);
			while (! canSupportSize) {
				System.out.println("the max size allowed by the tile is: " + tile.getMaxCharacterAllowed());
				position = strategy.PositionToDeploye();
		        x = position[0];
		        y = position[1];
			}
			player.deployeCharacter(character, tile);
	        System.out.println(player + " deployed " + character + " on " + " tile at position (" + x + "," + y + ")");


			// GESTION DES CONFRONTATIONS
	        //
	        armyRelativeSize = character.getRelativeSize();
	        // get the adjacente tile
	        for (Tile t: board.adjacenteTileOf(y, x)) {
				// y'a t'il une armee ?
	            if (t.isBusy()) {
	                other_army = t.getCharacter();
	                other_army_size = other_army.getSize();
	                other_army_RelatSize = other_army.getRelativeSize();
	                // check the owner, if it is the enemy army or not
	                if ( !(other_army.getOwner().equals(player)) ){
	                    // the enemy army has a low effectif.
	                    if (other_army_RelatSize < armyRelativeSize){
	                        if (other_army_RelatSize == 1){
	                            other_army.changeOwner(player);
	                            System.out.println(player + " wines one of his oponent's character");
	                        }
	                        else{
	                            other_army.setSize( (int) other_army_size/2 );
	                            System.out.println("Opposing army of "+player + " has seen its size halved");
	                        }
	                    }
	                }
	                else{
	                    if (other_army_RelatSize < armyRelativeSize){
	                      System.out.println("Opposing army of "+player + " has seen its size increased by 1");
	                        other_army.setSize( other_army_size+1 );
	                        character.addGold(1);
	                    }
	                }
	            }

	        }
	        // FIN BLOC GESTION DES CONFRONTATIONS
		}
		else {
			System.out.println(player + " cannot deploye, no such warrior left");
		}

		// ----------------




    }
}
