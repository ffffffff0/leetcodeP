package main

import (
	"reflect"
	"testing"
)

/**
这个数组区间是按照 start_i 递增的.
将一个新区间插入 区间数组中,并且保证不存在交叉,有交叉则合并.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func insert(intervals [][]int, newInterval []int) [][]int {

	res := [][]int{}

	for i, item := range intervals {
		// check item 是否和 newInterval 有交叉
		if newInterval[1] < item[0] {
			// no overlapping, newInterval 好后面
			res = append(res, newInterval)
			return append(res, intervals[i:]...)
		} else if newInterval[0] > item[1] {
			// no overlapping, 在 newInterval 前面
			res = append(res, item)
		} else {
			// 开始重叠
			newInterval = []int{
				min(newInterval[0], item[0]),
				max(newInterval[1], item[1]),
			}
		}
	}

	res = append(res, newInterval)
	return res
}

func TestInsert(t *testing.T) {
	tests := []struct {
		intervals   [][]int
		newInterval []int
		want        [][]int
	}{
		{
			intervals:   [][]int{{1, 3}, {6, 9}},
			newInterval: []int{2, 5},
			want:        [][]int{{1, 5}, {6, 9}},
		},
		{
			intervals:   [][]int{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
			newInterval: []int{4, 8},
			want:        [][]int{{1, 2}, {3, 10}, {12, 16}},
		},
	}

	for _, tt := range tests {
		got := insert(tt.intervals, tt.newInterval)
		for i := range got {
			if !reflect.DeepEqual(got[i], tt.want[i]) {
				t.Errorf("insert() = %v, want %v", got, tt.want)
			}
		}
	}
}
