package jeu.character;

import jeu.board.tile.Tile;
import jeu.player.Player;

/**
 * modelisation of the worker
 * @author
 * @version 1.0
 */
public class Worker extends Character{
	/**
	 * The constructor of the object Character
	 * @param owner the current character's owner
	 */
	public Worker(Player owner,int[] position) {
		super(1, owner,position);
	}

    /**
     * Allow to a character to leave the game.
     * A charcater can leave the game if his owner don't give it a reward.
     */
	public void quitGame() {
		this.owner.removeCharacter(this);
		this.owner = null;
        this.tile.removeCharacter();
	}

	/**
	 * return a character description (it can be his name).
	 * @return description of the character
	 */
	public String toString(){
        return "{character: worker, size: " + this.size + "}";
    }
}
