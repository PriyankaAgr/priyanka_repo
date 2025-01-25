package org.expertifie.lld.TicTacToe;

import org.dsa.incubation.Pair;

import java.util.*;

public class GameBoard {

    Character[][] board;
    Deque<Player> players;


    GameBoard(int n){
        board = new Character[n][n];
        players = new ArrayDeque<>();
    }

    public void addPlayer(Player p){
        players.add(p);

    }
    public void display(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!= null) {
                    System.out.print(" " + board[i][j]);
                } else {
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
           // System.out.println();
            System.out.println("\n---------------");

        }
    }

    public void startGame(){
        while(true){

            Player p1= players.poll();

            System.out.println("Player " + p1.name + " turn to play, Enter grid Position-->");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            if(!isValid(inputRow, inputColumn)){
                System.out.println("Invalid Position Input, Please enter position again..");
                players.addFirst(p1);
                continue;
            }
            board[inputRow][inputColumn]=p1.symbol.getSymbol();
            display();
            if(checkWinner(inputRow, inputColumn, p1.symbol.getSymbol())){
                System.out.println("*****Player " + p1.name + " win the game****");
                break;

            }
            players.offer(p1);

        }
    }

    private boolean isValid(int x, int y){
        return x>= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == null;

    }
    private boolean checkWinner(int x, int y, Character sym) {

        boolean isRow = true;
        boolean isColumn = true;
        boolean isDiagonal = true;
        boolean isAntiDiagonal = true;
        for(int i=0;i< board.length;i++){
            if(board[x][i] == null || board[x][i]!=sym) {
                isRow = false;
                break;
            }
        }
        for(int i=0;i< board.length;i++){
            if(board[i][y] == null || board[i][y]!=sym){
                isColumn = false;
                break;
                }
        }
        for(int i=0;i< board.length;i++){
            if(board[i][i] == null || board[i][i]!=sym) {
                isDiagonal = false;
                break;
            }
        }
        for(int i=0,j= board.length-1;i< board.length && j>=0;i++,j--) {
            if (board[i][j] == null || board[i][j] != sym){
                isAntiDiagonal = false;
                break;
            }
        }
        return isRow || isColumn || isDiagonal || isAntiDiagonal;
    }


}
