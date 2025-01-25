package org.dsa.incubation;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixNearest0 {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

        int[][] res = updateMatrix(mat);


    }
    public static int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){

                if(mat[i][j]==1){
                    if(vis[i][j])
                    mat[i][j]= 1+bfs(mat, i,j,m,n,vis);
                }
                vis[i][j]= true;

            }
        }
        return mat;
    }


    static int bfs(int[][] mat, int x1, int y1, int m, int n, boolean[][] vis){
        int min=Integer.MAX_VALUE;
        Queue<Pair<Integer,Integer>> pq = new LinkedList<>();
        pq.add(new Pair<>(x1,y1));
        int count=0;
        while(!pq.isEmpty()){
            count=0;
            int size=pq.size();
            for(int i=0;i<size;i++) {
                Pair<Integer, Integer> p = pq.poll();
                count++;
                int x = p.x;
                int y = p.y;
                int[] dirx = {-1, 0, 1, 0};
                int[] diry = {0, -1, 0, 1};
                boolean isFound = false;
                for (int k = 0; k < 4; k++) {
                    int dx = x + dirx[k];
                    int dy = y + diry[k];
                    if(vis[dx][dy]){
                        count+=mat[dx][dy];
                        isFound=true;
                        break;
                    }
                    int val = check(mat, dx, dy, m, n, vis);
                    if (val == 0) {
                        isFound = true;
                        break;
                    } else if (val == 1) {
                        //dfs(dx,dy);
                    }
                }

                if (isFound) {
                    count++;
                }
            }
        }
        min=Math.min(min,count);

        return min;
    }

    static int check(int[][] mat, int dx, int dy, int m, int n, boolean[][] vis){
        if(dx<0 || dx>=m || dy<0 || dy>=n){
            return -1;
        }

       // vis[dx][dy]=true;
        if(mat[dx][dy]==0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
