package ticTac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[] [] gameBoard = {{' ', '|', ' ', '|', ' '}, 
				{ '-','+', '-', '+','-'}, 
				{' ', '|',' ', '|',' '}, 
				{'-', '+', '-', '+','-'}, 
				{' ', '|',' ', '|',' '}};
		
		
		printGameBoard(gameBoard);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		System.out.println("Enter your placement (1-9): ");
		int playerPos = scanner.nextInt();
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
			System.out.println("position taken! Enter a correct position.");
			playerPos =scanner.nextInt();
		}
		
		
		placepeice(gameBoard, playerPos, "player");
		
		String result =  checkWinner();
		if(result.length() > 0) {
			System.out.println(result);
			break;
		}
		
		Random rand = new Random();
		int cpuPos =  rand.nextInt(9) + 1;
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
			cpuPos =  rand.nextInt(9) + 1;
		}
		placepeice(gameBoard, cpuPos, "cpu");
		
		printGameBoard(gameBoard);
		
		
		 result = checkWinner();
		if(result.length() > 0) {
		System.out.println(result);
		break;
		}
	}
		
	}
public static void printGameBoard(char[] [] gameBoard) {
	
	for(char[] row: gameBoard) {
		for(char c: row) {
			System.out.print(c);
		}
		System.out.println();
	}
	
}

public static void placepeice(char[][] gameboard, int pos, String user) {
	
	char symbol = ' ';
	
	if(user.contentEquals("player")) {
		symbol = 'X';
		playerPositions.add(pos);
	}else if(user.equals("cpu")) {
		symbol = 'O';
		cpuPositions.add(pos);
	}
	
	switch (pos) {
	case 1:
		gameboard[0][0] = symbol;
		break;
	case 2:
		gameboard[0][2] = symbol;
		break;
	case 3:
		gameboard[0][4] = symbol;
		break;
	case 4:
		gameboard[2][0] = symbol;
		break;
	case 5:
		gameboard[2][2] = symbol;
		break;
	case 6:
		gameboard[2][4] = symbol;
		break;
	case 7:
		gameboard[4][0] = symbol;
		break;
	case 8:
		gameboard[4][2] = symbol;
		break;
	case 9:
		gameboard[4][4] = symbol;
		break;
		default:
			break;
	}
	
}


public static String checkWinner() {

	List<Integer> topRow = Arrays.asList(1, 2, 3);
	List<Integer> middleRow = Arrays.asList(4, 5, 6);
	List<Integer> bottomRow = Arrays.asList(7, 8, 9);
	List<Integer> leftCol = Arrays.asList(1, 4, 7);
	List<Integer> middleCol = Arrays.asList(2, 5, 8);
	List<Integer> rightCol = Arrays.asList(3, 8, 9);
	List<Integer> cross1 = Arrays.asList(1, 5, 9);
	List<Integer> cross2 = Arrays.asList(7, 5, 3);

	List<List> winningConditions = new ArrayList<List>();

	winningConditions.add(topRow);
	winningConditions.add(middleRow);
	winningConditions.add(bottomRow);
	winningConditions.add(leftCol);
	winningConditions.add(middleCol);
	winningConditions.add(rightCol);
	winningConditions.add(cross1);
	winningConditions.add(cross2);

	
	
	String result = "";
	
	for(List l: winningConditions) {
		if(playerPositions.containsAll(l)) {
			result = "Congratulations you won!";
	}else if(cpuPositions.containsAll(l)) {
		result =  "Sorry, you lost!";
	}else if(playerPositions.size() + cpuPositions.size() == 9) {
		result = "it's a tie!";
	}
	
	
	
}
	return result;
}
}
