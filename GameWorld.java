import java.util.Scanner;
public class GameWorld{
 public static void main(String[] args){
  System.out.println("Hello and welcome to game world");
  
  int choice =0;
  Game game = new Game();
   String token = "";
  while(true){
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter an option number");
    System.out.println("1. Buy game credit\n2. Play a game\n3. Quit");
    while(!in.hasNextInt()){
      in.next();
    }
    choice = in.nextInt();
    switch (choice){
    case 1:

      token = game.payment();
      break;
    case 2:

      if(token.length() == 0){
         System.out.println("Please buy credits first");
       }//if
      else{
        game.play(token);
        token="";
      }//else
        break;
           
    case 3:
      
      System.out.println("Thanks for visiting, goodbye");
      System.exit(0);
      default:
        break;
    }//switch 
  }//while
 }//main
  
}//GameWorld