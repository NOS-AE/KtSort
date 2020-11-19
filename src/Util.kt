package sort

fun <T>MutableList<T>.swap(i: Int, j: Int) {
    val tmp = this[i] // “this”对应该列表
    this[i] = this[j]
    this[j] = tmp
}