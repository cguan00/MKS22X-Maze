import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
      String file1 = "data1.dat";
      String file2 = "data2.dat";
      String file3 = "data3.dat";
      try{
        Maze f;
        f = new Maze(file1);//true animates the maze.

        // f.setAnimate(true);
        //f.solve();
        System.out.println(f);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+ file1);
      }catch(IllegalStateException e){
        System.out.println("Not a valid file");
      }
    }
}
