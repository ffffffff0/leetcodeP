package utils

import (
	"fmt"
	"testing"
)

func TestQuickSort(t *testing.T) {
	testArray := []int{3, 4, 1, 2, 10, 8, 9, 4, 2, 1}

	fmt.Println("original array: ", testArray)
	QuicSort(testArray, 0, len(testArray)-1)
	fmt.Println("final array: ", testArray)
}
