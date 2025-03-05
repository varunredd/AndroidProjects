import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("\nEncapsulation")

    val employee = Employee()
    employee.setEmployeeId("EMP001")
    employee.setName("Varun")
    employee.setAge(23)

    println("Employee Id: " + employee.getEmployeeId() + " Name: " + employee.getName() + " Age: " + employee.getAge())

    println("\nInheritance");
    val dog = Dog()
    dog.sound()
    dog.moveOn()

    println("\nMethod Overloading");
    val bike = Bike()
    bike.functionality("Brake", "Cruise")
    bike.functionality("Brake", "Cruise", "Oil")
    bike.functionality(220.52, "Weight")

    println("\nMethod Overriding")
    val bike1 = RoyalEnfield()
    bike1.functionality("Brake", "Cruise")

    System.out.println( "\nAbstraction" )
    val food2 = Food2( )
    food2.taste( )//taste is a method from a abstract class Food 1 which implements interface Food
    food2.energy( )// energy is from a concrete class which extended a abstract class Food1 so it implement methods missing in abstract class

    val food3 =  Food3( )//It is a concrete class which implements a interface Food so it should implement both methods undefined in interface
    food3.taste( )
    food3.energy( )

    println("\nOperators")
    val operators = Operators()
    println("Addition: " + operators.add(5.5, 3.2))
    println("Subtraction: " + operators.subtract(5.5, 3.2))
    println("Multiplication: " + operators.multiply(5.5, 3.2))
    println("Division: " + operators.divide(5.5, 3.2))
    println("Modulus: " + operators.modulus(10, 3))
    println("Increment: " + operators.increment(5))
    println("Decrement: " + operators.decrement(5))
    println("AND: " + operators.and(5, 3))
    println("OR: " + operators.or(5, 3))
    println("Right Shift: " + operators.rightShift(16, 2))
    println("Left Shift: " + operators.leftShift(4, 2))
    println("Greater: " + operators.greater(5.5, 3.2))
    println("Lesser: " + operators.lesser(5.5, 3.2))
    println("Equals: " + operators.equals(5.5, 3.2))

    println("\nDatatypes")
    val datatypes = Datatypes()
    datatypes.display()

    val scanner = Scanner(System.`in`)
    println("\nIf - Else Switch Case Demonstration")
    val grading = Grading()
    grading.gradingSystem(scanner)

    println("\nFor While and Do-While Demonstration")
    val numbers = Numbers()
    numbers.Operations(scanner)
    scanner.close()

//    var student = Student("Varun")

}