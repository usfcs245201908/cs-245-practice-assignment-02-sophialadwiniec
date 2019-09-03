import java.lang.*; 
public class NQueens {

    public int[][] board;
    public int n, row, col;
    public NQueens(int n){

        board = new int[n][n]; 
        this.n = n; 


    }

    public  boolean placeNQueens() throws Exception{
        if (n<=0){
            throw new IllegalArgumentException("Error"); 
        }

        return placeNQueen(0);
        
    }

    public boolean placeNQueen(int col){
        if(col >= n){
            return true; 
        }

        for(int i = 0; i<n;i++){

            if(canMove(i,col)){
                board[i][col] = 1;


                if(placeNQueen(col+1) == true){
                    return true; 
                }
                board[i][col] = 0; 
            }
        }
        return false;
    }

    public void placeQ(int row, int col){

            board[row][col] = 1;

        }


    public  boolean canMove(int row, int col){
        int i,j;
        //check this row on the left side
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        //Check upper diagonal on left side 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        // Check lower diagonal on left side 
        for (i = row, j = col; j >= 0 && i < n; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true;

    }

    public void printToConsole(){
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                System.out.print(board[r][c]+"\t");
            }
            System.out.println(); 
        }
    }




}