package jeu.game;
import jeu.action.*;
import jeu.board.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import jeu.player.*;

/**
 * gmae class
 */
public abstract class Game {
    final String ANSI_RESET = "\u001B[0m";
    
    /** The game's board */ 
    protected Board board;

    /**The list of the players*/
    protected List<Player> players;

    /**possibles actions to do in the game*/
    protected Map<String, Action> actions;

    /** iterator on the list of players */ 
    protected Iterator<Player> iter_players;

    /**number of rounds allowed for the game */
    protected int rounds;

    /** The current round of playing */
    private int currentRound;

    /**
     * constructor
     * @param board
     */
    public Game(Board board, int rounds){
        this.currentRound = 1;
        this.board = board;
        this.rounds = rounds;
        this.players = new ArrayList<>();

        this.actions = new HashMap<>();
        this.actions.put("reap", new Reap());
        this.actions.put("convert", new Convert());
        this.actions.put("distribute", new Distribute());
    }

    /**
     * allow to add a new player to the Game.
     * @param player a player 
     */
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Board getBoard(){
        return this.board;
    }
    /**
     * allow to one player to make his moves.  
     */
    public abstract void PlayPlayer(Player player);

    /**
     * manage each round of the game.
     * each player will do one move.
     * @return true if the game is over. else otherwise.
     */
    public boolean playOneRound() {
        System.out.println("\n ########## ROUND " + this.currentRound + " ############");
        this.iter_players = this.players.iterator();
        while (this.iter_players.hasNext() && !this.board.allTileUsed()){
            this.board.print();
            PlayPlayer(iter_players.next()); 
        }
        this.currentRound++;

        return this.currentRound > this.rounds | this.board.allTileUsed();
    }

    /**
     * manage the entire game.
     * @return the winner of the game.
     * if anyone, return null
     */
    public Player play(){
        System.out.println("LEGENDE");
        this.iter_players = this.players.iterator();
        while (this.iter_players.hasNext()) {
            Player p = iter_players.next();
            System.out.println(p + " --> " + p.getColor() + "color" + ANSI_RESET);
        }
        boolean gameOver = false;
        while (!gameOver) {
            gameOver = playOneRound();
        }
        // return the winner.
        return winner();
    }

    /**
     * return the game winner.
     * the winner has the higher score of the game.
     * @return the PLayer who win the game.
     */
    private Player winner() {
        this.iter_players = this.players.iterator();
        Player player, winner = this.iter_players.next();
        while (this.iter_players.hasNext()) {
            player = this.iter_players.next();
            
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }
}
