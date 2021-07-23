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
public class TestDeployeInFarmGame {
	private Board board;
	private Player player;
	Strategy strategy ;
	@Before
	public void before(){
		this.board = new BoardFarmGame(10,10);
		strategy = new RandomStratWar(this.board);
		this.player = new PlayerFarm("timoleon",strategy);
	}

	@Test
	public void DeployeMustIncreaseThePlayerCharacterDeployed(){

	}
}
