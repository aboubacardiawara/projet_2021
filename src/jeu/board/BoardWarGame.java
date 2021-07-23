package jeu.board;

import jeu.board.tile.*;
import java.util.*;
import jeu.util.Aleatoire;


/**
 * the board for the war game
 * @author 
 *
 */
public class BoardWarGame extends ClassicBoard{
    /**
     * Constructor.
     * Create a rectangular board. The dimensions is width*lenght. 
     * @param lenght the vertical size of the board.
     * @param width the horizontal size of the board.
     */
	public BoardWarGame(int lenght, int width) {
		super(lenght, width);		
	}
    
    public void setUsableTile(int numberOfTileToSet) {
        int x, y;
        int choixTile;


        while (numberOfTileToSet >= 0) {
            x = Aleatoire.genererInt(0, this.width-1);
            y = Aleatoire.genererInt(0, this.lenght-1);
            choixTile = Aleatoire.genererInt(0, 3);
            if (!(this.tiles[y][x] instanceof Tile)) {
                // args of the arguments of the followings tile object:
                // (rewardCoef, relativeSizeBonus, bnus, resourceValue, maxChar)
                switch (choixTile) {
                    case 0:
                        this.tiles[y][x] = new Desert(2, 0, 4, 0, 3);
                        break;
                    case 1:
                        this.tiles[y][x] = new Plain(1, 0, 1, 5, 5);
                        break;
                    case 2:
                        this.tiles[y][x] = new Woods(1, 0, 2, 1, 5); 
                        break;
                    case 3:
                        this.tiles[y][x] = new Mountain(1, 0, 4, 0, 3);
                        break;
                }
                numberOfTileToSet--;
            }
        }
    }



}
