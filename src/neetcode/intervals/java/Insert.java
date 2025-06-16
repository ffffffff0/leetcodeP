package neetcode.intervals.java;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i=0; i<intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);

                for (int j=i; j<intervals.length; j++) {
                    res.add(intervals[j]);
                }

                return res.toArray(new int[res.size()][]);
            } else {
                newInterval = new int[]{
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])
                };
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
    
}
