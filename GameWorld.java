import java.util.Scanner;
public class GameWorld{
 public static void main(String[] args){
  System.out.println("Hello and welcome to game world");
  Scanner in = new Scanner(System.in);
  int choice =0;
  Game game = new Game();
  while(true){
    System.out.println("Please enter an option number");
    System.out.println("1. Buy game credit\n2. Play a game\n3. Quit");
    choice = in.nextInt();
    switch (choice){
    case 1:
      System.out.println(game.payment());
      break;
    case 2:
      game.play();
      break;
    case 3:
      System.out.println("Thanks for visiting, goodbye");
      System.exit(0);
    }//switch 
  }//while
 }//main
  
}//GameWorld