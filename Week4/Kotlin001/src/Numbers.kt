import java.util.*

class Numbers {
    fun Operations(scanner: Scanner){
        println("Enter a number (N) to print the first N natural numbers: ")
        val n = scanner.nextInt()
        println("The first $n natural numbers are:")
        for (i in 0..n step 1){
            println(i);
        }

        println("Enter a number (M) to calculate its factorial: ")
        val m = scanner.nextInt()
        var k = m
        var l: Long = 1;
        while (k > 1){
            l = (l * k--);
        }
        println(l)

        println("Enter a number (J) to calculate the sum of all even numbers up to J: ")
        val j = scanner.nextInt()
        var sum = 0
        var num = 2
        do{
            sum += num
            num += 2
        }while (num < j)
        println(sum)
    }
}
