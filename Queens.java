/**
 * This class generates a "Queen" like in the boardgame Chess which can attack
 * other pieces vertically, horizontally, and diagonally in any direction.
 *
 */

class Queens extends ChessPiece{

    public Queens(int c, int r, String color)//Constructor for the queen class
    {
        this.col= c;
        this.row = r;
        this.color = color;
    }

    public int returnCol(){ //Returns column of the queen instance
        return col;
    }

    public int returnRow(){ //Returns row of the queen instance
        return row;
    }

    public Boolean isAttacking(ChessPiece piece) //Checks if queen is a threat to others queens on the board
    {
        if(col == piece.col || row == piece.row||Math.abs(col-piece.col)==Math.abs(row-piece.row)) return true; //This checks whether the queen attacks on its respective row or column
        return false;
    }

    public Boolean canMove(int endCol, int endRow, LinkedList list){
      if(Math.abs(col-endCol)==Math.abs(row-endRow)){ //Checks for blocking in second quadrant
        if(col>endCol && row<endRow){
          for(int i = col-1, j = row+1; i>endCol; i--,j++){
            if(list.valid(i,j)){
              return false;
            }
          }
        }
        if(col<endCol && row<endRow){//Checks first quadrant
          for(int i = col+1, j = row+1; i<endCol; i++,j++){
            if(list.valid(i,j)){
              return false;
            }
          }
        }
        if(col>endCol && row>endRow){//Checks third quadrant
          for(int i = col-1, j = row-1; i>endCol; i--,j--){
            if(list.valid(i,j)){
              return false;
            }
          }
        }
        if(col<endCol && row>endRow){//Checks fourth quadrant
          for(int i = col+1, j = row-1; i<endCol; i++,j--){
            if(list.valid(i,j)){

              return false;
            }
          }
        }
        return true;
    }
    if(col==endCol){ //Case when columns are equal
      if(row>endRow){
        for(int i = row-1; i>endRow; i--){
          if(list.valid(col,i)){
            return false;
          }
        }
      }
      if(row<endRow){
        for(int i = row+1; i<endRow; i++){
          if(list.valid(col,i)){
            return false;
          }
        }
      }
      return true;
    }
    //Case when rows are equal
    if(row==endRow){
      if(col>endCol){
        for(int i = col-1; i>endCol; i--){
          if(list.valid(i,row)){
            return false;
          }
        }
      }
      if(col<endCol){
        for(int i = col+1; i<endCol; i++){
          if(list.valid(i,row)){
            return false;
          }
        }
      }
      return true;
    }
  return false;
  }

}
