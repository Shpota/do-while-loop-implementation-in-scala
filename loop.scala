def repeat(command: => Unit) = {
   new {
    def until(condition: => Boolean): Unit = {
      command
      if (condition)
        until(condition)
      else ()
    }
  }
}

var i = 0
repeat {
  println("Itteration #" + i)
  i = i + 1
} until (i < 10)
  