package edu.grinnell.csc207.util;
/**
 * The class converts a lowercase letter to the corresponding integer.
 * This is created for the fall 2024 section of CSC-207.
 * @author Tiffany Yan
 */
public class CipherUtils {
  private static int letter2int(char letter) {
    return (int) letter - (int) 'a';
  } //letter2int

  /**
   * The class convert the given integer to its responding character.
   * @param i
   * @return a character that is chaged from int to letter
   */
  private static char int2letter(int i) {
    return (char) (i + (int) 'a');
  } //int2letter


  /**
   * The class use the given Caeser Cipher to encrypt a string consisting of only lowercase letters.
   * using the given letter as the 'key'.
   * @param str
   * @param letter
   * @return a modified string
   */
  public static String caesarEncrypt(String str, char letter) {
    char[] lst = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      int newest = (letter2int(current) + letter2int(letter)) % NUM;
      lst[i] = (int2letter(newest));
    } //for
    String neww = new String(lst);
    return neww;
  } //caesarEncrypt

  /**
   * The class uses the Caeser Cipger to decrypt a string consisting of only lowercase letters,
   * using the given letter as the "key".
   * @param str
   * @param letter
   * @return a modified string
   */
  public static String caesarDecrypt(String str, char letter) {
    char[] lst = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      int newest = (NUM + letter2int(current) - letter2int(letter)) % NUM;
      lst[i] = (int2letter(newest));
    } //for
    String neww = new String(lst);
    return neww;
  } //caesarDecrypt


  /**
   * Uses the Vigenere Ciphere to encrypt a string consisting of only lowercase letters, using the
   * given key (which also consists of only lowercase letters).
   * @param str
   * @param key
   * @return a modified string
   */
  public static String vigenereEncrypt(String str, String key) {
    int keylength = key.length(); // record the length of the key

    char[] lst = new char[str.length()];
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (count == keylength) {
        count = 0;
      } //if
      char current = str.charAt(i);
      char currentkey = key.charAt(count++);
      int newest = (letter2int(current) + letter2int(currentkey)) % NUM;
      lst[i] = (int2letter(newest));
    } //for
    String neww = new String(lst);
    return neww;
  } //vigenereEncrypt

  /**
   * Use the Vigenere Cipher to decrypt a string consisting of only lowercase letters, using the
   * given key (consists of only lowercase letters).
   * @param str
   * @param key
   * @return a modified string
   */
  public static String vigenereDecrypt(String str, String key) {
    int keylength = key.length(); // record the length of the key

    char[] lst = new char[str.length()];
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (count == keylength) {
        count = 0;
      } //if
      char current = str.charAt(i);
      char currentkey = key.charAt(count++);
      int newest = (NUM + letter2int(current) - letter2int(currentkey)) % NUM;
      lst[i] = (int2letter(newest));
    } //for
    String neww = new String(lst);
    return neww;
  } //letter2int
  /**
   * This is the definition to avoid magic number.
   */
  private static final int NUM = 26;
} //CipherUtils


