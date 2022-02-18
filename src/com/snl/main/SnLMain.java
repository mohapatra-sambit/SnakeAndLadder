package com.snl.main;

import javax.swing.JOptionPane;

import com.snl.bean.Player;
import com.snl.game.Game;
import com.snl.rules.Rules;
import com.snl.utils.Timer;

public class SnLMain {

	public static void main(String[] args) {
		System.out.println("Loading SnL Rules.");
		Rules.load();
		System.out.println("Asking user for inputting number of players.");
		Timer.pause();
		int numOfPlayers = takeInputFromUserForNumberOfPlayers();
		System.out.println("Number of players for this game: " + numOfPlayers);
		Timer.pause();
		System.out.println("Starting SnL now...");
		Timer.pause();
		Game game = new Game(numOfPlayers);
		Player p = null;
		System.out.println();
		do {
			Timer.pause();
			game.moveChance();
			p = game.getCurrentPlayer();
			System.out.println("\nCurrent Player: " + p.getName());
			p.play();
		} while (!p.hasWon());
		System.out.println("Game Over!!! " + p.getName() + " Wins.");
	}

	private static int takeInputFromUserForNumberOfPlayers() {
		boolean canStart = false;
		int numOfPlayers = 0;
		do {
			String numOfPlayersInput = JOptionPane.showInputDialog(null, "Please enter the number of players",
					"SnL", JOptionPane.QUESTION_MESSAGE);
			if (numOfPlayersInput == null) {
				System.exit(0);
			}
			try {
				numOfPlayers = Integer.valueOf(numOfPlayersInput);
				if (numOfPlayers < 2) {
					throw new NumberFormatException();
				}
				canStart = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid positive number (>1)", "Error",
						JOptionPane.ERROR_MESSAGE);
				canStart = false;
			}
		} while (!canStart);
		return numOfPlayers;
	}

}
