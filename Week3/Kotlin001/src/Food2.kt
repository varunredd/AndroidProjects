interface Food{
    fun taste();
    fun energy();
}

abstract class Food1 : Food {
    override fun taste(){
        println("Sweet")
    }
}

class Food2 : Food1(){
    override fun energy() {
        println("820 calories")
    }
}

class Food3 : Food {
    override fun taste() {
        println("Hot")
    }

    override fun energy() {
        println("1020 Calories")
    }
}