package sort

fun <T> swap(arr: MutableList<T>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}