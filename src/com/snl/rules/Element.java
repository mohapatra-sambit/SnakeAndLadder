package com.snl.rules;

import com.snl.enm.ElementType;

public class Element {
	
	private ElementType type;
	
	private int start;
	
	private int end;

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
