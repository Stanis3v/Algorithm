/**
 * Task:
 *Write a function that receives two sequences: A and B of integers and returns one sequence C.
 *Sequence C should contain all elements from sequence A (maintaining the order) except those,
 *that are present in sequence B p times, where p is a prime number.
 *
 *Example:
 *A=[2,3,9,2,5,1,3,7,10]
 *B=[2,1,3,4,3,10,6,6,1,7,10,10,10]
 *C=[2,9,2,5,7,10]
 */

fun main() {
    val integerListA: MutableList<Int> = ArrayList()
    integerListA.add(2)
    integerListA.add(3)
    integerListA.add(9)
    integerListA.add(2)
    integerListA.add(5)
    integerListA.add(1)
    integerListA.add(3)
    integerListA.add(7)
    integerListA.add(10)
    val integerListB: MutableList<Int> = ArrayList()
    integerListB.add(2)
    integerListB.add(1)
    integerListB.add(3)
    integerListB.add(4)
    integerListB.add(3)
    integerListB.add(10)
    integerListB.add(6)
    integerListB.add(6)
    integerListB.add(1)
    integerListB.add(7)
    integerListB.add(10)
    integerListB.add(10)
    integerListB.add(10)
    println(algorithm(integerListA, integerListB))
}

private fun algorithm(integerListA: List<Int>, integerListB: List<Int>): List<Int> {
    val listBMap: MutableMap<Int, Int?> = HashMap()
    for (itemB in integerListB) {
        if (listBMap.containsKey(itemB)) {
            val itemBCount = listBMap[itemB]
            itemBCount?.plus(1)
            listBMap[itemB] = itemBCount
        } else {
            listBMap[itemB] = 1
        }
    }
    val outputListA: MutableList<Int> = ArrayList(integerListA)
    for (itemA in integerListA) {
        val itemCountInB = listBMap[itemA] ?: continue
        if (isPrime(itemCountInB)) {
            outputListA.remove(itemA)
        }
    }
    return outputListA
}

private fun isPrime(number: Int): Boolean {
    if (number == 1) {
        return false
    }
    for (i in 2 until number) {
        if (number % i == 0) return false
    }
    return true
}
