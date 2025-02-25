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

	r2 := TwoSum1(t1, s1)
	fmt.Printf("r2: %v\n", r2)

	r3 := TwoSum2(t1, s1)
	fmt.Printf("r3: %v\n", r3)
}
