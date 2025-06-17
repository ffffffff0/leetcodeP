package neetcode.intervals.java;

import java.util.Arrays;

public class OverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0];
        for (int i=1; i< intervals.length; i++) {
            if (prev[0] >= intervals[i][1] || prev[1] <= intervals[i][0]) {
                // no overlap
                prev = intervals[i];
            } else {
                // overlap
                res++;
                if (intervals[i][1] < prev[1]) {
                    prev = intervals[i];
                }
            }
        }

        return res;
    }
}
