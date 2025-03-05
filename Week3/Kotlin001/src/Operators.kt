class Operators {
    fun add(a: Double, b: Double): Double {
        return (a + b)
    }

    fun subtract(a: Double, b: Double): Double {
        return (a - b)
    }

    fun multiply(a: Double, b: Double): Double {
        return (a * b)
    }

    fun divide(a: Double, b: Double): Double {
        return (a / b)
    }

    fun modulus(a: Int, b: Int): Int {
        return (a % b)
    }

    //In functions in Kotlin the parameters are by default val so they are mutable and cannot be changed
    fun increment(a: Int): Int {
        return a+1
    }

    fun decrement(a: Int): Int {
        return a-1
    }

    fun and(a: Int, b: Int): Int {
        return a and b
    }

    fun or(a: Int, b: Int): Int {
        return a or b
    }

    fun rightShift(a: Int, b: Int): Int {
        return a shr b
    }

    fun leftShift(a: Int, b: Int): Int {
        return a shl b
    }

    fun greater(a: Double, b: Double): Boolean {
        return a > b
    }

    fun lesser(a: Double, b: Double): Boolean {
        return a < b
    }

    fun equals(a: Double, b: Double): Boolean {
        return a == b
    }
}
