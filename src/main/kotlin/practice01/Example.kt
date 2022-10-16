package practice01

fun main() {
  println("Hello Kotlin.")
  Dog("ぽち").cries()

  val user1 = User("user", "1234")
  val user2 = User("user", "1234")
  val user3 = User("user")
  val userSet = setOf(user2, user3)

  println(user1)
  println(user2)
  println("user1 == user2: ${user1 == user2}")
  println(userSet.contains(user1))

  val calc: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }

  println(calc(10, 20))

  printResult(2, 3, mul)

  println(20.square())

}

// 高階関数
fun printResult(a: Int, b: Int, func: Calc) = println(func(a, b))

// 関数リテラル
val mul: (Int, Int) -> Int = { val1, val2 -> val1 * val2 }

// タイプエイリアス
typealias Calc = (Int, Int) -> Int

// 拡張関数
fun Int.square() = this * this
