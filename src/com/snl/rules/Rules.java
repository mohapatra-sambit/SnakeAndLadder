package com.snl.rules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.snl.enm.ElementType;
import com.snl.utils.FileUtils;
import com.snl.utils.Timer;

public class Rules {

	private static List<Element> rulesList;
	
	public static void load() {
		rulesList = new ArrayList<Element>();
		List<String> allRules = FileUtils.readAllRulesFromFile(new File("rules/rules.txt"));
		loadRules(allRules);
	}

	private static void loadRules(List<String> allRules) {
		if (allRules.isEmpty()) {
			System.out.println("No Rules Found!");
			System.exit(0);
		}
		for (String rule : allRules) {
			String[] items = rule.split(",");
			if (items.length == 2) {
				try {
					int start = Integer.valueOf(items[0]);
					int end = Integer.valueOf(items[1]);
					ElementType type = null;
					if (!isRuleOK(start, end)) {
						System.out.println("Ignoring invalid rule [Rule Not OK]: " + rule);
						Timer.pause();
						continue;
					}
					if (start > end) {
						type = ElementType.SNAKE;
					} else {
						type = ElementType.LADDER;
					}
					Element e = new Element();
					e.setStart(start);
					e.setEnd(end);
					e.setType(type);
					rulesList.add(e);
				} catch (NumberFormatException e) {
					System.out.println("Ignoring invalid rule [Rule not a number]: " + rule);
					Timer.pause();
					continue;
				}
			} else {
				System.out.println("Ignoring invalid rule [Rule entry must have 2 nos.]: " + rule);
				Timer.pause();
				continue;
			}
		}
	}

	private static boolean isRuleOK(int start, int end) {
		if (start < 1 || end < 1 || start >= 100 || end > 100) {
			return false;
		}
		return true;
	}
	
	public static int getEnd(int start) {
		for (Element e : rulesList) {
			if (e.getStart() == start) {
				System.out.println(e.getType().name() + "!!!");
				Timer.pause();
				return e.getEnd();
			}
		}
		return 0;
	}
	
}
