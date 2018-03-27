class LinkedList{
    public Node head;

    void LinkedList(){
        head = null;
    }

    public  void insert(ChessPiece newPiece){
        Node latest = new Node(newPiece);
        latest.next = head;
        head = latest;
    }

    public ChessPiece find(int col, int row){
        Node current = head;
        while(current != null){
            if(current.piece.getcol()==col && current.piece.getrow()==row){
                return current.piece;
            }
            current = current.next;
        }
        return null;
    }

    public Boolean valid(int col, int row){ //Returns true if pieces are in the same position
        Node current = head;
        while(current != null){
            if(current.piece.getcol()==col && current.piece.getrow()==row){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Boolean check(ChessPiece piece){ //Returns true if pieces are in the same position
        Node current = head;
        while(current != null){
            if(current.piece.getcolor()!=piece.getcolor()){
                if(piece.isAttacking(current.piece)){
                    return true;
                }
            }
            current = current.next;
        }
          return false;
    }





}
