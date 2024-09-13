package edu.grinnell.csc207.main;

import java.io.PrintWriter;


import edu.grinnell.csc207.util.CipherUtils;

/**
 * The Cipher program should take four command-line arguments in almost any order.
 * The action -encode or -decode (starts with a dash).
 * The cipher -vigenere or -caesar (starts with a dash).
 * The string to encode.
 * The key (which must be a single letter for the Caesar cipher).
 */
public class Cipher {
/**
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // if invalid number of parameter is taken
    if (args.length != NUM) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if

    // intialize variables
    int codeinstruction = 0; // stores if -encode or -decode is typed
    int codecipher = 0; // stores if -caesar or -vigenere is typed
    int[] position = {-1, -1}; // stores the position(index) of the key and the word
    int positionkey = -1; // stores the position(index) of the key
    int positionword = -1; // stores the position(index) of the word

    // Check for the existance of -encode/-decode, -caesar/-vigenere
    for (int i = 0; i < NUM; i++) {
      if (args[i].equals("-encode")) { // Check for -encode
        if (codeinstruction != 0) { // checks action is already occurred
          System.err.println("Error: There are more than one action (-encode/-decode) typed!");
          return;
        } //if
        codeinstruction = 1; // update the insturction
      } else if (args[i].equals("-decode")) { // Check for -decode
        if (codeinstruction != 0) { // checks action is already occurred
          System.err.println("Error: There are more than one action (-encode/-decode) typed!");
          return;
        } //if
        codeinstruction = 2;
      } else if (args[i].equals("-caesar")) { // Check for -caesar
        if (codecipher != 0) { // checks cipher is already occurred
          System.err.println("Error: There are more than one action (-caesar/-vigenere) typed!");
          return;
        } //if
        codecipher = 1;
      } else if (args[i].equals("-vigenere")) { // Check for -vigenere
        if (codecipher != 0) { // checks cipher is already occurred
          System.err.println("Error: There are more than one action (-caesar/-vigenere) typed!");
          return;
        } //if
        codecipher = 2;
      } else { // checks if parameters are lowercase
        for (int inde = 0; inde < args[i].length(); inde++) {
          if (args[i].charAt(inde) > 'z' || args[i].charAt(inde) < 'a') {
            System.err.println("Error: String contains characters other than lowercase letters.");
            return;
          } //if
        } //for
        // Mark the index where the command, other than action and cipher occurs.
        if (position[0] == -1) {
          position[0] = i;
        } else if (position[1] == -1) {
          position[1] = i;
        } //if
      } //if
    } //for

    // check for empty string
    if (args[position[0]].isEmpty() || args[position[1]].isEmpty()) {
      System.err.println("Error: There is at least one empty string!");
      return;
    } //if


    if (codeinstruction == 0) { // Check if an action has been typed
      System.err.println("Error: Please type an appropriate action");
      return;
    } //if


    if (codecipher == 0) { // Check if an cipher has been typed
      System.err.println("Error: Please type an appropriate cipher");
      return;
    } //if


    if (position[0] == -1 || position[1] == -1) {
      System.err.println("Error: Missing either a word or a key");
      return;
    } //if

    // If -caesar has been typed, the key should be a single character
    if (codecipher == 1) {
      positionword = position[0];
      positionkey = position[1];
      if (args[position[1]].length() != 1) {
        System.err.println("Error: The key should be only one letter!");
        return;
      } //if
    } else {
      positionkey = position[1];
      positionword = position[0];
    } //if

    // Decompose -encode as normal
    if (codeinstruction == 1) {
      if (codecipher == 1) { // have -encode and -caesar
        pen.printf("%s\n",
            CipherUtils.caesarEncrypt(args[positionword], args[positionkey].charAt(0)));
      } else { // have -encode and -vigenere
        pen.printf("%s\n", CipherUtils.vigenereEncrypt(args[positionword], args[positionkey]));
      } //if
    } //if


    // Decompose - decode as normal
    if (codeinstruction == 2) {
      if (codecipher == 1) { // have -decode and -caesar
        pen.printf("%s\n",
            CipherUtils.caesarDecrypt(args[positionword], args[positionkey].charAt(0)));
      } else { // have -decode and -vigenere
        pen.printf("%s\n", CipherUtils.vigenereDecrypt(args[positionword], args[positionkey]));
      } //if
    } //if

    pen.close();
  } //main
  /**
   * This is the definition to avoid magic number.
   */
  private static final int NUM = 4;
} //Cipher
