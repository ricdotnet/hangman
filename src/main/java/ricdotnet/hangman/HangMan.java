/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricdotnet.hangman;

import java.util.*; //import dependencies
/**
 *
 * @author Ricardo Rocha
 */
public class HangMan {
    
    static Scanner input = new Scanner(System.in); //scanner for user inputs
    static Random rand = new Random(); //random number generator
    
    static String[] words = {"banana", "ananas", "adriana", "hippopotamus", "national"}; //array list for words
    
    //create variables
    static boolean finished = false;
    static String word;
    static String character;
    static int wrongGuesses = 0;
    static int correctGuesses = 0;
    static int selwordchar = 0;
    
    static char[][] hangman = {{'-','-','-','-','-'},
            {'|',' ',' ',' ','|'},
            {'|',' ',' ',' ','|'},
            {'|',' ',' ',' ','|'},
            {'|',' ',' ',' ','|'},
            {'-','-','-','-','-'}};
    
    static int line;
    static int column;
    
    //method to select a word
    public static void getWord(){
        int number = rand.nextInt(4) + 1;
        word = words[number];
        //String str1 = new String(word);
    }
    
    //method for the hangman
    public static void hangMan(int wrongGuess){
        
        if(wrongGuess == 1){
            hangman[1][2] = 'O';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 2){
            hangman[2][2] = '|';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 3){
            hangman[3][2] = '|';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 4){
            hangman[4][1] = '/';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 5){
            hangman[4][3] = '\\';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 6){
            hangman[2][1] = '/';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else if(wrongGuesses == 7){
            hangman[2][3] = '\\';
            for(char[] row : hangman){
                for(char line : row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }else{
            for(char[] row : hangman){
                for(char line:row){
                    System.out.print(line);
                }
                System.out.println();
            }
        }
    }
    
    /*public static void repeatingChars(int x){
        for(int i = 0; i < word.length(); i++){
            
        }
    }*/
    
    public static void checkWinner(int correctGuesses){
        //if statement to check if the game ended or not yet
        if(correctGuesses == word.length()-1){
            System.out.println("Game finished. You guessed the word. :)\n"
                + "It was " + word + ".\n");
                finished = true;
        }
    }
    
    public static void main(String[] args){
        //hangMan();
        
        getWord();
        System.out.println(word);
        
        String selword[] = new String[word.length()]; //create an array with the length of the word
        Arrays.fill(selword, "*");
        
        //show the user underscore for each character
        for(int i = 0; i < word.length(); i++){
            System.out.print(selword[i]);
        }
        System.out.println("\n"); //print next line
        
        hangMan(wrongGuesses); //show the hangman space
        
        //give a hint to the user
        System.out.println("The word contains " + word.length() + " characters. \n"
                + "You have 7 tries to guess the word.\n");
        
        System.out.println("Enter a character: ");
        character = input.next();
        
        //start the game
        while(finished == false){
            
            //System.out.println(wrongGuesses);
            if(!word.contains(character)){
                wrongGuesses += 1; //add a wrong try to the counter
                System.out.println("The word does not contain the character '" + character + "'.\n"
                        + "A piece was added to your hanging man.\n");
                
                hangMan(wrongGuesses); //show the hanging man
                //if statement to check if the game ended or not yet
                if(wrongGuesses == 7){
                    System.out.println("Game finished. You lost. :(");
                    finished = true;
                }else{
                    //if there are not 7 wrong guesses ask again
                    System.out.println("Please enter a new character: ");
                    character = input.next();
                }
                
            }else{
                //System.out.println("You have " + correctGuesses);
                if(Arrays.asList(selword).contains(character)){
                    System.out.println("You already entered this. \n"
                            + "Enter a new character: ");
                    character = input.next();
                }else{
                    //selword[selwordchar] = character; //add valid character to the list
                
                    //for loop to replace each * with the chosen character
                    for(int i = 0; i < word.length(); i++){
                        if(character.equals(String.valueOf(word.charAt(i)))){
                            selword[i] = character;
                            correctGuesses += 1;
                            //replace the space and add 1 correct guess
                        }
                        //System.out.println(word.charAt(i));
                    }
                    System.out.println();
                    
                    //System.out.println("Index of " + character + " in word: "+word.indexOf(character));
                    
                    //pring the word with the hints
                    for(int i = 0; i < word.length(); i++){
                        System.out.print(selword[i]);
                    }
                    System.out.println();
                
                    System.out.println("Nice, the word contains one or more '" + character + "'.\n");
                    System.out.printf("\nYou have now %d correct characters.\n\n", correctGuesses); //show the user how many correct guesses they have
                    
                    System.out.println("Enter a new character: ");
                    character = input.next();
                    //correctGuesses += 1; //add 1 correct guess
                    //selwordchar += 1; //select the next character on the hidden word
                    checkWinner(correctGuesses);
                }
            }
        }//end while loop
        System.out.println("Thanks for playing.");
        
    }//end main method
    
}//end main class