package org.expertifie.lld.TicTacToe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.dsa.incubation.Pair;

@Getter
@Setter
@ToString
public class Player {

    int id;
    String name;
    Symbol symbol;


    public Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

}
