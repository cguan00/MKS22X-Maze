import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
    File text = new File("Maze1.txt");

    //inf stands for the input file
    Scanner inf = new Scanner(text);

    //store each line of the text file
    ArrayList<String> lines = new ArrayList<String>();

    //print out maze by reading file line by line
    while(inf.hasNextLine()){
      String line = inf.nextLine();
      System.out.println(line);
      lines.add(line);
    }

    // System.out.println(lines);
    System.out.println();
    System.out.println();

    int numLines = lines.size();//number of "rows"
    int numCharsPerLine = lines.get(0).length();//number of "cols"
    String[][] chars = new String[numLines][numCharsPerLine];//created 2D array

    //loop through each character of each line and add it to the 2D array
    for(int i = 0; i < numLines; i++){
      for(int j = 0; j < numCharsPerLine; j++){
        // System.out.println(lines.get(i).charAt(j));
        chars[i][j] = lines.get(i).charAt(j) + "";
      }
    }

    //like a toString to create string of 2D array that will be printed
    String output = "";
    for(int i = 0; i < chars.length; i++){
      for(int j = 0; j < chars[i].length; j++){
        output += chars[i][j];
      }
      output += "\n";
    }

    System.out.println(output);//print out maze by reading 2D array of characters
  }
}
