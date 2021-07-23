package jeu.action;

import jeu.player.Player;

/**
 * convert the ressources of the player
 * @see Action
 */
public class Convert implements Action{


	/**
	 * allow to perform the action.
	 * @param player
	 */
    public void realiser(Player player){
		player.convert();
        System.out.println(player + "converts his resources");
    }
}
