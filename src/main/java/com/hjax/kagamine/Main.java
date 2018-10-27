package com.hjax.kagamine;

import java.nio.file.Paths;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.github.ocraft.s2client.protocol.game.Race;
import com.hjax.kagamine.Kagamine;

public class Main {
		public static boolean ladder = false;
	    public static void main(String[] args) {
	        Kagamine bot = new Kagamine();
	        Nothing bot2 = new Nothing();
	        S2Coordinator s2Coordinator;
	        if (ladder) {
	        	System.out.println("Starting ladder game");
		        s2Coordinator = S2Coordinator.setup()
		                .loadLadderSettings(args)
		                .setParticipants(S2Coordinator.createParticipant(Race.ZERG, bot))
		                .connectToLadder()
		                .joinGame();
	        } else {
	        	System.out.println("Starting regular game");
		        s2Coordinator = S2Coordinator.setup()
		                .loadSettings(args)
		                .setRealtime(true)
		                .setParticipants(
		                        S2Coordinator.createParticipant(Race.TERRAN, bot2),
		                        S2Coordinator.createParticipant(Race.ZERG, bot))
		                        //S2Coordinator.createComputer(Race.TERRAN, Difficulty.VERY_HARD))
		                .launchStarcraft()
		                .startGame(LocalMap.of(Paths.get("C:\\Program Files (x86)\\StarCraft II\\Maps\\ParaSiteLE.SC2Map")));
	        }
	        while (s2Coordinator.update()) {
	        }
	        s2Coordinator.quit();
	    }

	}