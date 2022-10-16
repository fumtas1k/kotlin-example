package practice01

import java.util.*

class User(
  val name: String,
  val id: String = UUID.randomUUID().toString()
) {
  override fun toString(): String = "${super.toString()} ${this.hashCode()}"

  override fun equals(other: Any?): Boolean {
    if (other !is User) return false
    return this.id == other.id
  }

  override fun hashCode(): Int = id.hashCode() + 1
}
