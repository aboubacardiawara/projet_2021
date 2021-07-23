package jeu.player;

import jeu.board.tile.Tile;
import jeu.board.tile.resource.Resource;
import jeu.character.Character;
import jeu.exception.TileException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jeu.strategy.*;
import java.util.Iterator;
/**
 * the Player of the game
 * @author
 *
 */
public abstract class Player{
    /*The player name */
    protected String name;

    protected String color;
    /* The list of the character deployed by the player during the game*/
    protected List<Character> characterDeployed;
    /*The quantity of gold owned by the player*/
    protected int golds;
    /*The resources collected by the player and it quantity*/
    protected Map<Resource, Integer> resources;

    protected Strategy strategy;

	protected int sizeCharacterDeployed;


    /**
     * Constructor
     * @param name the name of the player
     * @param golds the initial golds quantity of the player
     */
    public Player(String name, int golds, Strategy strategy) {
        this.name = name;
        this.characterDeployed = new ArrayList<>();
        this.resources = new HashMap<>();
        this.golds = golds;
        this.strategy = strategy;
		this.sizeCharacterDeployed = 0;
    }

    public Strategy getStrategy(){
        return this.strategy;
    }


    /**
     * allow to get the number of characters deployed by the player.
     * a player can deploy many character during the game.
     * @return player's number of character
     */
    public int nummberOfCharacterDeployed() {
        return this.characterDeployed.size();
    }

    /**
     * Get the gold quantity of the player
     * @return gold quantity
     */
    public int getGolds(){
        return this.golds;
    }

	public int sizeCharacterDeployed(){
		return this.sizeCharacterDeployed;
	}

    /**
     * Get the name of the player
     * @return player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * allow to check if a plyer deployed succesfully a character on the tile.
     * if the tile can support the character size and if it is not used,
     * so the process will be success.
     * @param character a character to set on tile.
     * @param tile the the plyer want to use.
     * @return true if the player deployed it succesfully, false else.
     */
    public boolean deployeCharacter(Character character, Tile tile) {
        try {
            tile.setCharacter(character);
        } catch (TileException e) {
            return false;
        }
        this.characterDeployed.add(character);
		this.sizeCharacterDeployed += character.getSize();
        return true;
    }

    public int get_bis(Resource resource) {
        for (Resource r: this.resources.keySet()) {
            if ( r.equals(resource) ) {
                return this.resources.get(r);
            }
        }
        return 0;
    }

    public void replace_bis(Resource resource, int v) {
        for (Resource r: this.resources.keySet()) {
            if ( r.equals(resource) ) {
                this.resources.replace(r, v);
            }
        }
    }

    public void remove_bis(Resource resource) {
		Resource r;
        for (Iterator<Resource> iterRes = this.resources.keySet().iterator(); iterRes.hasNext(); ) {
			r = iterRes.next();
            if ( r.equals(resource) ) {
                iterRes.remove();
            }
        }
    }
    /**
     * return the player's name.
     * @return a description (name) of the player
     */
    public String toString() {
        return " " + this.name + " ";
    }

    /**
     * remove a character from the currents characters deployed by player.
     * @param character the character to remove.
     */
    public void removeCharacter(Character character) {
        this.characterDeployed.remove(character);
    }


    /**
     * allow to increase the glod quantity of the player.
     * @param quantity gold quantity to add on the current.
     */
    public void addGold(int quantity) {
        this.golds += quantity;
    }


    /**
     * allow to get the list of character deployed
     * @return the character deployed by the player.
     */
    public List<Character> deployedCharacter() {
        return this.characterDeployed;
    }

    /**
     * check if the player has already the same kind of resource.
     * @param resource the resource to check the presence.
     * @return true if the player has already the resource. false otherwise.
     */
    public boolean hasAlreadySameResource(Resource resource) {
        for (Resource r: this.resources.keySet()) {
            if ( r.equals(resource) )
                return true;
        }
        return false;
    }



    /**
     * allow to add a new resource to the player collection.
     * @param resource the resource to increase quantity.
     */
    public void addResource(Resource resource) {
        int occurence;
        occurence = this.get_bis(resource);
        if (occurence == 0){
            this.resources.put(resource, ++occurence);
            System.out.println("The resource did not exist yet ");
        }
        else {
            this.replace_bis(resource, ++occurence);
        }
    }


    /**
     * allow to reward a character deployed.
     * @param character the character to reward
     * @return true if the character has been rewarded. false otherwise.
     */
    public abstract boolean reward(Character character);

    /**
     * allow to increase the resource to use to reward character.
     * - in farm game it'll be gold.
     * - in war game it'll be food.
     * @param quantity the value of the reward.
     */
    public abstract void addToResourceForAward(int quantity);

    /**
     * allow to convert resource.
     * Each resource can be convert in another product.
     */
    public void convert(){
        /*
           ----------------------- PROCEDURE ------------------
           - pour chaque Resource:
           - reduire sa quantité de 1.
           - recuperer (utiliser addToResourceForAward(quantity)).
           qantity est sa valeur marchande (en nourriture ou or).
           (une methde de Resource permet de recuper cette valeur).
           */

        Integer quantity;
        // iteration on resources(Map) keys.
		Resource resource;
        for (Iterator<Resource> iterRes = this.resources.keySet().iterator(); iterRes.hasNext(); )  {
			resource = iterRes.next();
            boolean isChangedResource = this.changeResourcesQty(resource, -1);
            if (isChangedResource){
                quantity = resource.getValue();
                this.addToResourceForAward(quantity);
            } else {
                iterRes.remove();
            }
        }

    }

    /**
     * allow to change the value associate to the key `resource` in the Map resources.
     * @param resource the resource to change quantity.
     * @param valueToAdd the value to add to the current quantity of 'resource".
     * this value can be positive and negative.
     */
    private boolean changeResourcesQty(Resource resource, Integer valueToAdd){
        Integer currentQty;
        currentQty = this.get_bis(resource);
        currentQty += valueToAdd;
        if (currentQty > 0){
            this.replace_bis(resource, currentQty);
            return true;
        }
        return false;
    };

    /**
     * print the resource collected by the player.
     */
    public void printRes(){
        System.out.println("nbr character deployed: " + this.nummberOfCharacterDeployed());
        System.out.println(this.resources);
    }


    /**
     * allow to print some details about the player.
     * The detials concerns the resources and their quantity,
     * the player's gold ...
     * */
    public abstract void statePlayer();


    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public abstract int getScore();

	public abstract boolean canDeploye();

}
