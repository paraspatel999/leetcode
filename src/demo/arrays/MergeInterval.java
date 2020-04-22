package demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auther
 */

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[j][0];
                end = intervals[j][1];
            }
        }
        res.add(new int[]{start, end});
        return res.stream().toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] a = { {1,3},{2,6},{8,10},{15,18}};
        MergeInterval m = new MergeInterval();
        System.out.println(m.merge(a));
    }
}
