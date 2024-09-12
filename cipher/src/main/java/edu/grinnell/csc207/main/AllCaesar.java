package edu.grinnell.csc207.main;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
  PrintWriter pen = new PrintWriter(System.out, true);
    // if invalid number of input is taken
  if (args.length != 2)
  {
    System.err.println("Error: Incorrect number of parameters.");
    return;
  }
  // Check if only lower character strings are taken as input
  for (int i = 0; i < args[1].length(); i++)
  {
    if ((args[1].charAt(i) > 'z') || args[1].charAt(i) < 'a')
    {
      System.err.println("Error: String contains characters other than lowercase letters.");
    }
  }

  // if invalid instruction is typed
  if (!args[0].equals("encode") && !args[0].equals("decode"))
   {
     System.err.println("Error: Invalid option: \"" + args[0]+ "'. Valid options are \"encode\" or \"decode\"");
   }

    //encode normally
     else if (args[0].equals("encode"))
     {
       String str = args[1];
       for (char ch = 'a'; ch <= 'z'; ch++) 
       {
         pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
       }
     }
  
  
     //decode normally
     else if (args[0].equals("decode"))
     {
       String str = args[1];
       for (char ch = 'a'; ch <= 'z'; ch++) 
       {
         pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
       }
     }
  }
}
