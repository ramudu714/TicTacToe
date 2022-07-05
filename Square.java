package com.monocept.model;

public class Square {
	private State state;

	public Square() {
		this.state = State.EMPTY;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
