package neetcode.intervals.java;

import java.util.*;

public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res  = new ArrayList<>();
        // sort intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev  = intervals[0];

        for (int i=1; i<intervals.length; i++) {

            if (prev[0] < intervals[i][0] || prev[1] < intervals[i][0]) {
                // no overlap
                res.add(prev);
                prev = intervals[i];
            } else {
                // overlap
                prev = new int[]{
                    Math.min(prev[0], intervals[i][0]),
                    Math.max(prev[1], intervals[i][1])
                };
            }
        }

        res.add(prev);
        return res.toArray(int[][]::new);
    }
}
