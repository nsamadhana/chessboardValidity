class Rook extends ChessPiece{
    public Rook(int c,int r, String color){
        this.col =c;
        this.row =r;
        this.color = color;
    }

    public Boolean isAttacking(ChessPiece piece){
        if(col==piece.col||row == piece.row){
            return true;
        }
        return false;
    }

}
