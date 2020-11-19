package sort

object CountingSort {
    @JvmStatic
    fun sort(arr: MutableList<Int>) {
        val maxVal = arr.max() ?: return
        val minVal = arr.min() ?: return // for negative-valued compatibility
        val bucket = Array(maxVal - minVal + 1) {
            0
        }
        arr.forEach {
            bucket[it - minVal]++
        }
        var arrIndex = 0
        bucket.forEachIndexed { index, i ->
            var j = i
            while (j-- > 0)
                arr[arrIndex++] = index + minVal
        }
    }
}

fun main() {
    val list = mutableListOf(-6, 2, 8, 5, 9, 0, -1, 3, 7, 4)
    CountingSort.sort(list)
    print(list)
}