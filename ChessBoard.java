/*Nevan Samadhana
Student ID: 1539153
This program takes in input files and creates an 8x8 chessboard with the designated pieces. It returns validity of the inputted board to an out
file along with the queried piece and whether or not it is attacking or even exists at all.
*/

import java.io.*;
import java.util.Scanner;
import java.lang.*;
class ChessBoard{
    public static void main(String[] args)throws IOException{
        //Copied this if statement from Lab2.
        if(args.length < 2){
        System.out.println("Usage: java –jar Chessboard.jar <input file> <output file>");
        System.exit(1);
        }

        Scanner in = new Scanner(new File(args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));

        while(in.hasNextLine()){
            LinkedList list = new LinkedList();
            int firstcol;
            int firstrow;
            int col;
            int row;
            String type;
            String color;
            String placeholder;
            Boolean flag = true;
            String line = in.nextLine().trim() + " ";
            String [] token = line.split(": "); //Splits the
            String [] colrow = token[0].split("\\s+");
            firstcol = Integer.parseInt(colrow[0]); //First value before the colon
            firstrow = Integer.parseInt(colrow[1]); //Second value before the colon
            String [] positions = token[1].split("\\s+");

            for(int i = 0; i < positions.length; i+=3){
                col = Integer.parseInt(positions[i+1]);
                row = Integer.parseInt(positions[i+2]);

                if(list.valid(col, row)){ //Checks if board is actually valid or not. If not it will just print out invalid and break
                    out.println("Invalid");
                    flag = false;
                    break;
                }
                placeholder = positions[i];
                if(Character.isUpperCase(placeholder.charAt(0))){
                    color = "Black";
                }else{
                    color = "White";
                }
                type = placeholder.toLowerCase();

                switch(type){
                    case "r":
                        list.insert(new Rook(col, row, color));
                        break;
                    case "b":
                        list.insert(new Bishop(col,row,color));
                        break;
                    case "n":
                        list.insert(new Knight(col,row,color));
                        break;
                    case "k":
                        list.insert(new King(col,row,color));
                        break;
                    case "q":
                        list.insert(new Queens(col,row,color));
                        break;
                    default:
                        System.out.println("You have a fucking error you dumb bitch");
                        break;
                } //End of switch case

            }//End of for loop
            ChessPiece shabooya = list.find(firstcol,firstrow); //Finding the type of piece at the desired query
            if(shabooya == null){
                out.println("-");
                flag = false;
            }

            if(shabooya instanceof Queens && shabooya.getcolor()=="Black" && flag == true){
                out.print("Q ");
                if(list.check(new Queens(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }

            }
            if(shabooya instanceof Queens && shabooya.getcolor()=="White" && flag == true){
                out.print("q ");
                if(list.check(new Queens(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof King && shabooya.getcolor()=="Black" && flag == true){
                out.print("K ");
                if(list.check(new King(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof King && shabooya.getcolor()=="White" && flag == true){
                out.print("k ");
                if(list.check(new King(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Bishop && shabooya.getcolor()=="Black" && flag == true){
                out.print("B ");
                if(list.check(new Bishop(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Bishop && shabooya.getcolor()=="White" && flag == true){
                out.print("b ");
                if(list.check(new Bishop(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Rook && shabooya.getcolor()=="Black" && flag == true){
                out.print("R ");
                if(list.check(new Rook(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Rook && shabooya.getcolor()=="White" && flag == true){
                out.print("r ");
                if(list.check(new Rook(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Knight && shabooya.getcolor()=="Black" && flag == true){
                out.print("N ");
                if(list.check(new Knight(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){
                    out.println("y");
                }else{
                    out.println("n");
                }
            }
            if(shabooya instanceof Knight && shabooya.getcolor()=="White" && flag == true){
                out.print("n ");
                if(list.check(new Knight(shabooya.getcol(),shabooya.getrow(),shabooya.getcolor()))){ //Runs the check method and determines if the piece in hand is attacking other pieces of opposite color
                    out.println("y");
                }else{
                    out.println("n");
                }
            }

        }//End of while loop
        out.close();
        in.close();
    }//End of main

}
