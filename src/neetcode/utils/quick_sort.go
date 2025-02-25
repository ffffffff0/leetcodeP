package utils

func partition(arr []int, low, high int) int {
	// pivotValue as a baseline
	// for loop compare each element with pivotValue
	// if element is less than pivotValue, let this element swap to front
	// if element is greater than pivotValue, continue loop
	pivotValue := arr[high]

	i := low
	for j := low; j < high; j++ {
		if arr[j] <= pivotValue {
			arr[j], arr[i] = arr[i], arr[j]
			i++
		}
	}
	// this step is to swap pivotValue to the right position
	arr[i], arr[high] = arr[high], arr[i]
	// i represents the index: all elements before i are less than pivotValue
	// all elements after i are greater than pivotValue
	return i
}

func QuicSort(arr []int, low, high int) {
	if low < high {
		pivot := partition(arr, low, high)
		QuicSort(arr, low, pivot-1)
		QuicSort(arr, pivot+1, high)
	}
}
