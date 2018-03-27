class Knight extends ChessPiece{
    public Knight(int c,int r, String color){
        this.col = c;
        this.row = r;
        this.color = color;

    }

    public Boolean isAttacking(ChessPiece piece){
        if(Math.abs(col-piece.col)==1 && Math.abs(row-piece.row)==2){
            return true;
        }else if(Math.abs(row-piece.row)==2 && Math.abs(col-piece.col)==1){
            return true;
        }else{
            return false;
        }
    }

}
