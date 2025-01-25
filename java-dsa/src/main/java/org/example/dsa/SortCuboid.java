package org.example.dsa;

import java.util.*;


/**
 * I/O:
 * [2,1,2], [3,2,3],[2,2,8],[2,3,4],[1,3,1],[4,4,5]
 *
 * 131 212 228 234 323 445
 * 212
 * O/P:
 * [2,1,2], [3,2,3], [4,4,5]
 * (2+3+5) = 10
 * Condition: All the w/d/h is always less then below it
 */

//111 222 333 444=10
//444 333 222 111
class Cuboid{
    int b;
    int l;
    int h;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Cuboid(int b, int l, int h) {
        this.b=b;
        this.l=l;
        this.h=h;
    }
}
public class SortCuboid {
    List<Cuboid> res = new ArrayList<>();

    public static void main(String[] args) {
        List<Cuboid> list = new ArrayList<>();
        Cuboid cuboid1 = new Cuboid(2, 1, 2);
        Cuboid cuboid2 = new Cuboid(3, 2, 3);
        Cuboid cuboid3 = new Cuboid(2, 2, 8);
        Cuboid cuboid4 = new Cuboid(2, 3, 4);
        Cuboid cuboid5 = new Cuboid(1, 3, 1);
        Cuboid cuboid6 = new Cuboid(4, 4, 5);

        list.add(cuboid1);
        list.add(cuboid2);
        list.add(cuboid3);
        list.add(cuboid4);
        list.add(cuboid5);
        list.add(cuboid6);

        List<Cuboid> sortedList = list.stream().sorted(Comparator.comparing(Cuboid::getB).thenComparing(Cuboid::getL).thenComparing(Cuboid::getH)).toList();
      //  List<Cuboid> resList = sortedList.stream().filter((c2, c1) -> (c1.getB()< c2.getB() && c1.getL() < c2.getL() && c1.getH() < c2.getH())).toList();
      //  resList.forEach(l->System.out.println(STR."[\{l.getB()},\{l.getL()},\{l.getH()}]"));

    }

    private void sortFunction(List<Cuboid> list) {
            for (int i = 1; i < list.size(); i++) {
                int h = list.get(i).h;

                //    dfs(i+1, list,)


            }
    }
}

