package sort

object InsertionSort {
    @JvmStatic
    fun <T : Comparable<T>> sort(arr: MutableList<T>) {
        for (i in 1..arr.lastIndex) {
            val min = arr[i]
            var preIndex = i - 1
            while (preIndex >= 0 && arr[preIndex] > min) {
                arr[preIndex + 1] = arr[preIndex]
                preIndex--
            }
            arr[preIndex + 1] = min
        }
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    InsertionSort.sort(list)
    print(list)
}