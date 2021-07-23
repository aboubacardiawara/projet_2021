package jeu.character;

import jeu.board.tile.Tile;
import jeu.player.Player;


/**
 * the army of
 * @author
 * @version 1.0
 */
public class Army extends Character{
	/**
	 * The constructor of the object Character
	 * @param size the size of the squad
	 * @param owner the current character's owner
	 */
	public Army(int size, Player owner,int[] position) {
		super(size, owner,position);
	}

    /**
     * Allow to a character to leave the game.
     * A charcater can leave the game if his owner don't give it a reward.
     */
	public void quitGame() {
		this.owner.addGold(1);
		this.owner.removeCharacter(this);
        this.tile.removeCharacter();
	}

	/**
	 * return a character description (it can be his name).
	 * @return description of the character
	 */
	public String toString(){
        return "{character: army, size: " + this.size + "}";
    }
}
