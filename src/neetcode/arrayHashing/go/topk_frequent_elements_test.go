package main

import (
	"fmt"
	"testing"
)

func TestTopKFrequentElements(t *testing.T) {
	t1 := []int{
		1, 1, 1, 2, 2, 3,
	}
	k1 := 2

	r1 := TopKFrequent(t1, k1)
	fmt.Printf("r1: %v\n", r1)

	t2 := []int{1}
	k2 := 1

	r2 := TopKFrequent(t2, k2)
	fmt.Printf("r2: %v\n", r2)
}
