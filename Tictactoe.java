import java.util.Scanner;
class Tictactoe
{ 
	////////////////////////////////////////////////////////////////////////////fill multi array with a character spaces
	public static void initializeBoard(char [][]array) 
	{
	int row;
	int col;
	
		for(row = 0; row < array.length; row++)
		{
			for(col = 0; col < array[row].length; col++)
			{
				array[row][col] = ' ';	
			}	
		}	
	}
	////////////////////////////////////////////////////////////////////////////check win
	public static boolean checkWin(char[][] win,char p1,char p2)   
	{
	int rowCol;
	boolean winner;
	winner = false;
	for(rowCol = 0; rowCol < 3; rowCol++) 
		{
		if(win[rowCol][0] == p1 && win[rowCol][1] == p1 && win[rowCol][2] == p1) // row win 
			{
				System.out.print("Player 1 wins\n");			
				winner = true;	
			}
		else if(win[rowCol][0] == p2 && win[rowCol][1] == p2 && win[rowCol][2] == p2) // row win
			{ 
				System.out.print("Player 2 wins\n");		
				winner = true;
			}
		if(win[0][rowCol] == p1 && win[1][rowCol] == p1 && win[2][rowCol] == p1) // col win
			{ 
				winner = true;
				System.out.print("Player 1 wins\n");			
			}
		else if(win[0][rowCol] == p2 && win[1][rowCol] == p2 && win[2][rowCol] == p2) // col win
			{
				winner = true;
				System.out.print("Player 2 wins\n");			
			}
		}	
	if(win[0][0] == p1 && win[1][1] == p1 && win[2][2] == p1) //Diag
		{
			winner = true;
			System.out.print("Player 1 wins\n");			
		}
	else if(win[0][0] == p2 && win[1][1] == p2 && win[2][2] == p2) //Diag
		{
			winner = true;
			System.out.print("Player 2 wins\n");			
		}
	if(win[0][2] == p1 && win[1][1] == p1 && win[2][0] == p1) //Diag
		{
			winner = true;
			System.out.print("Player 1 wins\n");				
		}
	else if(win[0][2] == p2 && win[1][1] == p2 && win[2][0] == p2) //Diag
		{
			winner = true;
			System.out.print("Player 2 wins\n");
		}
	return winner;
	} 
	////////////////////////////////////////////////////////////////////////////draw 3*3 x o board
	public static void drawBoard(char[][] board) 
	{ 
	int innerIndex;
	int outerIndex;	
    System.out.println("-------------");
	for (outerIndex = 0; outerIndex < 3; outerIndex++) 
	    {
	    System.out.print("| ");
		for (innerIndex = 0; innerIndex < 3; innerIndex++) 
			{
				System.out.print(board[outerIndex][innerIndex] + " | ");
			}
		System.out.println();
		System.out.println("-------------");
    	} 
	}
	////////////////////////////////////////////////////////////////////////////player 1 turn
	public static int changePlayer1(char p1,char array[][],int plyGame)
	{
	Scanner input = new Scanner(System.in);
	int rowNum;
	int colNum;
	int row;
	int col;
	rowNum = -1;
	colNum = -1;
		
		try
		{
			System.out.print("\nPlayer 1 choose a postion to put " + p1 + "\n");	
			System.out.print("Board layout\n[0,0|0,1|0,2]\n[1,0|1,1|1,2]\n[2,0|2,1|2,2]\n");
				
			System.out.print("Enter the first number to place your character on the board and press enter -> "); 
			rowNum = input.nextInt();
						
			System.out.print("Enter the second number to place your character on the board and press enter-> ");
			colNum = input.nextInt();	
			System.out.println("\n>>>PLAYER 1 TURN<<<");
		}
		catch(Exception e)
		{
			System.out.println("\n\t\t\t<<<YOU DIDN'T PICK A NUMBER PLAYER 1>>>");
		}
	
	for(row = 0;row < array.length; row++)
		{
		for(col = 0;col < array[row].length; col++)
			{
			if(rowNum == row && colNum == col)
				{
				if(array[row][col] == ' ')
					{
						array[row][col] = p1;	
						plyGame++; // if postion not filled update game	
					}
				}	
			}
		}
	return plyGame;
	}
	////////////////////////////////////////////////////////////////////////////player2 turn
	public static int changePlayer2(char p2,char array[][],int plyGame)
	{
	Scanner input = new Scanner(System.in);
	int rowNum;
	int colNum;
	int row;
	int col;
	rowNum = -1;
	colNum = -1;
	try
	{
		System.out.print("\nPlayer 2 choose a postion to put " + p2 +"\n");	
		System.out.print("Board layout\n[0,0|0,1|0,2]\n[1,0|1,1|1,2]\n[2,0|2,1|2,2]\n");
		
		System.out.print("Enter the first number to place your character on the board and press enter-> ");
		rowNum = input.nextInt();
		
		System.out.print("Enter the second number to place your character on the board and press enter-> ");
		colNum = input.nextInt();
		System.out.println("\n>>>PLAYER 2 TURN<<<");
	}
	catch(Exception e)
	{
		System.out.println("\n\t\t\t<<<YOU DIDN'T PICK A NUMBER PLAYER 2>>>"); 		
	}
	for(row = 0;row < array.length; row++)
		{
		for(col = 0;col < array[row].length; col++)
			{
			if(rowNum == row && colNum == col)
				{
				if(array[row][col] == ' ')
					{		
						array[row][col] = p2; 	
						plyGame++; // if postion not filled update game		
					}
				}	
			}
		}
	return plyGame;
	}
	///////////////////////////////////////////////////////////////cpu turn
	public static int cpuTurn(char p2,char array[][],int plyGame)
	{
	Scanner input = new Scanner(System.in);
	int rowNum;
	int colNum;
	int row;
	int col;
	boolean turn;
	turn = false;
	System.out.print(">>>COMPUTERS TURN<<<\n");
	while(turn == false)
		{
		rowNum = (int)(Math.random()*3);
		colNum = (int)(Math.random()*3);
		
		for(row = 0;row < array.length; row++)
			{
			for(col = 0;col < array[row].length; col++)
				{
				if(rowNum == row && colNum == col)
					{
					if(array[row][col] == ' ') 
						{		
							array[row][col] = p2; 	
							plyGame++;		
							turn = true; // break loop when postion found
						}
					}	
				}
			}
		}
	return plyGame;
	}
	////////////////////////////////////////////////////////////////////////////Game
	public static void playGame(char arrayBoard[][],char p1,char p2,boolean cpu)
	{
	int game;
	int checkGame;
	boolean tf;
	boolean holdTf;
	game = 0;
	checkGame = -1;
	tf = true;
	holdTf = false;
		System.out.print(">>>>YOU MUST CHOOSE TWO NUMBERS ONE AT A TIME AND PRESS ENTER AFTER EACH NUMBER TO PUT YOUR X OR O ON THE BOARD<<<<\n");
		while(game < 9) // play game
			{
			checkGame = game;
			if(tf == true)
				{
					game = changePlayer1(p1,arrayBoard,game);	
				}	
			else if(tf == false)
				{
				if(cpu == true)
					{
						game =  cpuTurn(p2,arrayBoard,game);		
					}
				else
					{
						game = changePlayer2(p2,arrayBoard,game);	
					}		
				}
		if(checkGame == game)// reset player turn if place picked is taken
			{
				tf = !tf;	
				System.out.print(">>>>THE POSTION IS FILLED CHOOSE ANOTHER OR YOU DIDN'T PICK FROM 0 <--> 2<<<<\n\n");
			}
		else
			{
				checkGame = game;	
			}
		
		drawBoard(arrayBoard);
	
		if(holdTf = checkWin(arrayBoard,p1,p2) == true)
			{
				game = 9;
			}
		tf = !tf; // switch players
		}// end of while 
	if(game == 9 && holdTf == false) // game is over and no winner found
		{
			System.out.print("Game is a draw\n");
		}
	System.out.print("Thanks for playing\n");
	}
	////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	final int BOARDSIZE = 3;
	char[][] board = new char[BOARDSIZE][BOARDSIZE];	
	char player1;
	char player2;	
	boolean tf;
	boolean cpu;
	int option;
	option = 0;
	cpu = false;
	tf = false;
	player2 = ' ';
		
		while(tf == false) // loop if you don't pick x or o
		{
			System.out.print("Player 1 -> Choose [x] or [o] -> "); 
			player1 = input.next().charAt(0);
		
			if(player1 == 'x' || player1 == 'X')
			{
				player1 = 'x';
				System.out.print("Player 2 is [o]\n\n");
				player2 = 'o';
			}
			else if(player1 == 'o' || player1 == 'O')
			{
				player1 = 'o';
				System.out.print("Player 2 is [x]\n\n");
				player2 = 'x';
			}
		initializeBoard(board);
			
			if(player1 == 'x' || player1 == 'o')
			{
				tf = true;
				while(option < 1 || option > 2)
				{
				System.out.print("Enter 1 to play against the computer or enter 2 to play against a buddy -> ");  
				option = input.nextInt();
				System.out.println();
				switch(option)
					{
					case 1:
						cpu = true;
						break;
					case 2:
						cpu	= false;
						break;
					default:
					if(option < 1 || option > 2)
						{
							System.out.print("Only enter 1 or 2\n");
						}
					}
				}
				playGame(board,player1,player2,cpu);	
			}
			else
			{
				System.out.print("You didn't choose x or o\n");
			}
		}
	}
}