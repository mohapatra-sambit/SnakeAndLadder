package com.snl.bean;

import java.awt.Color;

import com.snl.rules.Rules;
import com.snl.utils.Timer;

public class Player {
	
	private String name;
	
	private Color color;
	
	private int currentPosition;

	public Player(String name, Color color) {
		super();
		this.name = name;
		this.color = color;
		this.currentPosition = 0;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	public boolean hasWon() {
		return currentPosition == 100;
	}
	
	public void play() {
		Timer.pause();
		System.out.println("Current Position: " + currentPosition);
		Timer.pause();
		System.out.print("Rolling dice...");
		int n = Dice.roll();
		Timer.pause();
		System.out.println(n);
		Timer.pause();
		currentPosition = getNextPosition(n);
		System.out.println("New Position: " + currentPosition);
		Timer.pause();
	}

	private int getNextPosition(int n) {
		int current = currentPosition + n;
		if (current > 100) {
			return currentPosition;
		}
		int end = Rules.getEnd(current);
		if (end == 0) {
			return current;
		}
		return end;
	}
	
}
