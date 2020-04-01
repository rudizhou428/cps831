import java.util.Scanner;
public class Game{
  Scanner in = new Scanner(System.in);
public String payment(){
  System.out.println("Enter your name");
  String name = in.next();
  System.out.println("Enter your credit card number");
  String cc = in.next();
  System.out.println("Enter number of games you wish to purchase");
  int games = in.nextInt();
  System.out.println("Thank you for your purchase");
   return "{\"id\": \"" + name +"\" , \"creditcard\": \"" + cc + "\", \"games\": \"" + games + "\"}";

 }
 public void play(){
   System.out.println("gameplay");
 }
 
}//game