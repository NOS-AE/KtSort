package sort

import kotlin.math.floor

object BucketSort {

    private const val BUCKET_SIZE = 5

    @JvmStatic
    fun sort(arr: MutableList<Int>) {
        val max = arr.max() ?: return
        val min = arr.min() ?: return
        val bucketCount = floor((max - min) / BUCKET_SIZE.toDouble()).toInt() + 1
        val buckets = MutableList<MutableList<Int>>(bucketCount) {
            mutableListOf()
        }
        arr.forEach {
            val bucketIndex = floor((it - min) / BUCKET_SIZE.toDouble()).toInt()
            buckets[bucketIndex].add(it)
        }
        var i = 0
        buckets.forEach { bucket ->
            InsertionSort.sort(bucket) // Use InsertionSort for each bucket
            bucket.forEach {
                arr[i++] = it
            }
        }
    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    BucketSort.sort(list)
    print(list)
}