package jeu.action;

import jeu.player.Player;

/**
 *An interface for actions. The player can perform many action.
 */
public interface Action{

	/**
	 * allow to perform the action.
	 * @param player
	 */
    public void realiser(Player player);
}
