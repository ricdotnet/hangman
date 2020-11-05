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
    
    static String[] words = {"banana", "theory", "speaker", "laptop", "keyboard"}; //array list for words
    
    //create variables
    static boolean finished = false;
    static String word;
    static String character;
    static int wrongGuesses = 1;
    static int correctGuesses = 1;
    
    static int line;
    static int column;
    
    //method to select a word
    public static void getWord(){
        int number = rand.nextInt(4) + 1;
        word = words[number];
    }
    
    //method for the hangman
    public static void hangMan(int line, int column){
        char[][] hangman = {{' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}};
        for(char[] row : hangman){
            for(char c:row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        //hangMan();
        
        getWord();
        System.out.println(word);
        
        System.out.println("The word contains " + word.length() + " characters. \n"
                + "You have 7 tries to guess the word.\n");
        
        System.out.println("Enter a character: ");
        character = input.next();
        
        //start the game
        while(finished == false){
            System.out.println(wrongGuesses);
            if(!word.contains(character)){
                System.out.println("The word does not contain the character '" + character + "'.\n"
                        + "Please enter a new character: ");
                character = input.next();
                wrongGuesses += 1; //add a try to the counter
                
                //if statement to check if the game ended or not yet
                if(wrongGuesses == 7){
                    System.out.println("Game finished. You lost. :(");
                    finished = true;
                }
            }else{
                System.out.println("Nice, there is a " + character + " in the word.\n"
                        + "Enter a new character: ");
                character = input.next();
                correctGuesses += 1;
                
                if(correctGuesses == word.length()){
                    System.out.println("Game finished. You guessed the word. :)\n"
                            + "It was " + word + ".");
                    finished = true;
                }
            }
        }//end while loop
        System.out.println("Thanks for playing.");
        
    }//end main method
    
}//end main class
