package jeu.strategy;

import java.util.Iterator;
import java.util.List;

import jeu.board.Board;
import jeu.player.Player;
import jeu.util.Aleatoire;

/**
 * RandomStrat
 */
public class RandomStratFarm extends RandomStrat {

    /**
     * constructor.
     * @param player a player using a Strategy.
     * @param board a game board.
     */
    public RandomStratFarm(Board board) {
        super(board);
    }

    public String chooseAction() {
		String[] possiblesActions = {
            "deploye",
            "nothing",
            "convert"
        };
		int indice = Aleatoire.genererInt(0, possiblesActions.length-1);
        System.out.println(possiblesActions[indice]);
		return possiblesActions[indice];
    }


    public int[] PositionToDeploye(){
        List<int[]> positions = this.board.freePositions();
        int[] position;
        int indice = Aleatoire.genererInt(0, positions.size()-1);
        position = positions.get(indice);
        return position;
    }

    public int characterSize(int max){
        return 1;
    }
}
