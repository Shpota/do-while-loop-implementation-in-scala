Functional implementation of DO-WHILE loop
==========================================

Scala is wery powerfool language. Almost every scala feature may be implemented using only built in language features. I want to demonstrate how to implementat a loop.

##
Scala already has ```do-while``` loop, that is why I'm using ```repeat-until``` naming in the example.

We want to implement something like this:
```scala
repeat {
  // do some stuff
} until (condition)
```
To achive this goal we have to declare a function ```repeat``` which will repeat some actions. The second part is the  function ```until```. It will have ```condition``` as an argument to contorol the loop. Finally we need to wire both the functions. To be able to do that we'll declare ```until``` function as a method inside the object returned by ```repeat``` function. 
Sounds complicated, let's take a look on the code:
```scala
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
```
As you can see we have anonymous object inside function body and one more functions inside. That means that the object will be returned by ```repeat``` so we can invoke ```until``` directly after ```repeat``` invocation.
The function body itself is pretty simple. First we invoke ```command``` and then depending on ```condition``` we decide if we need to terminate or we need to make one more recursive call.

Let's see how it works on example:
```scala
var i = 0
repeat {
  println("Iteration #" + i)
  i = i + 1
} until (i < 5)
```
The output as you may expect will be:
```
Iteration #0
Iteration #1
Iteration #2
Iteration #3
Iteration #4
```

#How to run the code
1) You need to have Scala SDK installed on your machine

2) Run Scala console
```bash
$ scala
```
3) Run the code
```bash
scala> :load loop.scala
```


