package jeu.board.tile;


import jeu.board.tile.resource.Resource;
import jeu.character.Character;
import jeu.exception.TileException;
/**
 * @author 
 *
 */
public abstract class UsableTile implements Tile {
    /**the resource that the tile can product */
    protected Resource resource;
    /**the maximum size that the tile can support*/
    protected int maxCharacters;
    /**the current Character who use the Tile*/
    protected Character character;
    /**determine if the Tile is busy or not*/
    protected boolean busy;
    /**the value to multiply to the squad size to detemermin the value of the reward*/
    protected int rewardCoef;
    /**Some tile has an impact on the character size (value to add to the size), this value allow to determine the level*/
    protected int relativeSizeBonus;
    /**Some tile provide bonus point to the user at the end of the game, this value determin that*/
    protected int bonusPoint;

    /**
     * Tile constructor
     * @param rewrdCoef the impact of the tile on the chracter reawrd.
     * @param relatSizeBonus the influence of the tile on the character size.
     * @param bonus the gold quantity to give to the player ath the end of the game if the tile is used by his character.
     */
    public UsableTile(int rewrdCoef, int relatSizeBonus, int bonus, int maxCharacters) {
        this.bonusPoint = bonus;
        this.relativeSizeBonus = relatSizeBonus;
        this.rewardCoef = rewrdCoef;
        this.busy = false;
        this.maxCharacters = maxCharacters;
    }

    /**
     * return the resource of the territory
     * @return return the resource of the tile
     */
    public abstract Resource getResource();

    /**
     * allow to get the size of the squad which occupe the tile
     * @return return the size of the squad that exploit the tile
     */
    public int getMaxCharacterAllowed() {
        return this.maxCharacters;
    };

    /**
     * check is the tile is used or not.
     * A tile is used, if a character is placed here.
     * @return true if the tile is used, false if not
     */
    public boolean isBusy() {
        return this.busy ;
    }

    /**
     * To receive a chracter, the squad's size must be above the maximum size allow by the tile.
     * @param character the character to check if it's can occupe the tile or not.
     * @return true if the charcter can occupe, false if not
     */
    public boolean canSupportSize(Character character) {
        return this.maxCharacters >= character.getSize();
    }

    /**
     * determine the impact of the tile of the character reward.
     * @return the value to multiply with the the squad size to determin the reward's value.
     */
    public int getReawardCoef() {
        return this.rewardCoef;
    }

    /**
     * le bonus de la taille reative correspond à celle qu'on ajoute à la taille(effectif) du personnage.
     * Exemple (sur un montagne, une armée de taille 3 voit sa taille augmentée de 2 soit 5 comme taille relative)
     * @return relative size of the character du to the impact of the tiles where occupied by.
     */
    public int getRelativeSizeBonus() {
        return this.relativeSizeBonus;
    }

    /**
     * return the bonus point
     * @return return the bonus point
     */
    public int getBonusValue() {
        return this.bonusPoint;
    }

    /**
     * allow to set a new character to occupy the tile.
     * @param character the new character to affect to this tile.
     * @throws TileException
     */
    public void setCharacter(Character character) throws TileException {
        if (!this.canSupportSize(character)) {
            throw new TileException("Maximum size allowed exceded");
        }
        else if (this.isBusy()) {
            throw new TileException("Tile already used");
        }
        //else
        this.character = character;
        this.busy = true;
        this.character.setTile(this);
    }

    /**
     * allow to get the current character who use the tile.
     * @return the chracter placed on the tile.
     */
    public Character getCharacter() {
        return this.character ;
    }

    /**
     * allow to remove acharacter from the tile.
     */
    public void removeCharacter() {
        this.character = null;
        this.busy = false;
    }

    /**
     * The name of the tile, it can be the same as the type.
     * @return the tile's name.
     */
    public abstract String name();
}
