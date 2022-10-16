package practice01

open class Animal(private val name: String) {
  fun showName() = println("name is $name")
  open fun cries() = println("")
}