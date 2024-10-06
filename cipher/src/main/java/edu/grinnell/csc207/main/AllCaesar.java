package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;
/**
 * a main method that will repeatedly read a line the user types, use a BFCalculator to compute the result, and print the result for the user. 
 * This type interaction is often called a “REPL”, for “Read-Eval-Print loop”.
 * This is created for the fall 2024 section of CSC-207.
 * @author Tiffany Yan
 */ 
public class AllCaesar {
  /**
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // if invalid number of input is taken

    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if
    // Check if only lower character strings are taken as input
    for (int i = 0; i < args[1].length(); i++) {
      if ((args[1].charAt(i) > 'z') || args[1].charAt(i) < 'a') {
        System.err.println("Error: String contains characters other than lowercase letters.");
      } //if
    } //for

    // if invalid instruction is typed
    if (!args[0].equals("encode") && !args[0].equals("decode")) {
      System.err.println(
          "Error: Invalid option: \"" + args[0] + "'. Valid options are \"encode\" or \"decode\"");
    } else if (args[0].equals("encode")) {
      String str = args[1];
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } //for
    } else if (args[0].equals("decode")) { // decode normally
      String str = args[1];
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } //for
    } // if
  } //main
} //AllCaesar
