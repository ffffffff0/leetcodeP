package utils

func partition(arr []int, low, high int) int {
	pv := arr[high]

	i := low
	for j := low; j < high; j++ {
		if arr[j] <= pv {
			arr[j], arr[i] = arr[i], arr[j]
			i++
		}
	}
	arr[i], arr[high] = arr[high], arr[i]
	return i
}

func QuicSort(num []int, low, high int) {
	if low < high {
		pivot := partition(num, low, high)
		QuicSort(num, low, pivot-1)
		QuicSort(num, pivot+1, high)
	}
}
