package practice01

import kotlin.math.sqrt

data class Vec(val x: Int, val y: Int) {
  operator fun plus(other: Vec): Vec = Vec(x + other.x, y + other.y)
  operator fun compareTo(other: Vec): Int = euclideanDistance().compareTo(other.euclideanDistance())
  fun euclideanDistance(): Double = sqrt((x * x + y * y).toDouble())
}

fun main() {
  val vec1 = Vec(1, 3)
  val vec2 = Vec(2, 4)
  println(vec1 + vec2)
}