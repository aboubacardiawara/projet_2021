package jeu.player;
import jeu.character.Character;
import jeu.strategy.Strategy;

import java.util.Iterator;
/**
 * PlayerWar the player of the war game.
 */
public class PlayerWar extends Player {
	private int food;
	private int nbWarriors;
	public PlayerWar(String name, Strategy strategy) {
		super(name, 0, strategy);
		this.food = 10;
		this.nbWarriors=35;
	}

    /**
     * Get the food quantity of the player
     * @return food quantity
     */
    public int getfoodQuantity(){
        return this.food;
    }

    /**
     * allow to reward a character deployed.
     * @param character the character to reward
     * @return true if the character has been rewarded. false otherwise.
     */
	public boolean reward(Character character){
        if (this.food >= character.getRewardValue()){
            this.food -= character.getRewardValue();
            return true;
        }
        else
            return false;
    }

	/**
	 * allow to increase the resource (here food) to use to reward character.
	 * @param quantity the value of the reward.
	 */
	public void addToResourceForAward(int quantity){
		this.food += quantity;
	}
	/**
	* return the number of warriors
	*/
	public int getNbWarriors(){
		return this.nbWarriors;
	}

/**
	public boolean retireWarriors(int nbWarriors){
			if ((this.nbWarriors - nbWarriors) <= 0) {
					System.out.println("----- Current resources -----");
			}
	}
*/
    /**
     * allow to print some details about the player.
     * The detials concerns the resources and their quantity,
     * the player's gold ...
     * */
    public void statePlayer() {
        System.out.println("----- Current resources -----");
        this.printRes();
        System.out.println("gold quantity: " + this.golds);
        System.out.println("food quantity: " + this.food);
    }

    public int getScore() {
        /*
            * player's golds.
            * playe's armies golds.
            * tile bonus.
            * 10 tile used bonus.
         */
        int points = this.golds;
        Iterator<Character> iterCharacters = this.characterDeployed.iterator();
        Character character;
        while (iterCharacters.hasNext()) {
            character = iterCharacters.next();
            points += character.getGold();
            points += character.getTile().getBonusValue();
        }
        // nummberOfCharacterDeployed -> number of used tile.
        if (this.nummberOfCharacterDeployed() >= 10 ) {
            points += 5;
        }

        return points;
    }

	public boolean canDeploye() {
		return this.sizeCharacterDeployed < 35;
	}

}
