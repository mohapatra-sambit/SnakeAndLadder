package com.snl.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.snl.bean.Player;

public class Game {
	
	private int numOfPlayers;
	
	private List<Player> players;
	
	private int currentPlayer;
	
	public Game(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
		players = new ArrayList<Player>(numOfPlayers);
		for (int i = 0; i < numOfPlayers; i++) {
			Player p = new Player("Player-" + (i+1), getColor(i+1));
			players.add(p);
		}
		this.currentPlayer = -1;
	}
	
	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}
	
	public void moveChance() {
		System.out.println("Moving to next player.");
		++currentPlayer;
		if (currentPlayer > (numOfPlayers - 1)) {
			currentPlayer = 0;
		}
	}
	
	private Color getColor(int i) {
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		return new Color(r, g, b);
	}

}
