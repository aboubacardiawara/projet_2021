package jeu.character;

import jeu.player.Player;
import jeu.board.tile.*;

/**
 * Modelisation de la class Personnage
 * @author
 * @version 1.0
 */
public abstract class Character{
	/**the current tile used by the character*/
	protected Tile tile;

	/**the current owner of the character*/
	protected Player owner;

	/**the size of the squad */
	protected int size;

	/** golds quantity*/
	protected int golds;

	/*the position of the character in the board */
	protected int[] position;

	/**
	 * The constructor of the object Character
	 * @param size the size of the squad
	 * @param owner the current character's owner
	 */
	public Character(int size, Player owner,int[] position){
		this.size = size;
		this.owner = owner;
		this.position= position;
	};

	/**
	 * allow to get the current owner of the Character
	 * @return the current owner of the caracter
	 */
	public Player getOwner(){
		return this.owner;
	};

	/**
	 * allow to get the Tile occupied by the character
	 * @return a tile
	*/
	public Tile getTile() {
		return this.tile;
	}

	/**
	 * allow to get the size of the squad
	 * @return the squad size
	*/
	public int getSize() {
		return this.size;
	};

	/**
	 * allow to upgrade the quantity of golds
	 * @param quantity the quantity of to add on the current
	*/
	public void addGold(int quantity) {
		this.golds += quantity;
	};

	/**
	 * allow to change the tile used by the squad
	 * @param newTile tile to set the character on.
	*/
	public void setTile(Tile newTile) {
		this.tile = newTile;
	};

	/**
	 * allow to change the size of the squad
     * the maximum size allowed depends of the tile.
	 * @param newSize the new size of the squad
	*/
	public void setSize(int newSize) {
		if (0 <= newSize && newSize <= this.tile.getMaxCharacterAllowed())
            this.size = newSize;
	};

	/**
	 * allow to change the owner of the character.
	 * @param newOwner the new owner
	*/
	public void changeOwner(Player newOwner) {
		/*
		 * changer l'attribut du personnage
		 * retirer de la liste des personnage de l'ancien joueur
		 * puis ajouter à la liste des personnages du nouveau joueur
		 */
		this.owner = newOwner;
	};

	/**
	 * allow to evaluate the quantity of reward to give to the character.
	 * @return the quantity of reward
	*/
	public int getRewardValue(){
		int coef = this.tile.getReawardCoef();
		int normalReward = this.size;
		return coef * normalReward;
	};

	/**
	 * allow to the character to leave the game.
	 */
	public abstract void quitGame();

	/**
	 * return a character description (it can be his name).
	 * @return description of the character
	 */
	public abstract String toString();

	public int tilePoints() {
		return 0; // est-ce necessaire cette methode ?
	}

    public int getGold(){
        return this.golds;
    }

		/**
			return the position of the character in the board
		*/
		public int[] getPositions(){
			return this.position;
		}

    public int getRelativeSize(){
        return this.tile.getRelativeSizeBonus() + this.size;
    }
}
