package main

import (
	"sort"
	"testing"
)

/**
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

func merge(intervals [][]int) [][]int {
	// sort intervals
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	prev := intervals[0]
	res := [][]int{}
	for i := 1; i < len(intervals); i++ {
		// overlapping
		if prev[1] < intervals[i][0] || prev[0] > intervals[i][1] {
			// no overlapping
			res = append(res, prev)
			prev = intervals[i]
		} else {
			// overlapping
			prev = []int{
				min(prev[0], intervals[i][0]),
				max(prev[1], intervals[i][1]),
			}
		}
	}

	res = append(res, prev)
	return res
}

func TestMerge(t *testing.T) {
	tests := []struct {
		intervals [][]int
		expected  [][]int
	}{
		{
			intervals: [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
			expected:  [][]int{{1, 6}, {8, 10}, {15, 18}},
		},
		{
			intervals: [][]int{{1, 4}, {4, 5}},
			expected:  [][]int{{1, 5}},
		},
	}

	for _, test := range tests {
		result := merge(test.intervals)
		if len(result) != len(test.expected) {
			t.Errorf("Expected length %d, got %d", len(test.expected), len(result))
			continue
		}
		for i := range result {
			if result[i][0] != test.expected[i][0] || result[i][1] != test.expected[i][1] {
				t.Errorf("Expected %v, got %v", test.expected[i], result[i])
			}
		}
	}
}
