package sort

object ShellSort {
    fun <T: Comparable<T>>sort(arr: MutableList<T>) {
        var gap = arr.size / 2
        while (gap > 0) {
            for (i in gap..arr.lastIndex) {
                val min = arr[i]
                var preIndex = i - gap
                while (preIndex >= 0 && arr[preIndex] > min) {
                    arr[preIndex + gap] = arr[preIndex]
                    preIndex -= gap
                }
                arr[preIndex + gap] = min
            }
            gap /= 2
        }
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    ShellSort.sort(list)
    print(list)
}