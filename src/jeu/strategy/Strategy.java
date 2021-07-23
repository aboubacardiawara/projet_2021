package jeu.strategy;

import jeu.board.Board;

/**
 * Strategy
 */
public interface Strategy {


	public String chooseAction();

	public int[] PositionToDeploye();

    public int characterSize(int max);
}
