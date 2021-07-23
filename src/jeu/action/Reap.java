package jeu.action;

import java.util.Iterator;

import jeu.player.Player;
import jeu.board.tile.*;
import jeu.character.Character;
import jeu.board.tile.resource.*;
/**
 * allow to a player to harvest the resources of the tile occupied by his armies.
 */
public class Reap implements Action{
	/**
	 * allow to perform the action.
	 * @param player
	 */
    public void realiser(Player player){
		Tile tile;
        Resource resource;
		Iterator<Character> iter = player.deployedCharacter().iterator();
		while (iter.hasNext()){
			tile = iter.next().getTile();
            resource = tile.getResource();
            player.addResource(resource);
        }
        System.out.println(player + "has reaped resource from his tiles");
    }
}
