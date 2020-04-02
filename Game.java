import java.util.*;
import java.io.*;
import java.net.*;

public class Game{
  
 
  public String payment() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your name");
  String name = input.next();
  System.out.println("Enter your credit card number");
  String cc = input.next();
  System.out.println("Enter number of games you wish to purchase");
  int games = input.nextInt();
  
  PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
        URL realUrl = new URL("https://4lrr2rrik3.execute-api.us-east-1.amazonaws.com/default/cps831");
        // build connection
        URLConnection conn = realUrl.openConnection();
        // set request properties
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        // enable output and input
        conn.setDoOutput(true);
        conn.setDoInput(true);
        out = new PrintWriter(conn.getOutputStream());
        // send POST DATA
        out.print("{\"id\": \"" + name +"\" , \"creditcard\": \"" + cc + "\", \"games\": \"" + games + "\"}");
        out.flush();
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += "/n" + line;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    System.out.println("Thank you for your purchase of " + games + " games");
    //System.out.println(result.substring(30,94));
    return result.substring(30,94);

}

 public void play(String token){
  
  PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
        URL realUrl = new URL("https://tltga3b731.execute-api.us-east-1.amazonaws.com/default/cps831Charlie");
        // build connection
        URLConnection conn = realUrl.openConnection();
        // set request properties
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        // enable output and input
        conn.setDoOutput(true);
        conn.setDoInput(true);
        out = new PrintWriter(conn.getOutputStream());
        // send POST DATA
        out.print("{\"token\": \"" + token + "\"}");
        out.flush();
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += "/n" + line;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    System.out.println("You have " + result.substring(result.indexOf("Games")+6,result.indexOf("headers")-9) + " credits. Enjoy!");
    
   int plays = Integer.parseInt(result.substring(result.indexOf("Games")+6,result.indexOf("headers")-9));
  
   for(int x=0;x<plays;x++){
      System.out.println("Game: " + (x+1));
      Hangman h = new Hangman();
     h.mainHang();
     System.out.println();
   }
 }
 
}//game