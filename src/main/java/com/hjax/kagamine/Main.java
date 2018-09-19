package com.hjax.kagamine;

import java.nio.file.Paths;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.github.ocraft.s2client.protocol.game.Race;
import com.hjax.kagamine.Kagamine;

public class Main {

	    public static void main(String[] args) {
	        Kagamine bot = new Kagamine();
	        S2Coordinator s2Coordinator = S2Coordinator.setup()
	                .loadSettings(args)
	                .setParticipants(
	                        S2Coordinator.createParticipant(Race.ZERG, bot),
	                        S2Coordinator.createComputer(Race.ZERG, Difficulty.MEDIUM))
	                .launchStarcraft()
	                .startGame(LocalMap.of(Paths.get("C:\\Program Files (x86)\\StarCraft II\\Maps\\CatalystLE.SC2Map")));

	        while (s2Coordinator.update()) {
	        }

	        s2Coordinator.quit();
	    }

	}