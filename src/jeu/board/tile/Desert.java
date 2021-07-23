package jeu.board.tile;

import jeu.board.tile.resource.*;

/**
 * @author 
 *
 */
public class Desert extends UsableTile{
    /** the tile resource */
    private Resource resource;

	public Desert(int rewrdCoef, int relatSize, int bonus, int resourceValue, int maxCharacters) {
		super(rewrdCoef, relatSize, bonus, maxCharacters);
		this.resource = new Sand(resourceValue);
    }

	public String toString() {
		return " D ";
	}

    /**
     * return the resource of the territory
     * @return return the resource of the tile
     */
    public Resource getResource(){
        return this.resource;
    }
    
    /**
     * The name of the tile, it can be the same as the type.
     * @return the tile's name.
     */
    public String name(){
        return "Desert";
    }

}
