/**
 * 
 */
package jeu.board.tile;


/**
 * @author 
 *
 */
public class Ocean extends UnusableTile{
	public Ocean() {
	}
	
	public String toString() {
		return " O ";
	}

    /**
     * The name of the tile, it can be the same as the type.
     * @return the tile's name.
     */
    public String name(){
        return "Ocean";
    }
}
