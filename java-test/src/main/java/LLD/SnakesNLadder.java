package LLD;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SnakesNLadder {

    public static void main(String[] args) {
        List<Jumper> snakes = new ArrayList<>();
        List<Jumper> ladders = new ArrayList<>();

        Jumper snake1 = new Jumper(98,8);
        Jumper snake2 = new Jumper(56, 22);
        Jumper snake3 = new Jumper(47, 32);

        Jumper ladder1 = new Jumper(10,21);
        Jumper ladder2 = new Jumper(32,75);
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);

        ladders.add(ladder1);
        ladders.add(ladder2);
        Queue<Player> queue = new ArrayDeque<>();
        Player p1 = new Player(1, "RajKumar");
        Player p2 = new Player(2, "Priyanka");
        queue.offer(p1);
        queue.offer(p2);
        BoardGame game = new BoardGame(queue, new Dice(2), snakes,ladders);
        game.startGame();




    }
}


class BoardGame {

    int[][] grids = new int[101][101];
    Queue<Player> pq;
    Dice dice;
    List<Jumper> snakes;
    List<Jumper> ladders;
    int boardsize;

    BoardGame(Queue<Player> pq, Dice dice, List<Jumper> snakes, List<Jumper> ladders) {
        this.pq = pq;
        this.dice = dice;
        this.boardsize = 100;
        this.snakes = snakes;
        this.ladders = ladders;

    }

    void startGame() {
        while (pq.size() > 1) {

            Player p = pq.poll();
            int diceVal = dice.rollDice();
            System.out.println("Player " + p.name + " at position: " + p.pos + " rolled the dice, The no. on Dice is: " + diceVal);
            int nextCell = p.getPos() + diceVal;
            if (nextCell == boardsize) System.out.println("Player " + p.name + " won the game..");
            else if (nextCell > 100) pq.offer(p);
            else {
                int[] nextPos = new int[1];
                nextPos[0] = nextCell;
                boolean[] b = new boolean[1];
                snakes.forEach(v -> {
                    if (v.start == nextCell) nextPos[0] = v.end;
                });
                if (nextPos[0] != nextCell) System.out.print("Player " + p.name + " bitten by the snake..");

                ladders.forEach(v -> {
                    if (v.start == nextCell) nextPos[0] = v.end;
                    b[0]=true;
                });
                if (nextPos[0] != nextCell && b[0]) System.out.print("Player " + p.name + " jumped the ladder..");

                p.setPos(nextPos[0]);
                System.out.println("Player " + p.name + " is at position: " + p.getPos());
                pq.offer(p);
            }
        }
    }
}

class Dice{
    int noOfDice;

    Dice(int noOfDice){
        this.noOfDice = noOfDice;

    }

    int rollDice(){
        return ((int) (Math.random() * (6*noOfDice- 1*noOfDice))) +1;
    }
}

@Getter
@Setter
class Player{
    int id;
    String name;
    int pos;

    Player(int id, String name){
        this.id = id;
        this.name = name;
        this.pos=0;
    }
}

@Getter
@Setter
class Jumper {
    int start;
    int end;

    public Jumper(int start, int end) {
        this.end = end;
        this.start = start;
    }
}


