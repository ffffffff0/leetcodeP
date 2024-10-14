package main

func TopKFrequent(nums []int, k int) []int {
	kMap := make(map[int]int)

	// key: num, value: frequent
	for _, v := range nums {
		kMap[v] += 1
	}
	// max frequent
	var maxFrequent = 0
	for _, v := range kMap {
		if v > maxFrequent {
			maxFrequent = v
		}
	}

	// key: frequent, value: nums
	buckets := make([][]int, maxFrequent+1)
	for k, v := range kMap {
		buckets[v] = append(buckets[v], k)
	}

	topK := make([]int, 0, k)
	for i := len(buckets) - 1; i >= 0 && len(topK) < k; i-- {
		if len(buckets[i]) > 0 {
			topK = append(topK, buckets[i]...)
		}
	}

	return topK
}
