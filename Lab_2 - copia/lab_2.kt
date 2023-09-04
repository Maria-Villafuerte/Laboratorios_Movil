private fun calcularPromedio (){
    val numbers = listOf(5, 2, 10, 4)
    val suma = numbers.reduce { sum, element -> sum + element }
    val tamaño = numbers.size
    var promedio = suma/tamaño
    println(promedio)
}
private fun filter(){
    val numbers_list = listOf(5,3, 2, 10, 4,6,7,9,34,23,56)
    //El símbolo % significa modulo, que lo qu ehace es darnos el residuo, en caso de que el residio de x%2 sea 0 es por que es par
    var filterelist = numbers_list.filter{it % 2 != 0}
    println(filterelist)
}

private fun isPalindrome(cadena: String){
    // no sera Palidreome hasta compribar lo contrario
    var es_Palidrome = false
    if(cadena == cadena.reversed()) {
        es_Palidrome = true
        println("$cadena Si es Palidrome" )
    }else  {
        println("$cadena No es Palidrome" )
    }

}
private fun saludo (){
    val nombres = listOf("Pedro", "Mario", "Juan", "Maria", "José")
    println(nombres.map { "¡Saludos, $it!" })
}

private fun performOperation(ent_1: Int, ent_2:Int, lam_1: (Int,Int)->Int):Int{
    return lam_1(ent_1,ent_2)
}
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: Int)
private fun creacion_de_estudainte(peronas: List<Person>, id:List<Int>):List<Student>{

    return peronas.zip(id) { perso_temp, id_temp ->
        Student(perso_temp.name, perso_temp.age, perso_temp.gender, id_temp)
    }
}

fun main() {
    println("Task # 1:")
    calcularPromedio()

    println("\nTask # 2:")
    filter()

    println("\nTask # 3:")
    var prueba_1 = "pato"
    val prueba_2 = "racecar"
    isPalindrome(prueba_1)
    isPalindrome(prueba_2)

    println("\nTask # 4:")
    saludo()

    println("\nTask # 5:")
    val resultado = performOperation(8,10,){ x, y -> x + y }
    println("El resultado de x, y -> x + y para (8,10) es de $resultado")

    println("\nTask # 6:")
    val lista_personas = listOf<Person>(
            Person("María", 18,"Femenino"),
            Person("Pedro",20,"Masculino"),
            Person("Juan",23,"Masculino"),
            Person("Lucía",24,"Femenino")
    )
    val id_list = listOf<Int>(23132,21453,20053,19345)
    val estudiante_creados = creacion_de_estudainte(lista_personas,id_list)
    for (estudiante_temp in estudiante_creados) {
        println("Estudiante: ${estudiante_temp.name}, Edad: ${estudiante_temp.age}, Género: ${estudiante_temp.gender}, ID: ${estudiante_temp.studentId}")

    }

}