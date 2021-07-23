package jeu.action;

import java.util.Iterator;
import java.util.*;
import jeu.player.Player;
import jeu.character.Character;

/**
 * allow to reward characters deployed by a player.
 */
public class Distribute implements Action{
    /**
     * allow to perform the action.
     * @param player
     */
    public void realiser(Player player){
        boolean isRewardedSuccesfully;
        Character character;
		List<Character> characters = new ArrayList<>(player.deployedCharacter());
        Iterator<Character> iter = characters.iterator();

		while (iter.hasNext()){
			character = iter.next();
            isRewardedSuccesfully = player.reward(character);
		    if (!isRewardedSuccesfully) {
                character.quitGame();
                int[] position = character.getPositions();
                System.out.println(player + " lose one character at position ("+position[0]+","+position[1]+") for not feeding it");  
            }
        }
        System.out.println(player + "distributes reward to his characters");
    }
}
