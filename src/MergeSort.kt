package sort

object MergeSort {
    @JvmStatic
    fun <T : Comparable<T>> sort(arr: MutableList<T>) {
        mergeSort(arr).forEachIndexed { index, t ->
            arr[index] = t
        }
    }

    private fun <T : Comparable<T>> mergeSort(arr: List<T>): List<T> {
        if (arr.size == 1)
            return arr
        return merge(
            mergeSort(arr.slice(0 until (arr.size / 2))),
            mergeSort(arr.slice((arr.size/2) until (arr.size)))
        )
    }

    private fun <T : Comparable<T>> merge(arr1: List<T>, arr2: List<T>): List<T> {
        val ret = mutableListOf<T>()
        var i = 0
        var j = 0
        while (i < arr1.size && j < arr2.size) {
            ret += if (arr1[i] < arr2[j]) {
                arr1[i++]
            } else {
                arr2[j++]
            }
        }
        while (i < arr1.size) {
            ret += arr1[i++]
        }
        while (j < arr2.size) {
            ret += arr2[j++]
        }
        return ret
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    MergeSort.sort(list)
    println(list)
}