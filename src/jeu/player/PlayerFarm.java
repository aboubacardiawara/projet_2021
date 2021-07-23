package jeu.player;

import java.util.Iterator;
import jeu.character.Character;
import jeu.strategy.Strategy;
/**
 * PlayerFarm the player of the farm game
 */
public class PlayerFarm extends Player{
	public PlayerFarm(String name, Strategy strategy) {
		super(name, 15, strategy);
	}

    /**
     * allow to reward a character deployed.
     * @param character the character to reward
     * @return true if the character has been rewarded. false otherwise.
     */
	public boolean reward(Character character){
        if (this.golds >= character.getRewardValue()){
            this.golds -= character.getRewardValue();
            return true;
        }
        else
            return false;
    }

	/**
	 * allow to increase the resource (here gold) to use to reward character.
	 * @param quantity the value of the reward.
	 */
	public void addToResourceForAward(int quantity){
		this.addGold(quantity);
	}

    /**
     * allow to print some details about the player.
     * The detials concerns the resources and their quantity,
     * the player's gold ...
     * */
    public void statePlayer() {
        System.out.println("----- Current resources -----");
        this.printRes();
        System.out.println("gold quantity: " + this.golds);
    }

    /**
     * calculate the score of a specific player.
     * @return a player score.
     */
    public int getScore() {
        /*
            * Worker point.
         */
        int points = this.golds;
        Iterator<Character> iterCharacters = this.characterDeployed.iterator();
        Character character;
        while (iterCharacters.hasNext()) {
            character = iterCharacters.next();
            points += character.getGold();
        }

        return points;
    }

	public boolean canDeploye() {
		return true;
	}
}
