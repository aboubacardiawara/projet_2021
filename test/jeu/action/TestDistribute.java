package jeu.action;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import jeu.player.*;
import jeu.board.*;
import jeu.strategy.*;

/**
 * testConvert
 */
public class TestDistribute {
	private Board board;
	private Player player;
	Strategy strategy ;
	
	@Before
	public void before(){
		this.board = new BoardWarGame(10, 10);
		strategy = new RandomStratWar(this.board);
		this.player = new PlayerWar("timoleon",strategy);
	}

	@Test
	public void DeployeMustIncreaseThePlayerCharacterDeployed(){

	}
}
