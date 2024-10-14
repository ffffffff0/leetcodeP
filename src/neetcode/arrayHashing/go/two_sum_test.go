package main

import (
	"fmt"
	"testing"
)

func TestTwoSum(t *testing.T) {

	t1 := []int{
		2, 7, 11, 15,
	}
	s1 := 9

	r1 := TwoSum(t1, s1)
	fmt.Printf("r1: %v\n", r1)

	t2 := []int{
		3, 2, 4,
	}
	s2 := 6
	r2 := TwoSum(t2, s2)
	fmt.Printf("r2: %v\n", r2)
}
