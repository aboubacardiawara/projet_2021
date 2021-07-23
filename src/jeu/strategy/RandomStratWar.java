package jeu.strategy;

import java.util.Iterator;
import java.util.List;

import jeu.board.Board;
import jeu.player.Player;
import jeu.util.Aleatoire;

/**
 * RandomStrat
 */
public class RandomStratWar extends RandomStrat {

    /**
     * constructor.
     * @param player a player using a Strategy.
     * @param board a game board.
     */
    public RandomStratWar(Board board) {
        super(board);
    }

    public String chooseAction() {
		String[] possiblesActions = {
            "deploye",
            "nothing",
        };
		int indice = Aleatoire.genererInt(0, possiblesActions.length-1);
        System.out.println(possiblesActions[indice]);
		return possiblesActions[indice];
    }


    public int characterSize(int max) {
        int alea = Aleatoire.genererInt(1, max);
        return alea;
    }


}
