package com.monocept.model;

import java.util.Scanner;

public class Board {
	private Square board[][] = new Square[3][3];

	public Board() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = new Square();
	}

	public void playGame() {

		int row, column, turncount = 0;
		boolean result = false, validMove = false;
		Scanner sc1 = new Scanner(System.in);

		while (!result) {
			while (!validMove) {
				System.out.println("Player 'X', enter your move (row[1-3] column[1-3]):");
				row = sc1.nextInt() - 1;
				column = sc1.nextInt() - 1;

				if (board[row][column].getState() == State.EMPTY) {
					board[row][column].setState(State.X);
					validMove = true;
					break;
				}
				System.out.println("This move at (" + (row + 1) + "," + (column + 1) + ")  is not valid. Try again...");
			}
			turncount++;
			printBoard();
			validMove = false;
			result = checkGameComplete();
			if (result == true) {
				System.out.println("Player X won the game");
				sc1.close();
				return;
			}
			if (turncount == 9) {
				System.out.println(" Game is a draw");
				sc1.close();
				return;
			}
			while (!validMove) {
				System.out.println("Player 'O', enter your move (row[1-3] column[1-3]):");
				row = sc1.nextInt() - 1;
				column = sc1.nextInt() - 1;

				if (board[row][column].getState() == State.EMPTY) {
					board[row][column].setState(State.O);
					validMove = true;
					break;
				}
				System.out.println("This move at (" + (row + 1) + "," + (column + 1) + ")  is not valid. Try again...");
			}
			turncount++;
			printBoard();
			validMove = false;
			result = checkGameComplete();
			if (result == true) {
				System.out.println("Player O won the game");
				sc1.close();
				return;
			}
			if (turncount == 9) {
				System.out.println(" Game is a draw");
				sc1.close();
				return;
			}
		}
		sc1.close();
	}

	private boolean checkGameComplete() {
		for (int i = 0; i < 3; i++)
			if ((board[i][0].getState() == board[i][1].getState())
					&& (board[i][1].getState() == board[i][2].getState()))
				if (board[i][0].getState() != State.EMPTY)
					return true;
		for (int i = 0; i < 3; i++)
			if ((board[0][i].getState() == board[1][i].getState())
					&& (board[1][i].getState() == board[2][i].getState()))
				if (board[0][i].getState() != State.EMPTY)
					return true;
		if ((board[0][0].getState() == board[1][1].getState()) && (board[1][1].getState() == board[2][2].getState()))
			if (board[0][0].getState() != State.EMPTY)
				return true;
		if ((board[0][2].getState() == board[1][1].getState()) && (board[1][1].getState() == board[2][0].getState()))
			if (board[0][2].getState() != State.EMPTY)
				return true;
		return false;
	}
	private void printBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getState() == State.X)
					System.out.print("  X |");
				else if (board[i][j].getState() == State.O)
					System.out.print("  O |");
				else
					System.out.print("    |");
			}
			System.out.print("\n --------------\n");
		}
	}
}
