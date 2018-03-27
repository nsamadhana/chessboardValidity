//Queens class  

public class Queens{
  private int row;
  private int col;

  public Queens(int c, int r){
    col = c;
    row = r;
  }

  public int returnCol(){ //Returns column of the queen instance
      return col;
  }

  public int returnRow(){ //Returns row of the queen instance
      return row;
  }

  public Boolean isAttacking(Queen q)//Checks if queen is a threat to others queens on the board
  {
      if(this.col == q.col || this.row == q.row||Math.abs(this.col-q.col)==Math.abs(this.row-q.row)) return true; //This checks whether the queen attacks on its respective row or column
      return false;
  }
}
