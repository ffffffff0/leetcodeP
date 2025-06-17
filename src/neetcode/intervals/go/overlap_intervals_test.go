package main

import (
	"sort"
	"testing"
)

/**
Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/

func eraseOverlapIntervals(intervals [][]int) int {
	// sort
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	res := 0
	prev := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if prev[1] <= intervals[i][0] || prev[0] >= intervals[i][1] {
			// no overlapping
			prev = intervals[i]
		} else {
			// overlapping
			res++
			if prev[1] > intervals[i][1] {
				prev = intervals[i]
			}
		}

	}
	return res
}

func TestEraseOverlapIntervals(t *testing.T) {
	tests := []struct {
		intervals [][]int
		expected  int
	}{
		{
			intervals: [][]int{{1, 2}, {2, 3}, {3, 4}, {1, 3}},
			expected:  1,
		},
		{
			intervals: [][]int{{1, 2}, {1, 2}, {1, 2}},
			expected:  2,
		},
		{
			intervals: [][]int{{1, 2}, {2, 3}},
			expected:  0,
		},
	}

	for _, test := range tests {
		result := eraseOverlapIntervals(test.intervals)
		if result != test.expected {
			t.Errorf("expected %d but got %d", test.expected, result)
		}
	}
}
