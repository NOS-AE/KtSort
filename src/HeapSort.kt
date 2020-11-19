package sort

object HeapSort {
    @JvmStatic
    fun <T : Comparable<T>> sort(arr: MutableList<T>) {
        var heap = arr.toMutableList()
        buildHeap(heap)
        var i = 0
        while (heap.isNotEmpty()) {
            arr[i++] = heap[0]
            heap[0] = heap.last()
            heap = heap.dropLast(1).toMutableList()
            heapify(heap)
        }
    }

    private fun <T : Comparable<T>> buildHeap(arr: MutableList<T>) {
        for (i in arr.indices.reversed()) {
            heapify(arr.subList(i, arr.size))
        }
    }

    /**
     * 左右子树已成堆，下沉根节点
     */
    private fun <T : Comparable<T>> heapify(arr: MutableList<T>) {
        var child = if (arr.size > 1) 1 else return
        if (arr.size > 2 && arr[1] > arr[2])
            child = 2
        if (arr[0] > arr[child])
            swap(arr, 0, child)
        else
            return
        heapify(arr.subList(child, arr.size))

    }
}

fun main() {
    val list = mutableListOf(6, 2, 8, 5, 9, 0, 1, 3, 7, 4)
    HeapSort.sort(list)
    print(list)
}