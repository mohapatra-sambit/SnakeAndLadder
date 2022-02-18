package com.snl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

	public static List<String> readAllRulesFromFile(File file) {
		List<String> allLines = new LinkedList<String>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = in.readLine()) != null) {
				if(line.trim().length() > 0) {
					allLines.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File [" + file + "] not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read file [" + file + "].");
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return allLines;
	}

}
