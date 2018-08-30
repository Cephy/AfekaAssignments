package simester1.word_assignment3_final;

import javax.swing.JOptionPane;

public class ch6_q9 {

		public final static int NO_PLAYER = 0;
		public final static char PLAYER_1_SIGN = 'X';
		public final static char PLAYER_2_SIGN = 'O';

		public final static int GAME_STATUS_WINNER_PLAYER_1 = 1;
		public final static int GAME_STATUS_WINNER_PLAYER_2 = 2;
		public final static int GAME_STATUS_TIE = 3;
		public final static int GAME_STATUS_NO_RESULT_YET = 0;

		public static void main(String[] args) {
			boolean playAgain = true;

			do {	
				char[][] board = new char[3][3];
				int res = playGame(board);

				if (res == GAME_STATUS_WINNER_PLAYER_1)
					JOptionPane.showMessageDialog(null, "Player 1 is the winner!\n" + boardToString(board));
				else if (res == GAME_STATUS_WINNER_PLAYER_2)
					JOptionPane.showMessageDialog(null, "Player 2 is the winner!\n" + boardToString(board));
				else
					JOptionPane.showMessageDialog(null, "It's a Tie!\n" + boardToString(board));

				int answer = JOptionPane.showConfirmDialog(null,"Would you like to play again?");
				if (answer == JOptionPane.NO_OPTION)
					playAgain = false;

			} while (playAgain);
		}

		public static int playGame(char[][] board) {
			int currentPlayer = 1;
			boolean isCellFree;
			int row, col, res;

			do {
				isCellFree = false;
				while (!isCellFree) {
					String answer = JOptionPane.showInputDialog(boardToString(board) + "Please enter cordination for player #"
							+ currentPlayer + ": ");
					String[] parts = answer.split(" "); // learn the method split :-)
					row = Integer.parseInt(parts[0]);
					col = Integer.parseInt(parts[1]);

					while (row < 1 || row > board.length || col < 1
							|| col > board.length) {
						answer = JOptionPane.showInputDialog(boardToString(board) + "Invalid row/col (should be between 1-"
								+ board.length + "). Please enter again: ");
						parts = answer.split(" ");
						row = Integer.parseInt(parts[0]);
						col = Integer.parseInt(parts[1]);
					}

					// check if cell is free
					if (board[row - 1][col - 1] != NO_PLAYER) {
						JOptionPane.showMessageDialog(null, "The cell is already taken!\n" + boardToString(board));
						continue;
					}

					// if here, cell is valid...
					// -----------------------------

					// mark cell and switch player
					isCellFree = true;
					if (currentPlayer == 1) {
						board[row - 1][col - 1] = PLAYER_1_SIGN;
						currentPlayer = 2;
					} else {														//To Do (Cephy)
						board[row - 1][col - 1] = PLAYER_2_SIGN;
						currentPlayer = 1;
					}
				}
			} while (checkGameStatus(board) == GAME_STATUS_NO_RESULT_YET);

			res = checkGameStatus(board);
			return res;
		}

		public static int checkGameStatus(char[][] board) {
			int res;

			res = checkIfWinnerInRow(board);
			if (res == GAME_STATUS_WINNER_PLAYER_1
					|| res == GAME_STATUS_WINNER_PLAYER_2)
				return res;

			res = checkIfWinnerInCol(board);
			if (res == GAME_STATUS_WINNER_PLAYER_1
					|| res == GAME_STATUS_WINNER_PLAYER_2)
				return res;													//To Do (Cephy)
			
			res = checkIfWinnerInMainDiagonal(board);						//To Do (Cephy)
			if (res == GAME_STATUS_WINNER_PLAYER_1
					|| res == GAME_STATUS_WINNER_PLAYER_2)
				return res;	
			
			res = checkIfWinnerInSecondaryDiagonal(board);					//To Do (Cephy)
			if (res == GAME_STATUS_WINNER_PLAYER_1
					|| res == GAME_STATUS_WINNER_PLAYER_2)
				return res;	

			// if all cells are taken: TIE, else no result yet..
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j <  board.length; j++)
					if (board[i][j] == NO_PLAYER)
						return GAME_STATUS_NO_RESULT_YET;
			}

			return GAME_STATUS_TIE;
		}

		public static String boardToString(char[][] board) {
			String str = "";
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					str += "  ";
					if (board[i][j] != NO_PLAYER)
						str += board[i][j];
					else
						str += "  ";
					str += "  |";
				}
				str += "\n";
				for (int j = 0; j < board.length; j++)
					str += "____";
				str += "\n";
			}
			return str;
		}

		public static int checkIfWinnerInRow(char[][] board) {
			boolean hasWinnerInCurrentCheck;

			for (int i = 0; i < board.length; i++) {
				hasWinnerInCurrentCheck = true;
				for (int j = 1; j < board.length && hasWinnerInCurrentCheck; j++) {
					if (board[i][j] != board[i][0] || board[i][j] == NO_PLAYER)
						hasWinnerInCurrentCheck = false;
				}

				if (hasWinnerInCurrentCheck) {
					if (board[i][0] == PLAYER_1_SIGN)
						return GAME_STATUS_WINNER_PLAYER_1;
					else
						return GAME_STATUS_WINNER_PLAYER_2;
				}
			}
			return GAME_STATUS_NO_RESULT_YET;
		}

		public static int checkIfWinnerInCol(char[][] board) {
			boolean hasWinnerInCurrentCheck;
			
			for (int columns = 0; columns < board.length; columns++) {
				hasWinnerInCurrentCheck = true;
				for (int rows = 1; rows < board.length && hasWinnerInCurrentCheck; rows++) {
					if (board[rows][columns] != board[0][columns] || board[rows][columns] == NO_PLAYER)
						hasWinnerInCurrentCheck = false;
				}

				if (hasWinnerInCurrentCheck) {
					if (board[0][columns] == PLAYER_1_SIGN)
						return GAME_STATUS_WINNER_PLAYER_1;
					else
						return GAME_STATUS_WINNER_PLAYER_2;
				}
			}
			return GAME_STATUS_NO_RESULT_YET;
		}
		
		public static int checkIfWinnerInMainDiagonal(char[][] board) {
			boolean hasWinnerInCurrentCheck = true;
			
			for (int columns = 1, rows=1 ; columns < board.length && hasWinnerInCurrentCheck ; columns++, rows++) {
					if (board[rows][columns] != board[0][0] || board[rows][columns] == NO_PLAYER)
						hasWinnerInCurrentCheck = false;
			}	
			if (hasWinnerInCurrentCheck) {
				if (board[0][0] == PLAYER_1_SIGN)
					return GAME_STATUS_WINNER_PLAYER_1;
				else
					return GAME_STATUS_WINNER_PLAYER_2;
			}
			return GAME_STATUS_NO_RESULT_YET;
		}

		public static int checkIfWinnerInSecondaryDiagonal(char[][] board) {
			boolean hasWinnerInCurrentCheck = true;
			
			for (int columns = 1, rows=1 ; columns < board.length && hasWinnerInCurrentCheck ; columns++, rows--) {
					if (board[rows][columns] != board[2][0] || board[rows][columns] == NO_PLAYER)
						hasWinnerInCurrentCheck = false;
			}	
			if (hasWinnerInCurrentCheck) {
				if (board[2][0] == PLAYER_1_SIGN)
					return GAME_STATUS_WINNER_PLAYER_1;
				else
					return GAME_STATUS_WINNER_PLAYER_2;
			}
			
			return GAME_STATUS_NO_RESULT_YET;
		}
	}