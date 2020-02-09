import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
public static void main(String[] args) {
		
		char[] [] gameBoard = {{' ',' ', '|',' ', ' ', '|',' ', ' '}, 
				{'-', '-','+', '-','-', '+', '-','-'}, 
				{' ',' ', '|', ' ',' ', '|', ' ',' '}, 
				{'-','-', '+', '-','-', '+', '-','-'}, 
				{' ',' ', '|', ' ',' ', '|', ' ',' '}};
		
		
		printGameBoard(gameBoard);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your placement (1-9): ");
		int playerPos = scanner.nextInt();
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
			System.out.println("position taken! Enter a correct position.");
			playerPos =scanner.nextInt();
		}
		
		System.out.println(pos);
		
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
		gameBoard[0][0] = symbol;
		break;
	case 2:
		gameBoard[0][3] = symbol;
		break;
	case 3:
		gameBoard[0][6] = symbol;
		break;
	case 4:
		gameBoard[2][0] = symbol;
		break;
	case 5:
		gameBoard[2][3] = symbol;
		break;
	case 6:
		gameBoard[2][6] = symbol;
		break;
	case 7:
		gameBoard[4][0] = symbol;
		break;
	case 8:
		gameBoard[4][3] = symbol;
		break;
	case 9:
		gameBoard[4][6] = symbol;
		break;
		default:
			break;
	}
	
}

public static String checkWinner() {
	
	List topRowList = Array.asList(1, 2, 3);
	List middleRow = Array.asList(4, 5, 6);
	List bottomRow = Array.asList(7, 8, 9);
	List leftCol = Array.asList(1, 4, 7);
	List middleCol = Array.asList(2, 5, 8);
	List rightCol = Array.asList(3, 8, 9);
	List cross1 = Array.asList(1, 5, 9);
	List cross2 = Array.asList(7, 5, 3);
	
	List<List> winningConditions = new ArrayList<List>();

	winningConditions.add(topRow);
	winningConditions.add(middleRow);
	winningConditions.add(bottomRow);
	winningConditions.add(leftCol);
	winningConditions.add(middleCol);
	winningConditions.add(rightCol);
	winningConditions.add(cross1);
	winningConditions.add(cross2);
	
	for(List l: winningConditions) {
		String result = "it's a tie!";
		if(playerPositions.containsAll(l))
			result = "Congratulations you won!";
	}else if(cpuPositions.containsAll(l)) {
		result =  "Sorry, you lost!";
	}else if(playerPositions.size() + cpuPositions.size() == 9) {
		result = "it's a tie!"
	}
	
	
	return result;
}


}
