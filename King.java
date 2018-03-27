class King extends ChessPiece{
    public King(int c,int r, String color){
        this.col = c;
        this.row = r;
        this.color = color;
    }

    public Boolean isAttacking(ChessPiece piece){
        if(Math.abs(col-piece.col)==1 && Math.abs(row-piece.row)==1){
            return true;
        }
        if(Math.abs(col-piece.col)==1 && Math.abs(row-piece.row)==0){
            return true;
        }
        if(Math.abs(col-piece.col)==0 && Math.abs(row-piece.row)==1){
            return true;
        }
        return false;
    }
}
