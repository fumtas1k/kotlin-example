package practice01

fun main() {
  // これを実現する
  val list = mutableListOf<Int>()
  for (i in 1..10) if (i % 2 == 1) list.add(i)
  val oddNumbers = list.joinToString(separator = " ")
  println(oddNumbers)

  // with
  val oddNumbersWith = with(mutableListOf<Int>()) {
    (1..10 step 2).forEach { add(it) }
    joinToString(separator = " ")
  }
  println(oddNumbersWith)

  // run
  val oddNumbersRun = mutableListOf<Int>().run {
    (1..10 step 2).forEach { add(it) }
    joinToString(separator = " ")
  }
  println(oddNumbersRun)
  println(setUserNameAndGetString(UserD("taro"), "jiro"))

  // let
  val oddNumbersLet = mutableListOf<Int>().let { list ->
    (1..10 step 2).forEach { list.add(it) }
    list.joinToString(separator = " ")
  }
  println(oddNumbersLet)
  println(createUserD("saburo"))
  println(createUserD(null))

  // apply
  val oddNumbersApply = StringBuilder("").apply {
    this.append((1..10).filter { it % 2 == 1 }.joinToString(separator = " "))
  }
  println(oddNumbersApply)

  // also
  val oddNumbersAlso = StringBuilder("").also { str ->
    str.append((1..10).filter { it % 2 == 1 }.joinToString(separator = " "))
  }
  println(oddNumbersAlso)
  println(updateUser(null, "shiro"))
}

data class UserD(var name: String)

// run
fun setUserNameAndGetString(user: UserD?, newName: String): String? = user?.run {
  name = newName
  toString()
}

// let
fun createUserD(name: String?) = name?.let { UserD(it) }

// also
fun updateUser(user: UserD?, newName: String): UserD? = user?.also { it.name = newName }

// apply
