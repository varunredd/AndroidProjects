//In kotlin classes are final by declaration to extend the classes we need to declare them as open
open class Animal {
    private var height: Double? = null;
    private var weight: Double? = null;
    private var category: String? = null;

    fun moveOn(){
        println("Move On")
    }

    open fun sound(){
        println("Sound")
    }

}

class Dog: Animal() {

    override fun sound(){
        println("Bark")
    }
}
