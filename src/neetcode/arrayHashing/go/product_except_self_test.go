package main

import "testing"

func TestProductExceptSelf(t *testing.T) {
	t1 := []int{1, 2, 3, 4}
	r1 := ProductExceptSelf(t1)
	e1 := []int{24, 12, 8, 6}

	t.Logf("r1: %v", r1)
	for i, v := range r1 {
		if v != e1[i] {
			t.Errorf("wrong answer")
		}
	}
}
