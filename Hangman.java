import java.util.Scanner; 
class Hangman
{
	public static void hangMan(int wrongChar,String name)//hangman if char entered is wrong
	{
	
	 switch(wrongChar)
	 	{
	 		case 1:
	 		System.out.print("---------\n");
	 		System.out.print("|\tO");	  
	 		break;
	 		case 2:
	 		System.out.print("---------\n");
	 		System.out.print("|\tO");	
	 		System.out.print("\n|\t|");
	 		break;
	 		case 3:
	 		System.out.print("---------\n");
	 		System.out.print("|\tO");	
	 		System.out.print("\n|\t|\\" );
	 		break;
	 		case 4:
	 		System.out.print("---------\n");
	 		System.out.print( "|\t O");	
	 		System.out.print("\n|\t/|\\");
	 		break;
	 		case 5:
	 		System.out.print("---------\n");
	 		System.out.print( "|\t O");	
	 		System.out.print("\n|\t/|\\");
	 		System.out.print("\n|\t  \\");
	 		break;
	 		case 6:
	 		System.out.print("---------\n");
	 		System.out.print( "|\t O");	
	 		System.out.print("\n|\t/|\\");
	 		System.out.print("\n|\t/ \\");
	 		System.out.print("\nSorry you lose\nThe word was ------> " + name+"\nThanks for playing\n");
	 		break;
	 	}
	}
	public static void hideWord(String selectedWord,char[]fill) //Hide word with *																		
	{    															
	int index;
	for(index = 0; index < selectedWord.length();index++) 
		{
			fill[index] = '*';
			if(selectedWord.charAt(index) == ' ')
				{
					fill[index] = ' ';
				}
		}	
	}
	public static int checkChar(String selectedWord,char selectedChar,int num)// if char is not in word hangman
	{
	int index;
	boolean tf;
	tf = false;
	
	for(index = 0; index < selectedWord.length();index++) 
		{
		if(selectedWord.charAt(index) == selectedChar)//check if char entered is in hidden word
			{ 	
				tf = true;
			}
		}	 
		if(tf == false)//if char is not in word
			{
				num++;
				hangMan(num,selectedWord);		
			}		
	return num;
	}
	public static String fillArray(String selectedWord,char selectedChar,char[]fill,String holdChars)// fill array if gussed char is correct
	{
	int index;
	for(index = 0; index < selectedWord.length();index++) 
		{
		if(selectedWord.charAt(index) == selectedChar)
			{ 
				fill[index] = selectedChar;// enters correct char into right place in word
				holdChars = holdChars + selectedChar;//Adds correct char to a string to check for a win	
			}
		}	 
	System.out.println(fill);
	return holdChars;
	}
	public static String randomWord(int chosenWord) // user selected word
	{
	String words[] = {"horse","shamrock","computer","goose","dinelli"};	 
	int index;
	String selectedWord;
	selectedWord = "";
	for (index = 0; index <= words.length; index++) 
		{
	    if(chosenWord == index)
	    	{
		    	selectedWord = words[index];					
	    	}		 
		}	
	return selectedWord; 
	}
	public static boolean checkRepeatChars(char checkChar,String heldChars) //  stops repeat charcters from being entered
	{
	int index;
	boolean tf;
	tf = true;
	for(index = 0; index < heldChars.length();index++)
		{
		if(checkChar != heldChars.charAt(index))//if character gussed was not entered already continue
			{
				tf = true;
			}	
		else
			{	
				tf = false;
				System.out.print("You have already entered that character");//character was already gussed
			}
		}	
	return tf;
	}
	public static void playGame(String selectedWord,char[]correctChars)// play game 
	{
	Scanner input = new Scanner(System.in);
	char guessChar;	
	int game;
	int index;
	int holdCount;   
	String holdWord;
	final int CHANCES = 15;  
	holdCount = 0;
	holdWord = "";
	game = 1;
	guessChar = '2';
	hideWord(selectedWord,correctChars); 
	System.out.print("This is the length of the word you have to guess\n"); 
	System.out.print(correctChars);
	System.out.println();
	System.out.print("When you guess correctly a star will be replaced with that character\nFill in all stars to win\nMake six wrong guesses and you lose :(");
	while(game < CHANCES) 
		{
		System.out.print("\nGuess a character-> ");
		guessChar = input.next().charAt(0);// choose char to guess	
		
		if(checkRepeatChars(guessChar,holdWord) == true)//Stops repeat correct characters
			{
			holdWord = fillArray(selectedWord,guessChar,correctChars,holdWord);//Enters gussed character into word if gussed correct															
			holdCount = checkChar(selectedWord,guessChar,holdCount);//Keeps track of wrong characters entered 
			
			if(holdWord.length() == selectedWord.length())//Win
				{
					System.out.print("You win!!!\nThanks for playing\n");		
					game = CHANCES;
				}
			game++;		
			if(holdCount == 6)//Game over
				{
					game = CHANCES;	
				}
			}
		}		
	}
	public static void main(String[] args)  
	{ 
	Scanner input = new Scanner(System.in);
	int chooseWord;
	String selectedWord;
	char[] correctChars; 
	selectedWord = "";
	chooseWord = -1;	
	while(chooseWord < 0 || chooseWord > 4)
		{
		try
			{
				System.out.print("Choose a number between 0 - 4 to pick a random word to guess-> ");// choose word
				chooseWord = input.nextInt();
			}
		catch(Exception e)
			{
				System.out.print(">>>You didn't pick a number<<<\n");	
				String s = input.next(); // resets scanner	
			}	
		if(chooseWord == 0 || chooseWord == 1 || chooseWord == 2 || chooseWord == 3 || chooseWord == 4)
			{
			selectedWord = randomWord(chooseWord);// return chosen word
			correctChars = new char[selectedWord.length()]; // char array same length as char array
			playGame(selectedWord,correctChars);	
			}
		else
			{
				System.out.print(">>>Only choose 0-4<<<\n");	
			}
		}	
	}	
}