package demo;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @auther
 */

public class MovesToSolve {

    public static void main(String[] args) throws UnsupportedEncodingException {

    }



    static class Stuct {
        List<Integer> list;
        int start;
        int end;

        public Stuct(List<Integer> list, int start, int end) {
            this.list = list;
            this.start = start;
            this.end = end;
        }
    }
    public static int movesToSolve(List<List<Integer>> puzzle) {
        int row = puzzle.size();
        int col = puzzle.get(0).size();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j= 0; j < col; j++) {
                list.add(puzzle.get(i).get(j));
            }
        }
        Queue<Stuct> queue = new LinkedList();
        queue.add(new Stuct(list, list.get(0), 0));

        Set<List<Integer>> visited = new HashSet<>();

        return 0;
    }
}
