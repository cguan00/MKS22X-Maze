import java.util.*;
import java.io.*;
public class Maze{


    private char[][] maze;
    private boolean animate;//false by default
    private int[][] moves;

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
      animate = false;
      File text = new File(filename);
      Scanner inf = new Scanner(text);//input file
      ArrayList<String> lines = new ArrayList<String>(); //store each line of the text file

      //print out maze by reading file line by line
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        lines.add(line);
      }

      int numRows = lines.size();//keep track of the number of lines (how tall the maze is)
      int numCols = lines.get(0).length();//keep track of number of characters per line (how wide the maze is)

      maze = new char[numRows][numCols];

      for(int i = 0; i < numRows; i++){
        for(int j = 0; j < lines.get(0).length(); j++){
          maze[i][j] = lines.get(i).charAt(j);
        }
      }

      //counting up how many E's and S's there are to see if it in invalid file
      int countE = 0;
      int countS = 0;
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[i].length; j++){
          if(maze[i][j] == 'E'){
            countE += 1;
          }
          if(maze[i][j] == 'S'){
            countS += 1;
          }
        }
      }

      //not exactly 1 E or 1 S, so throw IllegalStateException
      //not a valid file
      if(countE != 1 || countS != 1){
        throw new IllegalStateException();
      }
      moves = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    }


    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

   /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
    public String toString(){
      String output = "";
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[i].length; j++){
          output += maze[i][j];
        }
        output += "\n";
      }
      return output;
    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */

    //find the location of the S.
    //erase the S
    //and start solving at the location of the s.
    //return solve(???,???);
    public int solve(){
      int sRow = 0;
      int sCol = 0;
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[i].length; j++){
          if(maze[i][j] == 'S'){
            sRow = i;
            sCol = j;
          }
          maze[i][j] = ' ';//erasing the S
        }
      }
      // System.out.println(sRow + " " + sCol);
      // return solve(sRow, sCol, 0);
      return 0;

    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int numSteps){ //you can add more parameters since this is private
      //automatic animation! You are welcome.
      if(animate){
          clearTerminal();
          System.out.println(this);
          wait(20);
      }
      for(int i = 0; i < moves.length; i++){
        int newRow = row + moves[i][0];
        int newCol = col + moves[i][1];
        //empty square. part of solution
        if(maze[newRow][newCol] == ' '){
          maze[newRow][newCol] = '@';
        }
      }

      return -1; //so it compiles
    }


}
