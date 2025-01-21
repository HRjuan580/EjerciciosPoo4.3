

enum class CategoriaIMC(val descripcion: String) {
 peso_bajo("Peso insuficiente"),
 peso_saludable("Peso saludable"),
 sobrepeso("Sobrepeso"),
 obesidad("Obesidad")
}
data class Persona(
 val nombre: String,
 val altura: Double,
 val peso: Double
){
 fun saludar () = "Hola, mi nombre es $nombre."

 private fun calcularIMC() = peso / (altura * altura)

 private fun obtenerCategoriaIMC(imc: Double) = when {
  imc < 18.5 -> CategoriaIMC.peso_bajo
  imc in 18.5..24.9 -> CategoriaIMC.peso_saludable
  imc in 25.0..29.9 -> CategoriaIMC.sobrepeso
  imc < 30.0 -> CategoriaIMC.obesidad
 }

 fun obtenerDesc(): String {
  val imc =  calcularIMC()
  val categoria = obtenerCategoriaIMC(imc)
  val alturaDesc = if (altura >= 1.75) "Por encima de la media" else "Por debajo de la media"
  val pesoDesc = if (peso >= 70) "Por encima de la media" else "Por debajo de la media"
  return "$nombre con una altura de $altura m ($alturaDesc) y un peso de $peso kg ($pesoDesc) tiene un IMC de ${"%.2f".format(imc)} (${categoria.descripcion})"
 }
}

fun main(){
 val personas = listOf(
  Persona("Julia", 1.72, 64.7),
  Persona("Pablo", 1.90, 72.9),
  Persona("Juan", 1.90, 76.7)
  Persona("Santiago", 2.09, 87.7)
 )
 for (persona in personas) {
  println(persona.saludar())
  println(persona.obtenerDesc())
  println()
 }
}
