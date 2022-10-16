package practice01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  GlobalScope.launch {
    delay(1_000L)
    println("Naoto.")
  }

  println("My name is ")
  Thread.sleep(2_000L)

  runBlocking {
    launch {
      delay(1000L)
      println("Naoto.")
    }
    println("My name is ")
  }

  suspend fun printName() {
    delay(1000L)
    println("Naoto.")
  }

  runBlocking {
    launch { printName() }
    println("My name is ")
  }

  runBlocking {
    val result = async {
      delay(2000L)
      var sum = 0
      for (i in 1..10) sum += i
      sum
    }
    println("計算中")
    println("sum=${result.await()}")
  }

  runBlocking {
    val num1 = async {
      delay(2000L)
      1 + 2
    }

    val num2 = async {
      delay(1000L)
      3 + 4
    }

    println("sum=${num1.await()} + ${num2.await()}")
  }
}