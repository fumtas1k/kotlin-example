package practice02

fun main() {
  val dog = DogKotlin()
  dog.cry()

  val user = UserJava(1111, "taro")
  println(user.id)

  val func = CalcJava { num1, num2 -> num1 + num2 }
  println(func.calc(1, 3))

  executeCalc(2, 4) { num1, num2 -> num1 * num2 }

  println(CompanyConstants.maxEmployeeCount)
}

fun executeCalc(num1: Int, num2: Int, func: CalcJava) {
  println(func.calc(num1, num2))
}
