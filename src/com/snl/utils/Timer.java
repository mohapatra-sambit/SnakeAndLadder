package com.snl.utils;

public class Timer {
	
	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}
