package java_assignment;
import java.io.*;

public class WordFinder {
    public static final int N = 10;
    public static char[][] grid = new char[N][N];
    public static final String GRID_FILE = "data/grid.txt";
    public static final String WORD_FILE = "data/words.txt";

    public static void main(String[] args) throws FileNotFoundException {
        initGrid();
        printGrid();
        find();
    }
    public static void initGrid(){
        try {
            File filegrid = new File(GRID_FILE);
            BufferedReader buffer = new BufferedReader(new FileReader(filegrid)); //Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of line by line to string
            String readLine;
            int columncount = 0;
            while ((readLine = buffer.readLine()) != null) { // checking if any there is no empty line in the grid file using the buffer.readline
                int rows = 0;
                for (char c: readLine.toCharArray()) { // method .tocharArray is used to return an Array of chars after converting a String into sequence of characters. The returned array length is equal to the length of the String and the sequence of chars in Array matches the sequence of characters in the String.
                    grid[columncount][rows] = c;
                    rows++;
                }
                columncount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printGrid(){
        /*
        using for loops to print the rows and columns in the form of a grid that was read from the GRIDFILE
        and the method intiGrid was used to read every line in the file and  check if the file path was correct or not.
        after checking everything, printgrid method is used.
        */
        for(int row = 0; row<grid.length;row++){
            for (int column = 0 ; column<grid.length;column++){
                System.out.print(grid[row][column]+" ");
            }
            System.out.println("\t");
        }
    }
    public static void find(){
        System.out.println("\n");
        try {
            File wordfile = new File(WORD_FILE);
            BufferedReader buff = new BufferedReader(new FileReader(wordfile));
            String wordfound ;
            while ((wordfound  = buff.readLine()) != null) {
                String temporarywords = "";
                checkingwordsinrow:
               /*
                this function below is used to find words among the rows in 2D array of the word file
               */
                for(int rownumber = 0; rownumber<grid.length;rownumber++){
                    for (int rowposition = 0 ; rowposition<grid.length;rowposition++){
                        if(grid[rownumber][rowposition]==wordfound .charAt(0)){ //charAt() method returns the character at the specified index in a string.
                            for (int k = 0;k<wordfound .length();k++){  // k is the length of the word
                                try {
                                    temporarywords += grid[rownumber][rowposition + k]; // words found in the rows of an array where 'i' represents which row the word is in, 'j' represents the position in the array.
                                }catch (ArrayIndexOutOfBoundsException exception){ //  ArrayIndexOutOfBoundsException means  are trying to access a array index that doesn't exist. so if an element is found outside the bounds of an array the for loop breaks.
                                    break;
                                }
                                if (temporarywords.equals(wordfound)){
                                    System.out.println(temporarywords+": row "+rownumber+", position "+rowposition);
                                    break  checkingwordsinrow;
                                }
                            }
                        }
                    }
                    temporarywords = "";
                }
                /*
                this function below is used to find words among the columns in 2D array of the word file
               */
                checkingwordsincolumn:
                for(int columnnumber = 0; columnnumber<grid.length;columnnumber++){ // same procedure as for finding words in rows.
                    for (int colpos = 0 ; colpos<grid.length;colpos++){
                        if(grid[columnnumber][colpos]==wordfound .charAt(0)){
                            for (int worldln = 0;worldln<wordfound .length();worldln++){
                                try {
                                    temporarywords += grid[columnnumber + worldln][colpos];
                                }catch (ArrayIndexOutOfBoundsException exception){
                                    break;
                                }
                                if (grid[columnnumber + worldln][colpos] == wordfound .charAt(0))temporarywords=""+wordfound .charAt(0);
                                if (temporarywords.equals(wordfound )){
                                    System.out.println(wordfound +": column "+colpos+", position "+columnnumber);
                                    break  checkingwordsincolumn;
                                }
                            }
                        }
                    }
                    temporarywords = " ";
                }
            }

            /*
            the use of printStackTrace
            It's a method on Exception instances that prints the stack trace of the instance to System.err.
            It's a very simple, but very useful tool for diagnosing an exceptions. It tells you what happened and where in the code this happened.
          */

        } catch (IOException found) {
            found.printStackTrace();

        }
    }
}
