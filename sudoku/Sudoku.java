package sudoku;
import java.util.*;
public class Sudoku{
    int n;
    static int rows;
    static int cols;
    static int [][]board;
    static boolean solved=false;

    Sudoku() {
        Scanner sc=new Scanner(System.in);
        this.rows=9;
        this.cols=9;
        this.board= new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                board[i][j]=sc.nextInt();
            }
        }

    }
    public static boolean possibility(int row,int col,int n){
        for (int i = 0; i < rows; i++) {
            if (board[row][i] == n) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < cols; i++) {
            if (board[i][col] == n) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col/ 3) * 3;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[startRow+i][startCol+j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    public static void  solver(){
        for (int row=0;row<9;row++){
            for (int col=0;col<9;col++){
                if (board[row][col]==0){
                    for (int n=1;n<10;n++){
                        if (possibility(row, col, n)==true){
                            board[row][col]=n;
                            solver();
                            if (solved) return;
                            board[row][col]=0;
                        }
                    }
                    return ;

                }
            }
        }
        solved = true ;
    }
    public static void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i%3==0 && i!=0){
                System.out.println("--------------------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j%3==0 && j!=0) {
                    System.out.print("|");
                    
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    


    public static void main(String[] args) {
        new Sudoku(); 
        solver();
        if (solved) {
            System.out.println("---------------------------------");
            System.out.println("Solution:");
            printBoard();
        }
        else{
            System.out.println("No solution exists ");
            }
        
        
        
    }


    


}