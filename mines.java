//Mine Sweeper rendition
//Julie McKenna
//extra project

import java.util.Random;
import java.util.Scanner;

public class mines {
	static int moves;
	static int x;
	static int y;
	static int size = 4;
	static int mines = 4;
	static int totalmoves;
	static boolean gameover = false;
	static Scanner s = new Scanner(System.in);
	
public static void main (String args[])
{
	    rules();
	    diff();
		play();
	    
}

public static void rules()	
{
	System.out.print("This is the classic game of minesweeper. \nRules for minesweeper:\n");
	System.out.print("1. You are in a mine field and you have to successfully avoid all the places which have a mine. If you avoid all the mines, You win!\n");
	System.out.print("2.In your first turn, you have to choose a starting square. "
			+ "\nYou can open a square by entering its row number(x) and column number(y)"
			+ "\n(Note: row and column number starts from 1)\n");           
	System.out.print("4.If you open a square with a mine, you lose\n");
	System.out.print("5.If you open a square with a number written on it. The number shows that how many mines are there in the adjacent 8 squares\n");
	System.out.println();
}

static void diff()
{
	System.out.println("Pick your difficulty:"
			+ "\nEasy: 4x4 grid 4 mines(0)"
			+ "\nMedium: 6x6 grid, 9 mines(1)"
			+ "\nHard: 8x8 grid, 16 mines(2)\n");
	int diff = s.nextInt();
	if(diff == 0)
	{
		mines = 4;
		size = 4;
	}
	if(diff == 1)
	{
		mines = 9;
		size = 6;
	}
	if(diff == 2)
	{
		mines = 16;
		size = 8;
	}
	totalmoves = (size*size)-mines;
}

public static boolean isValid(int x, int y)
{
   if (x >= 0 && y >= 0 && x < size && y < size)
   return true;
   else
   return false;
}
static boolean isMine(int x, int y, char board[][])
{
    if (board[x][y] == '*')
    	return true;	
    else
    	return false;
} 
static void getMove() 
{
	
	System.out.println("Please enter your move(row)");
	x = s.nextInt();
	System.out.println("Please enter your move(col)");
	y = s.nextInt();
	if( x < 0 || x > 4 || y < 0 || y > 4)
	{
		System.out.println("Error:invalid move");
		getMove();
	}

}

static void printBoard(char myBoard[][])
{
	int i, j;
	System.out.print(" ");
	for (i=0; i<size; i++)
		System.out.print(i);
			
	System.out.println();
			
	for( i = 0; i <size; i++)
	{
		System.out.print(i);	
		for (j=0; j<size; j++)
			System.out.print(myBoard[i][j]);
		System.out.println();
	}
}
			
// A Function to count the number of
// mines in the adjacent cells
static char countAdjacentmines(int row, int col, 
	                      char realBoard[][])
{
    int count = 0;
	 
    /*Count all the mines in the 8 adjacent cells
	 
	            N.W   N   N.E
	              \   |   /
	               \  |  /
	            W----Cell----E
	                 / | \
	               /   |  \
	            S.W    S   S.E
	 
	        Cell-->Current Cell (row, col)
	        N -->  North        (row-1, col)
	        S -->  South        (row+1, col)
	        E -->  East         (row, col+1)
	        W -->  West            (row, col-1)
	        N.E--> North-East   (row-1, col+1)
	        N.W--> North-West   (row-1, col-1)
	        S.E--> South-East   (row+1, col+1)
	        S.W--> South-West   (row+1, col-1)
	    */
	 
	 //North
    //check if move is valid first
    if (isValid (row-1, col) == true)
	{
    	if (isMine (row-1, col, realBoard) == true)
    		count++;
	}
    //South
    // check if valid
	 if (isValid (row+1, col) == true)
	 {
		 if (isMine (row+1, col, realBoard) == true)
	               count++;
	  }
	 
	 //East
	 //make sure valid
	 if(isValid(row,col+1) == true)
	 {
		 if(isMine(row,col+1, realBoard) == true)
			 count++;
	 }
	// 4th, west 
	 if(isValid(row,col-1) == true)
	 {
		 if(isMine(row,col-1, realBoard) == true)
			 count++;
	 }
	 
	  //5th North-east
	 if(isValid(row-1,col+1) == true)
	 {
		 if(isMine(row-1,col+1, realBoard) == true)
			 count++;
	 }
	 
	 //north west
	 if(isValid(row-1,col-1) == true)
	 {
		 if(isMine(row-1,col-1, realBoard) == true)
			 count++;
	 }
	//south-west 
	 if(isValid(row+1,col+1) == true)
	 {
		 if(isMine(row+1,col+1, realBoard) == true)
			 count++;
	 }
	//south west
	 if(isValid(row+1,col-1) == true)
	 {
		 if(isMine(row+1,col-1, realBoard) == true)
			 count++;
	 }
	int a = 0;
	switch(count)
	{
		case 1: a = '1';
		break;
		case 0: a = '0';
		break;
		case 2: a = '2';
		break;
		case 3: a = '3';
		break;
		case 4: a = '4';
		break;
		case 5: a = '5';
		break;
		case 6: a = '6';
		break;
		case 7: a = '7';
		break;
		case 8: a = '8';
		break;
	}
	char b = (char)a;
	if(isMine(x,y,realBoard)== true)
		b = '*';
	return (b);
}

static void placemines( char realBoard[][])
{
	
	Random rand = new Random();
	int minecount = 0;
	while(minecount < mines)
	{
		int ranx = (int)(rand.nextDouble()*size);
		int rany = (int)(rand.nextDouble()*size);
		
		if(realBoard[ranx][rany] == '*')
			continue;
		else
		{
			realBoard[ranx][rany] = '*';
			minecount++;
		}
			
	}
	
}
		
static void cheat(char realBoard[][])
{
	System.out.println("The mines are located at: ");
	printBoard(realBoard);
}

//replace the mine in (row, col) if the first move lands on 
//a mine, and move it to a vacant space
static void replaceMine (int row, int col, char board[][])
{

	for (int i=0; i<size;i++)
	{
		for(int j = 0; j < size; j++)
				{
					if (board[i][j] != '*')
					{
						board[i][j] = '*';
						board[row][col] = '-';
						return;
					}
				}
	}

}

static void startGame(char realBoard[][], char myBoard[][])
{			
	for(int i =0; i< size; i++)
	{
		for (int j =0; j< size; j++)
		{
			myBoard[i][j] = realBoard[i][j] = '-';
		}
	}
}
		
		
static void play()
{
	//make boards
	char[][] realBoard = new char[size][size];
	char[][] myBoard = new char[size][size];
			
	
	//starts the game
	startGame(realBoard, myBoard);
			
	//places mines
	placemines(realBoard);
	
	//shows where the mines are 
	//cheat(realBoard);
	
	System.out.println("The current state of the board:");
	printBoard(myBoard);
	
	
	
	moves = 0;
	while (gameover == false)
		
	{	
		//System.out.println("The current state of the board:");
		//printBoard(myBoard);
		getMove();
				
		//if the first move in the game
		if (moves == 0)
		{
			//first move is always safe, checks to see if there
			//is a mine at the location of the move
			if(isMine(x,y, realBoard))
			{
				//if there is a mine move the mine
				replaceMine(x,y, realBoard);
			}
			moves++;
		}
		
		if(isMine(x,y, realBoard) == true)
		{
			myBoard[x][y] = '*';
			System.out.println("\nGame over");
			gameover = true;
			System.out.print("The actual baord was:\n");
			
			printBoard(realBoard);

			
		}
		int nummines = countAdjacentmines(x, y, realBoard);
		myBoard[x][y] = (char)nummines;
		
		if(gameover == false)
		{
			System.out.print("The current board\n");
			printBoard(myBoard);
		}
			
		
		moves++;
		if (moves ==12)
			gameover = true;
		
				
		if(gameover == true && isMine(x,y,realBoard) == false)
				System.out.println("You won!");
	}
		
}

}

