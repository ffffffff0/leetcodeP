package main

import "testing"

func TestArraysHashing(t *testing.T) {
	ta1 := []int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}
	r1 := ContainsDuplicate(ta1)
	ep1 := true
	if r1 != ep1 {
		t.Error("ta1 test error")
	}

	ta2 := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	r2 := ContainsDuplicate(ta2)
	ep2 := false
	if r2 != ep2 {
		t.Error("ta2 test error")
	}
}
