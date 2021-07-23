package jeu.game;

import jeu.util.io.*;
import jeu.board.Board;
import jeu.action.*;
import jeu.player.*;
import jeu.strategy.*;

/**
 * GameWar
 */
public class GameWar extends Game {

    /**
     * allow to add a new player to the Game.
     * @param player a player
     */
    public GameWar(Board board) {
        super(board, 10);
        this.actions.put("nothing", new NothingWar());
		this.actions.put("deploye", new DeployeArmy(board));
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
            "nothing"
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
        System.out.println(GREEN_BOLD+"What do you want to do (deploye/nothing) ?"+ANSI_RESET);
        // 1
        Strategy strategy = player.getStrategy();
        /**if(strategy instanceof RandomStrat){

        }*/
        choixAction = strategy.chooseAction();
        while ( !actionValid(choixAction) ) {
            System.out.println(RED_BOLD+"type a valid action (deploye/nothing)"+ANSI_RESET);
            choixAction = strategy.chooseAction();
        }

        action = this.actions.get(choixAction);
        action.realiser(player);

        // 2
        action = this.actions.get("reap");
        action.realiser(player);
        // 3
        // donner le choix au joueur de Convertir ses resources.
        action = this.actions.get("distribute");
        action.realiser(player);
        player.statePlayer();
    }

}
