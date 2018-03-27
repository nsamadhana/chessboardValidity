class Node{
    Node next;
    ChessPiece piece;

    //Constructor for Node
    public Node(ChessPiece newPiece){
        piece = newPiece;
        next = null;
    }
}
