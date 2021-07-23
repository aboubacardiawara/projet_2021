package jeu.strategy;

import java.util.Iterator;
import java.util.List;

import jeu.board.Board;
import jeu.player.Player;
import jeu.util.Aleatoire;
/**
 * Random
 */
public abstract class RandomStrat implements Strategy {

	protected Board board;

	/**
     * constructor.
     * @param player a player using a Strategy.
     * @param board a game board.
     */
    public RandomStrat(Board board) {
        this.board = board;
    }


    public abstract String chooseAction();

	public abstract int characterSize(int max);

    public int[] PositionToDeploye(){
        List<int[]> positions = this.board.freePositions();
        int[] position;
        int indice = Aleatoire.genererInt(0, positions.size()-1);
        position = positions.get(indice);
        return position;
    }

}
