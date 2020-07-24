package demo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther
 */

public class ShortestDistance {
    public int shortestDistance(int[][] grid) {

        int min = Integer.MAX_VALUE;
        List<int[]> buildings = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j =0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(new int[]{i , j});
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j =0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int d = findAllDist(grid, i, j, buildings);
                    if(d > -1) {
                        min = Math.min(min, d);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    private int findAllDist(int[][] grid, int i, int j, List<int[]> buildings) {
        int min = 0;



        for (int[] buld : buildings) {
            int[][] visited = new int[grid.length][grid[0].length];
            int d = findMinDistForABuiilding(grid, i, j, visited, buld[0], buld[1]);
            if (d < 1) return -1;
            min += d;
        }
        return min;
    }

    private int findMinDistForABuiilding(int[][] grid, int i, int j, int[][] visited, int p, int q) {
        if (i == p && j == q) return 0;

        if (visited[i][j] != 0) {
            return visited[i][j];
        }

        if (grid[i][j] == 2 || grid[i][j] == 1) {
            visited[i][j] = -1;
            return -1;
        }

        int min = Integer.MAX_VALUE;
        visited[i][j] = -2;
        if (i -1 >= 0 &&  visited[i-1][j] != -2) {
            int d = findMinDistForABuiilding(grid, i -1, j, visited, p, q);
            if (d > -1) {
                min = Math.min(min, d);
            }

        }

        if (i +1 < grid.length && visited[i+1][j] != -2) {
            int d = findMinDistForABuiilding(grid, i +1, j, visited, p, q);
            if (d > -1) {
                min = Math.min(min, d);
            }
        }

        if (j -1 >= 0 && visited[i][j-1] != -2) {
            int d = findMinDistForABuiilding(grid, i, j - 1, visited, p, q);
            if (d > -1) {
                min = Math.min(min, d);
            }
        }

        if (j + 1 < grid[0].length  && visited[i][j+1] != -2) {
            int d = findMinDistForABuiilding(grid, i, j + 1, visited, p, q);
            if (d > -1) {
                min = Math.min(min, d);
            }
        }
        if (min != Integer.MAX_VALUE) {
            visited[i][j] = min + 1;
            return min + 1;
        }
        visited[i][j] = -1;
        return -1;
    }
}
