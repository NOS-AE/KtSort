package sort


object BubbleSort {
    @JvmStatic
    fun <T: Comparable<T>>sort(arr: MutableList<T>) {
        for (i in arr.indices) {
            for (j in 1..(arr.lastIndex - i)) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j)
                }
            }
        }
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    BubbleSort.sort(list)
    print(list)
}