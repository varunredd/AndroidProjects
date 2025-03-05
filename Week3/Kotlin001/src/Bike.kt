open class Bike {
    open fun functionality(a: String , b: String ){
        println( "Functionality $a $b"  )
    }
    fun functionality(a: String , b: String , c: String){
        println( "Functionality $a $b $c"  )

    }
    fun functionality(a: Double , b: String ){
        println( "Functionality $a $b"  )

    }

}

class RoyalEnfield : Bike() {
    override fun functionality(a: String, b: String){
        println("Functionality Updated $a $b")
    }

}

















//open class Employee1 {
//    var name :String? = null
//    constructor( name: String,  age: Int){
//        println("Parent Constructor Invoked fff")
//    }
//    constructor( name: String ){
//        println("Parent Constructor Invoked ggg $name")
//    }
//    constructor(){
//        println("Parent Constructor Invoked mmm")
//
//    }
//    open fun work() {
//        println("$name is working.")
//    }
//}
//
//class Student(name1: String) : Employee1(name = name1, age=12){
//    override fun work(){
//
//    }
//}
