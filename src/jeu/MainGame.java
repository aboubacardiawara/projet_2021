package jeu;
import jeu.board.*;
import jeu.game.*;
import jeu.player.*;
import jeu.strategy.*;
import jeu.strategy.Strategy;
import jeu.util.io.*;
import java.util.*;

public class MainGame{

    /**
     * Choice of a game
     * @return the choosen game
     * */
    public static Game chooseGame(String choice) {
        final String RED_BOLD = "\033[1;31m";
        final String ANSI_CYAN = "\u001B[36m";
        final String GREEN_BOLD = "\033[1;32m";
        final String ANSI_RESET = "\u001B[0m";
        int lenght=10, width = 10;

        System.out.println(GREEN_BOLD+"================= Game Selection ================"+ANSI_RESET);
        System.out.println(ANSI_CYAN+"1) War Game"+ANSI_RESET);
        System.out.println(ANSI_CYAN+"2) Farm Game"+ANSI_RESET);
        System.out.println("Enter 1 or 2 for either of the two games");

        System.out.println(GREEN_BOLD+"================================================"+ANSI_RESET);
        if (choice.equals("1")) {
           return new GameWar(new BoardWarGame(lenght, width));
       	}
	   	else{
            return new GameFarm(new BoardFarmGame(lenght, width));
		}
    }

    /**
     * Add players to the game
     * */
    public static void addPlayers(Game game, List<String> playersName) {

        String[] colors = {"\033[0;31m","\033[0;33m", "\033[0;34m","\u001B[36m","\033[0;32m","\033[0;35m"};
        final String RED_BOLD = "\033[1;31m";
        final String ANSI_CYAN = "\u001B[36m";
        final String GREEN_BOLD = "\033[1;32m";
        final String ANSI_RESET = "\u001B[0m";
        int colorIndex = 0;
        Player player;
        Strategy strategy;
        String playerName, option;
        boolean finishedToAddPlayer = false;

		if (game instanceof GameWar) {
			strategy = new RandomStratWar(game.getBoard());
		}
		else {
			strategy = new RandomStratFarm(game.getBoard());
		}

		for(String name : playersName) {
            player = new PlayerWar(name, strategy);
            player.setColor(colors[colorIndex++]);
            game.addPlayer(player);
        }
    }

    public static void main(String[] args){

		final String RED_BOLD = "\033[1;31m";
		final String ANSI_CYAN = "\u001B[36m";
		final String GREEN_BOLD = "\033[1;32m";
		final String ANSI_RESET = "\u001B[0m";

		if (args.length < 3) {
			System.out.print(RED_BOLD + "Usage: " + ANSI_RESET);
			System.out.println("Usage: java MainGame <Game_id> Player_1 Player_2 ... Player_n");
			System.exit(-1);
		}


        Player winner;
        // Choose game : WAR GAME or Farm Game
        Game game = MainGame.chooseGame(args[0]);
        //Add players to the game
        List<String> playersName = new ArrayList<String>();
        for(int i=1;i<args.length;i++){
            playersName.add(args[i]);
        }

        MainGame.addPlayers(game,playersName);
        winner = game.play();
        System.out.println(GREEN_BOLD+"\n\n ~~~~~~~~~ GAME FINISHED ~~~~~~~~~"+ANSI_RESET);
        if (winner == null)
            System.out.println(GREEN_BOLD+"DRAW GAME"+ANSI_RESET);
        else
            System.out.println(ANSI_CYAN+"Congratulation " + winner + ", you are the winner"+ANSI_RESET);
    }
}
