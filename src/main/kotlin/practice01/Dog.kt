package practice01

class Dog(name: String) : Animal(name) {
  override fun cries() = println("bowwow")
}