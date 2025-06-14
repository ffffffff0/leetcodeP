package test

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestBS(t *testing.T) {
	var bs func(nums []int, target int) int
	bs = func(nums []int, target int) int {

		l, r := 0, len(nums)

		for l < r {
			m := l + (r-l)/2

			fmt.Printf("l: %d, r: %d, m: %d\n", l, r, m)
			if nums[m] == target {
				return m
			} else if nums[m] > target {
				r = m - 1
			} else if nums[m] < target {
				l = m + 1
			}
			fmt.Printf("edited l: %d, r: %d\n", l, r)
		}

		return l
	}

	ta := []int{1, 2, 3, 5, 6, 7, 8, 9}
	tn := 4

	fmt.Printf("return: %d\n", bs(ta, tn))
}

func TestLeftBound(t *testing.T) {
	// find left bound in array
	var bs = func(nums []int, target int) int {
		l, r := 0, len(nums)-1

		for l <= r {
			m := l + (r-l)/2

			fmt.Printf("l: %d, r: %d, m: %d\n", l, r, m)
			if nums[m] == target {
				r = m - 1
			} else if nums[m] > target {
				r = m - 1
			} else if nums[m] < target {
				l = m + 1
			}

			fmt.Printf("edited l: %d, r: %d\n", l, r)
		}

		if l < 0 || l >= len(nums) {
			return -1
		}

		if nums[l] == target {
			return l
		}

		return -1
	}

	ta := []int{2, 4, 5, 5, 6, 7, 10}
	tn := 5

	fmt.Printf("return: %d\n", bs(ta, tn))
}

func TestRightBound(t *testing.T) {
	var bs = func(nums []int, target int) int {
		l, r := 0, len(nums)-1

		for l <= r {
			m := l + (r-l)/2

			fmt.Printf("l: %d, r: %d, m: %d\n", l, r, m)
			if nums[m] > target {
				r = m - 1
			} else if nums[m] < target {
				l = m + 1
			} else if nums[m] == target {
				l = m + 1
			}

			fmt.Printf("edited l: %d, r: %d\n", l, r)
		}

		if r < 0 || r >= len(nums) {
			return -1
		}

		if nums[r] == target {
			return r
		}

		return -1
	}

	ta := []int{2, 4, 5, 5, 6, 7, 10}
	tn := 5

	fmt.Printf("return: %d\n", bs(ta, tn))
}

func TestRotateArray(t *testing.T) {
	var bs = func(nums []int, target int) int {
		l, r := 0, len(nums)-1

		for l <= r {
			m := l + (r-l)/2

			if nums[m] == target {
				return m
			}

			if nums[m] >= nums[l] {
				// left
				if target > nums[m] {
					l = m + 1
				} else if target < nums[m] && target >= nums[l] {
					r = m - 1
				} else if target < nums[m] && target < nums[l] {
					l = m + 1
				}
			} else {
				// right
				if target > nums[m] && target <= nums[r] {
					l = m + 1
				} else if target > nums[m] && target > nums[r] {
					r = m - 1
				} else if target < nums[m] {
					r = m - 1
				}
			}
		}

		return -1
	}

	ta := []int{4, 5, 6, 7, 0, 1, 2}
	tn := 0
	er := bs(ta, tn)
	assert.Equal(t, er, 4)
}
