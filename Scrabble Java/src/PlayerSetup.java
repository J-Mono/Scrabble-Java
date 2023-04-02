
import java.util.Scanner;

public class PlayerSetup extends GameSetup{
    static Scanner keyboard = new Scanner(System.in);//created a scanner object to be used through out the whole class

     public void PlayerEntering(){
        System.out.println("Welcome to the Word Wars game"+"\n");//this prints arguments (javatpoint.com, 2018)
        
        System.out.println("Press (1) to start the game");//prompts user to enter 1 in order to start game
        
        System.out.println("\n"+"or enter any other value to exit the game");
        
        System.out.print("Enter your selection: ");
        int selection = keyboard.nextInt();
        
        System.out.println("--------------------------------------");
        
        
        if(selection == 1){
            System.out.println("Enter player 1 name: ");//asking for player 1 name
            String player1 = keyboard.next();

            System.out.println("Enter player 2 name: ");//asking for player 2 name
            String player2 = keyboard.next();
            
            System.out.println("--------------------------------------");
            
            super.WordWars(player1,player2);//calls method that will start the game 
            
          }else{
               System.out.println("You have exited the game");//tells the user that the program ends
        }    
    }
}
