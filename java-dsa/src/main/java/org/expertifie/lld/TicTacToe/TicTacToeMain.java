package org.expertifie.lld.TicTacToe;

public class TicTacToeMain {

    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard(3);
        Player p1 = new Player(1, "Joy", Symbol.X);
        Player p2 = new Player(2, "Ray", Symbol.O);
        gameBoard.addPlayer(p1);
        gameBoard.addPlayer(p2);
        gameBoard.display();
        gameBoard.startGame();

    }
}
