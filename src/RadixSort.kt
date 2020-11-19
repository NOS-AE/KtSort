package sort

import kotlin.math.log10

object RadixSort {
    @JvmStatic
    fun sort(arr: MutableList<Int>) {
        val max = arr.max() ?: return
        val digitCount = log10(max.toDouble()).toInt() + 1
        val buckets = List(11) {
            mutableListOf<Int>()
        }
        var digit = 1
        for (i in 0 until digitCount) {
            arr.forEach {
                val index = (it / digit) % 10
                buckets[index].add(it)
            }
            var index = 0
            buckets.forEach { bucket ->
                bucket.forEach {
                    arr[index++] = it
                }
                bucket.clear()
            }
            digit *= 10
        }
    }
}

fun main() {
    val list = mutableListOf(61, 2, 8, 55, 9, 3300, 18, 3, 744, 4)
    RadixSort.sort(list)
    print(list)
}