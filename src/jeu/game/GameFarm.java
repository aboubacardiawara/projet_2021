package jeu.game;

import jeu.board.*;
import jeu.util.io.*;
import jeu.player.*;
import jeu.action.*;
/**
 * GameFarm
 */
public class GameFarm extends Game {

    /**
     * allow to add a new player to the Game.
     * @param player a player
     */
    public GameFarm(Board board) {
        super(board, 10);
        this.actions.put("deploye", new DeployeWorker(board));
        this.actions.put("nothing", new NothingFarm());
    }

    final String RED_BOLD = "\033[1;31m";
    final String ANSI_CYAN = "\u001B[36m";
    final String GREEN_BOLD = "\033[1;32m";
    final String ANSI_RESET = "\u001B[0m";

    /**
     * check if a giving action is a possible action.
     * @param actionName the action name.
     * @return
     */
    private boolean actionValid(String actionName) {
        String[] possiblesActions = {
            "deploye",
            "nothing",
            "convert"
        };

        for (int i=0; i<possiblesActions.length; i++){
            if ( possiblesActions[i].equals(actionName.toLowerCase()) )
                return true;
        }
        return false;
    }
    /**
     * allow to one player to make his moves.
     */
    public void PlayPlayer(Player player) {
        /*
           1) deployer ou echanger ou ne rien faire.
           2) recolter les ressources
           3) renumerer ses ouvriers
           */
        String choixAction;
        Action action;
        System.out.println(GREEN_BOLD+">>> " + player + " is playing"+ANSI_RESET);
        //System.out.println(GREEN_BOLD+"What do you want to do (deploye/convert/nothing) ?"+ANSI_RESET);
        // 1
        choixAction = player.getStrategy().chooseAction();


        action = this.actions.get(choixAction);
        action.realiser(player);

        // 2
        action = this.actions.get("reap");
        action.realiser(player);
        // 3
        action = this.actions.get("distribute");
        action.realiser(player);
        player.statePlayer();
    }

}
