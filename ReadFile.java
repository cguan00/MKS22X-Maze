import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
    File text = new File("Maze1.txt");

    //inf stands for the input file
    Scanner inf = new Scanner(text);
    int numLines = 0;

    while(inf.hasNextLine()){
      String line = inf.nextLine();
      numLines += 1;
      System.out.println(line);//hopefully you can do other things with the line
    }

    String[] lines = new String[numLines];

    while(inf.hasNextLine()){
      for(int i = 0; i < numLines; i++){
        String line = inf.nextLine();
        lines[i] = line;
      }
    }

    for(int i = 0; i < numLines; i++){
      System.out.println(lines[i]);
      System.out.println("");
    }


    System.out.println(numLines);
  }
}
