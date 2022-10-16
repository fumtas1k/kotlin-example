package practice01

import kotlin.reflect.KProperty

interface CalculationExecutor {
  val message: String
  fun calc(num1: Int, num2: Int): Int
  fun printStartMessage()
}

class CommonCalculationExecutor(override val message: String = "calc") : CalculationExecutor {
  override fun calc(num1: Int, num2: Int): Int {
    throw IllegalStateException("Not implements calc")
  }

  override fun printStartMessage() {
    println("start $message")
  }
}

class AddCalculationExecutor(private val calculationExecutor: CalculationExecutor) : CalculationExecutor {
  override val message: String
    get() = calculationExecutor.message

  override fun calc(num1: Int, num2: Int): Int = num1 + num2

  override fun printStartMessage() {
    calculationExecutor.printStartMessage()
  }
}

class AddCalculationExecutorDelegate(private val calculationExecutor: CalculationExecutor) :
  CalculationExecutor by calculationExecutor {
  override fun calc(num1: Int, num2: Int): Int = num1 + num2
}

class Person() {
  var name: String by DelegateWithMessage()
  var address: String by DelegateWithMessage()
}

class DelegateWithMessage<T> {
  private var value: T? = null

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    println("${property.name}を取得します")
    return value!!
  }

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    println("${property.name}を更新します")
    this.value = value
  }
}

fun main() {
  val executor = AddCalculationExecutor(CommonCalculationExecutor())
  executor.printStartMessage()
  println(executor.calc(8, 11))

  val executor1 = AddCalculationExecutorDelegate(CommonCalculationExecutor())
  executor1.printStartMessage()
  println(executor1.calc(8, 11))

  val person = Person().apply {
    name = "taro"
    address = "Tokyo"
  }
  person.name
}