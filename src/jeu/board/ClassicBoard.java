/**
 *
 */
package jeu.board;

import jeu.board.tile.*;
import java.util.*;
import jeu.util.Aleatoire;

/**
 * the board for the war game
 * @author
 *
 */
public abstract class ClassicBoard extends Board {

	protected ArrayList<ArrayList<Integer>> tilesfree;

	/**
	 * constructeur du plateau.
	 * @param lenght
	 * @param width
	 */
	public ClassicBoard(int lenght, int width) {
		super(lenght, width);
	}

    public abstract void setUsableTile(int numberOfUsableTileToSet);

	/**
	 * Allow to create a board with a giving rules
	 */
	public void initBoard(){
		int numberOfUsableTileToSet = (int) (this.width * this.lenght / 3);
        setUsableTile(numberOfUsableTileToSet);
        setOCeanTile();
        correctBoard();
    }

    private void cleanBoard(){
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.lenght; j++) {
                this.tiles[j][i] = null;

            }
        }
    }

    private void setOCeanTile() {
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.lenght; j++) {
                if (!(this.tiles[j][i] instanceof Tile)) {
                    this.tiles[j][i] = new Ocean();
                }
            }
        }
    }

    private void correctBoard() {
        for (int i=0; i<this.lenght; i++) {
            for (int j=0; j<this.width; j++) {
                if (!hasMoreThanZeroAdjacentUsableTile(i, j)){
                    this.tiles[i][j] = new Ocean();
                }

            }
        }
    }

    /**
     * <b>check the two bellow Conditions:</b>
     * <p>
     * <ol>
     *	<li>every usable tile has at less 1 adjacent usable tile</li>
     *	<li>The number of tile ocean is 2/3 of the total number of tiles</li>
     *	</ol>
     *	</p>
     * @return
     *	- true if these above conditions are met. <br>
     *	- false otherwise.
     */
    public boolean isValidBoard(){
        int nbOfOcenTile = 0;
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.lenght; j++) {
                if (!hasMoreThanZeroAdjacentUsableTile(j, i)){
                    return false;
                }
                if (this.tiles[j][i] instanceof Ocean){
                    nbOfOcenTile++;
                }
            }
        }

        if (nbOfOcenTile * 3 < 2 * this.width * this.lenght )
            return false;
        return true;

    }

    public ArrayList<ArrayList<Integer>> getFreeTiles(){
        return this.tilesfree;
    }


    /**
     * allow ot check if a tile has more than zero adjacente tile wich is not Ocean.
     * every usable tile of the Wargame board must respect this condition.
     * @param
     * @return true if the condition is respected, false else.
     */
    protected boolean hasMoreThanZeroAdjacentUsableTile(int row, int col) {
        Tile tile;
        int[][] positions = {{row, col-1}, {row+1, col}, {row, col+1}, {row-1, col}};
        tile = this.tiles[row][col];
        if (tile instanceof UnusableTile)
            return true;
        for(int position[]: positions) {
            int x = position[1];
            int y = position[0];
            if (this.isValidPosition(y, x)){
                tile = this.tiles[y][x];
                if (tile instanceof UsableTile){
                    return true;

                }
            }
        }
        return false;
    }

    

    /**
     * return the number of tile oceana of the board.
     * @return the number of tile ocean.
     */
    protected int numberOfOcenTile(){
        Tile tile;
        int n=0;
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.lenght; j++) {
                tile = this.tiles[j][i];
                if (tile instanceof Ocean)
                    n++;
            }
        }
        return n;
    }

	


}
