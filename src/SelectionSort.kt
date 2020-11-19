package sort

object SelectionSort {
    @JvmStatic
    fun <T : Comparable<T>> sort(arr: MutableList<T>) {
        for (i in arr.indices) {
            var min = i
            for (j in i..arr.lastIndex) {
                if (arr[min] > arr[j]) {
                    min = j
                }
            }
            arr.swap(min, i)
        }
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    SelectionSort.sort(list)
    print(list)
}