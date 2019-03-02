import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
      try{
        String file1 = "data1.dat";
        Maze maze1 = new Maze(file1);
        System.out.println(maze1);
        // maze1.setAnimate(true);
        maze1.solve();
        System.out.println(maze1);

        String file2 = "data2.dat";
        Maze maze2 = new Maze(file2);
        System.out.println(maze2);
        // maze2.setAnimate(true);
        maze2.solve();
        System.out.println(maze2);

        String file3 = "data3.dat";
        Maze maze3 = new Maze(file3);
        System.out.println(maze3);
        // maze3.setAnimate(true);
        maze3.solve();
        System.out.println(maze3);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename");
      }catch(IllegalStateException e){
        System.out.println("Not a valid file");
      }
    }
}
