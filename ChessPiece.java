class ChessPiece{
    public int col;
    public int row;
    public String color;

    public int getcol(){
        return col;
    }

    public int getrow(){
        return row;
    }

    public String getcolor(){
        return color;
    }
    public Boolean isAttacking(ChessPiece c) {
      return true;
    }
}
