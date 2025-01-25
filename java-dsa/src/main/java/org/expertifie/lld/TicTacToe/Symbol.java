package org.expertifie.lld.TicTacToe;

public enum Symbol {

    X('X'),
    O('O');


    private final Character symbol;

    Symbol(Character o) {
        this.symbol=o;
    }
    public Character getSymbol(){
        return  symbol;

    }
}
