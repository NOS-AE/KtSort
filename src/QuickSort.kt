package sort

object QuickSort {
    @JvmStatic
    fun <T : Comparable<T>> sort(arr: MutableList<T>) {
        val res = quickSort(arr)
        res.forEachIndexed { index, t ->
            arr[index] = t
        }
    }

    private fun <T : Comparable<T>> quickSort(items: List<T>): List<T> {
        if (items.count() < 2) {
            return items
        }
        val pivot = items[items.count() / 2]
        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot }
        return quickSort(less) + equal + quickSort(greater)
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    QuickSort.sort(list)
    print(list)
}