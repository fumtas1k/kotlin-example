package practice01

sealed class Platform {
  abstract fun showName()
}

class AndroidPlatform() : Platform() {
  override fun showName() = println("Android.")
}

