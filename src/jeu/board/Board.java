package jeu.board;

import jeu.board.tile.Ocean;
import jeu.board.tile.*;

import java.util.ArrayList;
import java.util.List;
/** The game board.
 *
 */
public abstract class Board{

	protected int lenght;
	protected int width;
	protected Tile[][] tiles;

    /**
     * Constructor.
     * Create a rectangular board. The dimensions is width*lenght.
     * @param lenght the vertical size of the bord.
     * @param width the horizontal size of the board.
     */
	public Board(int lenght, int width) {
		this.lenght = lenght;
		this.width = width;
		this.tiles = new Tile[this.lenght][this.width];
		this.initBoard();
	}

	/**
	 * return horizontal size of the board.
	 * @return the width of the board.
	 */
	public int getWidth() {
        return this.width;
    }

	/**
	 * return the vertical size of the board.
	 * @return the length of the board
	 */
    public int getLength() {
        return this.lenght;
    }

	/**
	 * Initialize the board.
     * each board must be initialised according to certain rules.
	 */
	public abstract void initBoard();

	/**
	 * return the tile that is at the position (y, x).
	 * @param x, the horizontal position from 0
	 * @param y, the vertical position from 0
	 * @return a tile
	 */
	public Tile getTile(int y, int x) {
		// lever une exception si mauvaise position
		return this.tiles[y][x];
	}

	public List<int[]> freePositions(){
		List<int[]> positions = new ArrayList<>();
		Tile tile;
		for (int x=0; x < this.width; x++){
		    for (int y=0; y < this.lenght; y++){
				tile = this.tiles[y][x];
                if (tile instanceof UsableTile && !tile.isBusy()){
                    int[] position = new int[2];
                    position[0] = x;
                    position[1] = y;
                    positions.add(position);
                }
            }
        }

        return positions;
    }

    /**
     * return the adjacent tile's of a know tile.
     * Each tile can have at least 2 adjacent tile and at most 4.
     * (LEFT, RIGHT, UP, DOWN)
     * @param col is the horizontal position of the main tile.
     * @param row is its vertical position.
     * @return a list of tile
     */
    public List<Tile> adjacenteTileOf(int row, int col) {
        int[][] positions = {{row, col-1}, {row+1, col}, {row, col+1}, {row-1, col}};
        List<Tile> adjacenteTile = new ArrayList<>();
        for(int position[]: positions) {
            int x = position[1];
            int y = position[0];
            if (this.isValidPosition(y, x))
                adjacenteTile.add(this.getTile(y, x));
        }
        return adjacenteTile;

    }

    /**
     * check if all the tile have been used.
     * @return true if there are any free tile. false otherwise.
     */
    public boolean allTileUsed(){
        for (int x=0; x < this.width; x++){
            for (int y=0; y < this.lenght; y++){
                if (!this.tiles[y][x].isBusy())
                    return false;
            }
        }
        return true;
    }

    /**
     * Cheack if a giving position is valid.
     * the x, y values of a avlid position respect these conditions:
     * <li>
     *	<ul> they are positives </ul>
     *	<ul> they are lower than width, height of the board </ul>
     * </li>
     * @param col is the horizontal position.
     * @param line is the vertical position.
     * @return true if the position is valid; false otherwise.
     */
    public boolean isValidPosition(int line, int col) {
        return 0 <= line && line < this.lenght && 0 <= col && col < this.width ;
    }

    /**
     * printf the board.
     * The usable tile will have green color.
     * Each Tile will have its own representation.
     * "@see Tile.toString()" for more details
     */
    public void print() {
        final String RED_BOLD = "\033[1;31m";
        final String ANSI_CYAN = "\u001B[36m";
        final String GREEN_BOLD = "\033[1;32m";
        final String ANSI_RESET = "\u001B[0m";
        Tile tile;
        String space;

        // affichage des numeros de lignes
        System.out.print("    ");
        for (int x=0; x < this.width; x++){
            if(x<10){
                space = "  ";
            }
            else{
                space = " ";
            }
            System.out.print(x+space);

        }
        System.out.print("\n");

        for (int i=0; i < this.lenght; i++) {
            if(i<10){
                space = "  ";
            }
            else{
                space = " ";
            }
            System.out.print(i + space);
            for (int j=0; j < this.width; j++) {
                tile = this.tiles[i][j];
                if (tile instanceof Ocean)
                    System.out.print(ANSI_CYAN + tile + ANSI_RESET);
                else if (!tile.isBusy())
                    System.out.print(tile);
                else {
                    String color = tile.getCharacter().getOwner().getColor();
                    System.out.print(color + tile + ANSI_RESET);
                }

            }
            System.out.println();
        }
    }

    public List<int[]> usableTilePositions(){
        List<int[]> positions= new ArrayList<int[]>();
        for (int i=0; i<this.width; i++) {
                for (int j=0; j<this.lenght; j++) {
                            Tile tile = this.tiles[j][i];
                            if (!(tile instanceof Ocean)){
                                        int[] coordonne = {j,i};
                                        positions.add(coordonne);
                            }
                }
        }
        return positions;
}



    public static void main(String[] argv) {
        Board board = new BoardWarGame(10, 10);
        board.print();
    }
}
