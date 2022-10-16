package practice01

fun main() {
  val list = List(3) { it }
  list.forEach(::println)
  val idList = list.map { it * 10 }
  println(idList)
  val userList = listOf(User("taro"), User("jiro"), User("saburo"), User("taro"))
  val userIdList = userList.map { it.id }
  userIdList.forEach(::println)
  val taroList = userList.filter { it.name == "taro" }
  print("taro: ")
  taroList.forEach(::print)

  println("")
  println("taro1: " + userList.first { it.name == "taro" })
  println("saburo: " + userList.firstOrNull { it.name == "saburo" })
  println("goro: " + userList.firstOrNull { it.name == "goro" })

  val userNames = userList.map(User::name)
  println(userNames)
  println(userNames.distinct())

  // keyを指定し、中身をvalue
  val userMap = userList.associateBy(User::id)
  println(userMap)

  // valueを指定し、中身をkey
  val userNameMap = userNames.associateWith(String::length)
  println(userNameMap)

  // keyを指定し、中身をlistにしてvalue
  val userListMap = userList.groupBy(User::name)
  println(userListMap)

  // count
  val taroCount = userList.count { it.name == "taro" }
  println(taroCount)

  // chunked
  val userChunkedList = userList.chunked(2)
  println(userChunkedList)

  val numList = List(10) { it }
  val sumNum = numList.reduce { acc, i -> acc + i }
  val mulNum = numList.fold(0) { acc, i -> acc * i }
  println(sumNum)
  println(mulNum)
  println(numList.sum())
  println(userNames.reduce { acc, i -> acc + i })

  // 
  val cSum = numList.fold(mutableListOf<Int>(0)) { acc, i -> acc.also { it.add(it.last() + i) } }
  cSum.remove(0)
  println(cSum)
}