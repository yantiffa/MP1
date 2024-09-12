package edu.grinnell.csc207.util;

/*
 The class converts a lowercase letter to the corresponding integer.
*/
public class CipherUtils {
 private static int letter2int(char letter) {
   return (int)letter - (int)'a';
 }

/*
 The class convert the given integer to its responding character
*/
 private static char int2letter(int i) {
   return (char)(i+(int)'a'); 
 }


/*
 The class use the given Caeser Cipher to encrypt a string consisting of only lowercase
 letters, using the given letter as the 'key'
*/
 public static String caesarEncrypt(String str, char letter) {
    char[] lst = new char[str.length()];
    for (int i = 0; i < str.length(); i++)
    {
      char current = str.charAt(i);
      int newest = (letter2int(current) + letter2int(letter)) % 26;
      lst[i]=(int2letter(newest));    
    }
    String neww = new String(lst);
    return neww;
  }

/*
 The class uses the Caeser Cipger to decrypt a string consisting of only lowercase letters,
 using the given letter as the "key".
*/
 public static String caesarDecrypt(String str, char letter) {
  char[] lst = new char[str.length()];
    for (int i = 0; i < str.length(); i++)
    {
      char current = str.charAt(i);
      int newest = (26 + letter2int(current) - letter2int(letter)) % 26;
      lst[i]=(int2letter(newest));    
    }
    String neww = new String(lst);
    return neww;
 }


/*
 Uses the Vigenere Ciphere to encrypt a string consisting of only lowercase letters, using 
 the given key (which also consists of only lowercase letters)
*/
 public static String vigenereEncrypt(String str, String key) {
  int key_length = key.length();//record the length of the key

  char[] lst =  new char[str.length()];
  int count = 0;
  for (int i = 0; i < str.length(); i++)
  {
    if (count == key_length)
    {
      count = 0;
    }
    char current = str.charAt(i);
    char currentkey = key.charAt(count);
    int newest = (letter2int(current) + letter2int(currentkey)) % 26;
    lst[i]=(int2letter(newest)); 
  }
  String neww = new String(lst);
  return neww;
 }

/*
 Use the Vigenere Cipher to decrypt a string consisting of only lowercase letters, using the
 given key (consists of only lowercase letters)
*/ 
 public static String vigenereDecrypt(String str, String key) {
  int key_length = key.length();//record the length of the key

  char[] lst =  new char[str.length()];
  int count = 0;
  for (int i = 0; i < str.length(); i++)
  {
    if (count == key_length)
    {
      count = 0;
    }
    char current = str.charAt(i);
    char currentkey = key.charAt(count);
    int newest = (26 + letter2int(current) - letter2int(currentkey)) % 26;
    lst[i]=(int2letter(newest)); 
  }
  String neww = new String(lst);
  return neww;
 }
}


