import java.util.*

class Grading {
    fun gradingSystem(scanner: Scanner) {
        println("Enter the student's name: ");
        var studentName: String = scanner.nextLine();

        System.out.print("Enter the student's marks for Mathematics: ");
        var mathMarks: Double = scanner.nextDouble();

        System.out.print("Enter the student's marks for Science: ");
        var scienceMarks: Double = scanner.nextDouble();

        System.out.print("Enter the student's marks for English: ");
        var englishMarks: Double = scanner.nextDouble();

        var totalMarks: Double = mathMarks + scienceMarks + englishMarks;
        var averageMarks: Double = totalMarks / 3;
        var grade: Char;

        println("\nCalculating the results for $studentName ");

        if (averageMarks >= 90) {
            grade = 'A'
        } else if (averageMarks >= 75) {
            grade = 'B'
        } else if (averageMarks >= 60) {
            grade = 'C'
        } else if (averageMarks >= 50) {
            grade = 'D'
        } else {
            grade = 'F'
        }

        println("\nResults for $studentName")
        println("Total Marks: $totalMarks")
        println("Average Marks: $averageMarks");
        println("Grade: $grade");

        println("\nWould you want to perform another action?");
        println("1. View detailed grade");
        println("2. Exit");
        println("Enter your choice (1-2): ");
        var choice: Int = scanner.nextInt();



        // Start a loop that will keep running until input is 2
        while (true) {
            println("\nWould you want to perform another action?");
            println("1. View detailed grade");
            println("2. Exit");
            println("Enter your choice (1-2): ");
            choice = scanner.nextInt()  // Safely read and parse the input
            when (choice){

                1 -> {
                    when (grade) {
                        'A' -> println("Grade A: Excellent performance. Keep it up!")
                        'B' -> println("Grade A: Excellent performance. Keep it up!")
                        'C' -> println("Grade A: Excellent performance. Keep it up!")
                        'D' -> println("Grade A: Excellent performance. Keep it up!")
                        'F' -> println("Grade A: Excellent performance. Keep it up!")
                        else -> println("Invalid Grade")
                    }

                }

                2 -> {
                    println("Exiting .........")
                    break
                }

                else -> {
                    println("Invalid option. Code Terminated")
                    break
                }
            }

        }

    }
}
