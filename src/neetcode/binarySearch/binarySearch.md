#### Binary Search

###### **二分查找的一些条件的意义:**
- left < right or left <= right

这里定义的其实每次搜索的空间是什么

> left < right 为 `[left, right)`
>
> left <= right 为 `[left, righ]`

也说明了这次搜索的终止条件:

> left < right => left == right 为终止条件,
> [right, right], 这个时候 right 其实是没有搜索的。
> 
> left <= right => left > right 为终止条件,
> left = right + 1 => [right + 1, right]

```java
// left < right, 需要的修改条件
while(left < right) {
    // ...
}
return nums[left] == target ? left : -1;
```

搜索条件终止之后, left 和 right 代表什么
> 当搜索结束之后: left > right, 因为原本数组就是排序过后的数组，最后搜索区间应该是 [right+1, right].
> 
> 也就是说上一次执行了 left = right + 1, 说明 nums[mid] < target.
> 
> left 代表大于 target 的第一个位置索引.
> 
> right 代表大于 target 的最后一个位置索引.

- right = mid - 1 or right = mid

这两种写法与开始的时候设置的区间有关, 如果设置区间是 left < right, 搜索区间是 [left, right), 这个时候继续搜索的左右区间应该是 [left, mid), [mid + 1, right) 在 right = mid 的情形下, 也符合逻辑.

如果是 left <= right 的话，搜索区间是 [left, right], 这个时候继续搜索的左右区间是 [left, mid-1], [mid+1, right] 这也是符合逻辑的.

##### 二分查找大致分类
- 普通
  - [插入位置](https://leetcode.com/problems/search-insert-position)

- 含有重复数字
  - [寻找 left bound, right bound](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)
  > left bound 和 right bound
  ```go
  for l <= r {
    m := l + (r-l)/2
    if nums[m] < target {
      l = m + 1
    } else if nums[m] > target {
      r = m - 1
    } else if nums[m] == target {
      r = m - 1
    }
  }
  // left bound
  if l < 0 || l >= len(nums) {
    return -1
  }
  if nums[l] == target {
    // left bound
    return l
  }
  ```

- 旋转数组
  - [旋转数组中查找目标值](https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=problem-list-v2&envId=237k3tne)
  > 其实就是分别考虑，考虑mid 落在那个区间上，然后根据情况来缩小下次缩小的区间查找范围.

  ```go
  for l <= r {
    m := l + (r-l)/2
    if nums[m] == target {
      return m
    }
    if nums[m] >= nums[l] {
      // left
      if target > nums[m] {
        l = m + 1
      } else if target < nums[m] && target >= nums[l] {
        r = m - 1
      } else if target < nums[m] && target < nums[l] {
        // 到了另一边
        l = m + 1
      }
    } else {
      // right
      if target > nums[m] && target <= nums[r] {
        l = m + 1
      } else if target > nums[m] && target > nums[r] {
        // 到了另一边
        r = m - 1
      } else if target < nums[m] {
        r = m - 1
      }
    }
  }
  ```
  - [旋转数组中查找最小值](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150)
  > 使用一个变量来记录二分查找过程中的最小值。

  ```go
	l, r := 0, len(nums)-1

	res := nums[0]
	for l <= r {
		if nums[l] <= nums[r] {
			if nums[l] < res {
				res = nums[l]
				break
			}
		}

		m := l + (r-l)/2
		if nums[m] < res {
			res = nums[m]
		}

		if nums[m] >= nums[l] {
			l = m + 1
		} else if nums[m] < nums[l] {
			r = m - 1
		}
	}
  ```

- 寻找山峰值