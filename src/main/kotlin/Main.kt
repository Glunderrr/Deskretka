fun main() {
    val union = mutableListOf<Int>()
    val section = mutableListOf<Int>()
    val difference1 = mutableListOf<Int>()
    val difference2 = mutableListOf<Int>()
    val unionDifference = mutableListOf<Int>()

    println("\nПослідовно введіть елементи першої множини")
    val array1 = Array(10) { readln().toInt() }
    println("\nПослідовно введіть елементи другої множини")
    val array2 = Array(10) { readln().toInt() }

    println("\n\nПерша множина:")
    array1.forEach { print("$it ") }
    println("\n\nДруга множина:")
    array2.forEach { print("$it ") }

    array1.forEachIndexed { index, element -> union.add(element); union.add(array2[index]) }
    union.sort()
    println("\n\nОб'єднання множин:")
    union.forEach { print("$it ") }

    array1.forEach { array2.forEach { element -> if (it == element) section.add(it) } }
    println("\n\nПереріз множин:")
    section.forEach { print("$it ") }

    var flag1 = true
    array1.forEach {
        flag1 = true;array2.forEach { element -> if (it == element) flag1 = false }
        if (flag1) difference1.add(it)
    }
    println("\n\nРізниця першої множини від другої:")
    difference1.forEach { print("$it ") }

    var flag2 = true
    array2.forEach {
        flag2 = true;array1.forEach { element -> if (it == element) flag2 = false }
        if (flag2) difference2.add(it)
    }
    println("\n\nРізниця другої множини від першої:")
    difference2.forEach { print("$it ") }

    println("\n\nсиметрична різниця двох множин:")
    difference1.forEach { unionDifference.add(it) }
    difference2.forEach { unionDifference.add(it) }
    unionDifference.sorted()
    unionDifference.forEach { print("$it ") }
}