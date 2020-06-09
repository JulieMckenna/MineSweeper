import java.util.Scanner;

public class minesweeper {
	
	public static void main(String args[])
	{
		rules();
	}
	
	public static void rules()	
	{
		System.out.print("This is the classic game of minesweeper written in C.\nRules for minesweeper:\n");
		System.out.print("1. You are in a mine field and you have to successfully flag all the places which have a mine. If you flag all the mines, You win!\n");
		System.out.print("2.In your first turn, you have to choose a starting square. You can open a square by entering its row number(x) and column number(y)\n(Note: row and column number starts from 1)\n");           
		System.out.print("3.There are three modes of operation:\n");
		System.out.print("(i) open mode. type 'o' in mode option. This mode lets the user to open a square\n");
		System.out.print("(ii) flag mode. type 'f' in mode option. This mode lets the user to flag a particular square. Flagged square is denoted by an 'F'\n");
		System.out.print("(iii) remove flag mode. type 'r' in mode option. This mode lets the user to remove a particular flag from a flagged square\n");
		System.out.print("4.If you open a square with a mine, you lose\n");
		System.out.print("5.If you open a square with a number written on it. The number shows that how many mines are there in the adjacent 8 squares\n");
	    System.out.print("\nYou will be playing on a 6 by 6 grid and there will be 4 mines hidden on the grid");
	}
		

}
