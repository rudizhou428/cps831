import java.util.Scanner;

public class Hangman {

 private static String[] words = {"rumor","language","interrupt","morsel","master","foot","council","limited","allowance","belt","grip",
   "spy","noise","session","dozen","prediction","instruction","bus","highlight","blank","model","command","dribble","pledge","statement",
   "hardship","acquaintance","profession","bait","singer","realism","dare","abandon","crouch","dramatic","disagree","domestic","perforate",
   "bind","pair","audience","architect","fairy","rate","gas","hip","applaud","salad","go","jewel","live","soft","liver","nun","tone","mail carrier",
   "deter","jam","pile","transaction","defend","arrogant","nursery","swipe","honest","toast","rubbish","game","bathroom","transport","recycle","marble",
   "evoke","generation","performance","hair","agency","miscarriage","intelligence","breeze","double","bloodshed","jury","drug","secular","mechanism",
   "subway","bracket","ice cream","weigh","album","vain","scream","zone","wheel","shop","storm","title","spine","available"};
 private static String word = words[(int) (Math.random() * words.length)];
 private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
 private static int count = 0;

 public static void mainHang(/*String[] args*/) {
  Scanner sc = new Scanner(System.in);

  while (count < 7 && asterisk.contains("*")) {
   System.out.println("Guess any letter in the word");
   System.out.println(asterisk);
   String guess = sc.next();
   hang(guess);
  }
  sc.close();
 }

 public static void hang(String guess) {
  String newasterisk = "";
  for (int i = 0; i < word.length(); i++) {
   if (word.charAt(i) == guess.charAt(0)) {
    newasterisk += guess.charAt(0);
   } else if (asterisk.charAt(i) != '*') {
    newasterisk += word.charAt(i);
   } else {
    newasterisk += "*";
   }
  }

  if (asterisk.equals(newasterisk)) {
   count++;
   hangmanImage();
  } else {
   asterisk = newasterisk;
  }
  if (asterisk.equals(word)) {
   System.out.println("Correct! You win! The word was " + word);
  }
 }

 public static void hangmanImage() {
  if (count == 1) {
   System.out.println("Wrong guess, try again");
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println("___|___");
   System.out.println();
  }
  if (count == 2) {
   System.out.println("Wrong guess, try again");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("___|___");
  }
  if (count == 3) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   | ");
   System.out.println("___|___");
  }
  if (count == 4) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        |     |");
   System.out.println("   |         \\_ _/");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("___|___");
  }
  if (count == 5) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        |     |");
   System.out.println("   |         \\_ _/");
   System.out.println("   |           |");
   System.out.println("   |           |");
   System.out.println("   |");
   System.out.println("___|___");
  }
  if (count == 6) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        |     |");
   System.out.println("   |         \\_ _/");
   System.out.println("   |           |");
   System.out.println("   |           |");
   System.out.println("   |          / \\ ");
   System.out.println("___|___      /   \\");
  }
  if (count == 7) {
   System.out.println("GAME OVER!");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        |     |");
   System.out.println("   |         \\_ _/");
   System.out.println("   |          _|_");
   System.out.println("   |         / | \\");
   System.out.println("   |          / \\ ");
   System.out.println("___|___      /   \\");
   System.out.println("GAME OVER! The word was " + word);
  }
 }
}