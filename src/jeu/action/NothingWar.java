package jeu.action;

import java.util.*;
import jeu.board.tile.*;
import jeu.player.Player;
import jeu.character.Character;
/**
 * convert the ressources of the player
 * @see Action
 */
public class NothingWar implements Action{
	/**
	 * allow to perform the action.
	 * @param player to perform the action 
	 */
    public void realiser(Player player){
        System.out.println(player + "decides to do nothing!");
    }
}
