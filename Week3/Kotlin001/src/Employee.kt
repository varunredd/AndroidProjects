class Employee {

    private var age: Int? = null


    private var name: String? = null


    private var employeeId: String? = null


    fun setAge(age : Int){
        this.age = age
    }

    fun getAge() : Int? {
        return this.age;
    }

    fun setName(name : String){
        this.name = name
    }

    fun getName() : String? {
        return this.name;
    }

    fun setEmployeeId(employeeId : String){
        this.employeeId = employeeId
    }

    fun getEmployeeId() : String? {
        return this.employeeId;
    }

    override fun toString(): String {
        return "Employee(age=$age, employeeId=$employeeId, name=$name)"
    }
}