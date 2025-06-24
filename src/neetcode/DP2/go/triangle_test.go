package main

import "testing"

/**
Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
*/

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minimumTotal(triangle [][]int) int {
	dp := make([][]int, len(triangle))
	bottom := len(triangle[len(triangle)-1])

	for i := range dp {
		dp[i] = make([]int, bottom)
	}

	dp[len(triangle)-1] = triangle[len(triangle)-1]
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := len(triangle[i]) - 1; j >= 0; j-- {
			dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
		}
	}

	return dp[0][0]
}

func TestMiniMumTotal(t *testing.T) {
	tests := []struct {
		triangle [][]int
		want     int
	}{
		{[][]int{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}, 11},
		{[][]int{{-10}}, -10},
	}

	for _, tt := range tests {
		if got := minimumTotal(tt.triangle); got != tt.want {
			t.Errorf("minimumTotal() = %v, want %v", got, tt.want)
		}
	}
}
