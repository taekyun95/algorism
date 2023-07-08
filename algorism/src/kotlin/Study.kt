package kotlin

fun main() {
    val numbers = generateSequence(3) { n ->
        println("generateSequence")
        (n + 1).takeIf { it < 7 }
    }
    println(numbers.first())
    println(numbers.toString())
}
