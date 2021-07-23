package jeu.action;

import jeu.board.Board;
import jeu.board.tile.Tile;
import jeu.character.Character;
import jeu.character.Worker;
import jeu.player.Player;
import jeu.strategy.Strategy;
import java.util.*;
import java.util.Scanner;
/**
 * Add a new worker to the Game.
 */
public class DeployeWorker implements Action {
    private Board board;

    public DeployeWorker(Board board){
        this.board = board;
    }

    final String RED_BOLD = "\033[1;31m";
    final String ANSI_CYAN = "\u001B[36m";
    final String GREEN_BOLD = "\033[1;32m";
    final String ANSI_RESET = "\u001B[0m";

    /**
     * allow to perform the action.
     * @param player
     */
    public void realiser(Player player){
        int x, y;
        Tile tile;
        Strategy strategy = player.getStrategy();
        int[] position = strategy.PositionToDeploye();
        x = position[0];
        y = position[1];
        Character character = new Worker(player,position);
        tile = this.board.getTile(y, x);
        player.deployeCharacter(character, tile);
        System.out.println(player + " deployed " + character + " on " + " tile at position (" + x + "," + y + ")");
        /**List<int[]> coordonne = this.board.usableTilePositions();
        System.out.println(coordonne);*/
    }
}
