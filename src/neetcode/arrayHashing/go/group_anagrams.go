package main

import "sort"

func GroupAnagrams(strs []string) [][]string {
	strMap := make(map[string][]string)
	for _, str := range strs {
		sa := []byte(str)
		sort.Slice(sa, func(i, j int) bool {
			return sa[i] < sa[j]
		})

		useKey := string(sa)
		strMap[useKey] = append(strMap[useKey], str)
	}

	ret := make([][]string, 0, len(strMap))
	for _, v := range strMap {
		ret = append(ret, v)
	}

	return ret
}
