package jeu.action;

import java.util.*;
import jeu.board.tile.*;
import jeu.player.Player;
import jeu.character.Character;
/**
 * convert the ressources of the player
 * @see Action
 */
public class NothingFarm implements Action{
	/**
	 * allow to perform the action.
	 * @param player to perform the action 
	 */
    public void realiser(Player player){
		Tile tile;
		Iterator<Character> iter = player.deployedCharacter().iterator();
		while (iter.hasNext()){
			tile = iter.next().getTile();
            if (tile instanceof Woods | tile instanceof Plain) 
                player.addGold(1);
            else if (tile instanceof Desert)
                player.addGold(2);
        }
    }
}
