package main

import "testing"

func TestGroupAnagrams(t *testing.T) {

	t1 := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	r1 := GroupAnagrams(t1)

	t.Logf("r1: %v", r1)
}
