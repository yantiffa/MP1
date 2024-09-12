package edu.grinnell.csc207.main;
import java.io.PrintWriter;


import edu.grinnell.csc207.util.CipherUtils;


public class Cipher {
public static void main(String[] args) {
  PrintWriter pen = new PrintWriter(System.out, true);


// if invalid number of parameter is taken
if (args.length != 4)
{
  System.err.println("Incorrect number of parameters.");
  return;
}


int code_instruction = 0;
int code_cipher = 0;
int[] position = {-1,-1};
int position_key = -1;
int position_word = -1;
//Check for the existance of -encode/-decode, -caesar/-vigenere
for (int i = 0; i < 4; i++)
{
  if(args[i].equals("-encode")) // Check for -encode
  {
    if (code_instruction != 0) //checks action is already occurred
    {
      System.err.println("There are more than one action (-encode/-decode) typed!");
      return;
    }
    code_instruction = 1;
  }


  else if (args[i].equals("-decode")) // Check for -decode
  {
    if (code_instruction != 0) //checks action is already occurred
    {
      System.err.println("There are more than one action (-encode/-decode) typed!");
      return;
    }
    code_instruction = 2;
  }

  else if (args[i].equals("-caesar")) //Check for -caesar
  {
    if (code_cipher != 0) //checks cipher is already occurred
    {
      System.err.println("There are more than one action (-caesar/-vigenere) typed!");
      return;
    }
    code_cipher = 1;
  }


  else if (args[i].equals("-vigenere")) //Check for -vigenere
  {
    if (code_cipher != 0) //checks cipher is already occurred
    {
      System.err.println("There are more than one action (-caesar/-vigenere) typed!");
      return;
    }
    code_cipher = 2;
  }


  else //checks if parameters are lowercase
  {
    for (int inde = 0; inde < args[i].length(); inde++)
    {
      if (args[i].charAt(inde) > 'z' || args[i].charAt(inde) < 'a')
      {
        System.err.println("String contains characters other than lowercase letters.");
        return;
      }
    }


    //Mark the index where the command, other than action and cipher occurs.
    if (position[0] == -1)
    {
      position[0] = i;
    }
    else if (position[1] == -1)
    {
      position[1] = i;
    }
  }
}


if (code_instruction == 0) //Check if an action has been typed
{
  System.err.println("Please type an appropriate action");
  return;
}


if (code_cipher == 0) // Check if an cipher has been typed
{
  System.err.println("Please type an appropriate cipher");
  return;
}


if(position[0] == -1 || position[1] == -1)
{
  System.err.println("Missing either a word or a key");
  return;
}


//If -caesar has been typed, the key should be a single character
if (code_cipher == 1)
{
if (args[position[0]].length() == 1)
{
  position_key = position[0];
  position_word = position[1];
}
else if (args[position[1]].length()==1)
{
  position_key = position[1];
  position_word = position[0];
}
else
{
  System.err.println("The key should be only one letter!");
  return;
}
}
else
{
  position_key = position[1];
  position_word = position[0];
}

//Decompose -encode as normal
if (code_instruction == 1)
{
  if (code_cipher == 1) // have -encode and -caesar
  {
    pen.printf("The encoded message is %s\n", CipherUtils.caesarEncrypt(args[position_word], args[position_key].charAt(0)));
  }
  else //have -encode and -vigenere
  {
    pen.printf("The encoded message is %s\n", CipherUtils.vigenereEncrypt(args[position_word], args[position_key]));
  }
}


// Decompose - decode as normal
if (code_instruction == 2)
{
  if (code_cipher == 1) // have -decode and -caesar
  {
    pen.printf("The encoded message is %s\n", CipherUtils.caesarDecrypt(args[position_word], args[position_key].charAt(0)));
  }
  else // have -decode and -vigenere
  {
    pen.printf("The encoded message is %s\n", CipherUtils.vigenereDecrypt(args[position_word], args[position_key]));
  }
}
  pen.close();
  
}
}