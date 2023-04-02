

import java.util.*;


public class GameSetup {
    
    //created a scanner object to be used through out the whole class
    static Scanner enter = new Scanner(System.in);
    //made the alphabet array available to all methods in the class
    static String Alphabet = (" a b c d e f g h i j k l m n o p q r s t u v w x y z");
    private static int playerNumber = 1;
    private static String currentPlayer;
    private static String choice;
    
    private static String selectedLetters = "";//stores letters entered
    private static boolean updateAlphabet = true;//variable to be used to update alphabet
    
    //declaring variables for the player score
    private static int player1Score = 0;
    private static int player2Score = 0;

    public void WordWars(String name, String name2){
        
        System.out.println("\n"+"Let's play the Word Wars!!"); //welcome message to players
        System.out.println("Alphabet letters left: "+ Alphabet);//displays alphabets
        while(!"xxx".equals(choice)){//loops game until player quits  (tutorialspoint.com, 2020).
        startGame(name, name2);//calling for the game to start
        }
        //calling the method that will display final scores
        FinalScores(name , name2);
    }
    private static void startGame(String player1, String player2){
        
        currentPlayer(player1, player2);//method to determine current player
        System.out.println("\nIf you choose to quit, enter xxx");//tells the user to use xxx to escape game
        
        System.out.println("\n"+currentPlayer+" ,Enter the word ");//will choose which player it is that will play
        choice = enter.next();//user will enter the word
     
        //method to validate the choice of words for the players
        validateChoice(player1, player2);
        
        
        System.out.println("\n"+"These are the remaing letter: "+ updateAlphabets()+"\n");//displays new changes in alphabet
        
        
    }
     private static String updateAlphabets() {
        //for loop to loop through the alphabet list
        if (updateAlphabet == true){
        for (int i = 0; i < Alphabet.toCharArray().length; i++){ //for loops loop for specified number of times(tutorialspoint.com, 2020).
                //get used letters
                if (choice.contains( (Alphabet.toCharArray()[i]+"") ))
                {
                    selectedLetters = (Alphabet.toCharArray()[i]+"");
                    Alphabet = Alphabet.replace((Alphabet.toCharArray()[i]+""), "_");
                }
            }
        }else{
            System.out.print("\nSorry, the word choice has Used letters or is not valid!");//tells the user that the letters were used before or invalid
            updateAlphabet = true;
        }
        return Alphabet;
    }
    //this method will determine current player
    private static void currentPlayer(String name, String name2) {
        if (playerNumber == 1){
            currentPlayer = name;//player one will be picked
            playerNumber += 1;//after startgame loops player number will increase and wiil not match condition
        }else{
            currentPlayer = name2;//therefore code under else is read, which means player 2 is picked
            playerNumber -= 1;
        }
    }
    //method to prevent vowels from being eliminated
    private static void trimVowels() {
        String vowels = "a e i o u";// storing vowels
        
        for(int i = 0; i< choice.toCharArray().length;++i){
            if(vowels.contains(choice.toCharArray()[i]+"")){
                choice = choice.replace((choice.toCharArray()[i]+""), "");
            }
        }
    }
    //method that validates the choice of words
    private static void validateChoice(String name, String name2) {
        System.out.println("Enter y (yes) if both players agree on the word");
        String yesNo = enter.next();
        
        if (yesNo.equalsIgnoreCase("Y")){
            //method that will identify used words
            usedLetterSearch();
            //method that keeps vowels from being used
            trimVowels();
            //calling the method that will determine final scores
            DetermineFinalScore(name,name2);
            
        }
        else{
            choice = "";//clears choice if word is not agreed with
        }
    }
    private static void usedLetterSearch() {
        //loop created to loop through the used letters
        for(int i = 0; i < selectedLetters.toCharArray().length; ++i){
            // if played word contains the used letters
            if (choice.contains((selectedLetters.toCharArray()[i]+"") )){
                updateAlphabet = false;//prevent changing the alphabet
            }
        }
    }
    //method that will display final scores
    private void FinalScores(String name, String name2) {
        System.out.println("Here are the final Scores...");// messaage for final Scores
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");//border
        System.out.print(name +" scores: "+player1Score
                        +"\n"+name2+" Scores: "+player2Score);
        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");// \n moves statements to the next line
        
        if (player1Score > player2Score){//if player 1 has a greater score than player 2
            System.out.println(name +" wins! ");//player 1 wins
            
        }else if(player1Score < player2Score){//if player 2 has a greater score than player 1
            System.out.println(name2 + " wins! ");//player 2 wins
        }else{
            System.out.println("No one wins! LEVELED  GAME");//otherwise they draw
        }
        
    }
    //determining the final scores
    private static void DetermineFinalScore(String name, String name2) {
        //checking the name of current player
        if (currentPlayer.equals(name) && !choice.equals("xxx")){
           player1Score += 1; 
        }
        if (currentPlayer.equals(name2) && !choice.equals("xxx")){
           player2Score += 1; 
        }
    }             
}
    
    

    
    

