package jeu.strategy;

import jeu.board.Board;
import jeu.player.Player;

/**
 * InteractiveStrat is an interactive strategy.
 * Its allow to a player to make choses by typing on the keyboard.
 */
public class InteractiveStrat implements Strategy{
	protected Board board;
    /**
     * constructor.
     * @param player a player using a Strategy.
     * @param board a game board.
     */
    public InteractiveStrat(Board board) {
       this.board = board;
    }

	public String chooseAction() {
		return null;
	}

    public int[] PositionToDeploye(){
	    return null;
	}

    public int characterSize(int max){
        return 0;
    }



}
