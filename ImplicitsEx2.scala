ImplicitDemo

package org.learn.scala

object ImplicitDemo {

  implicit def doubleToInt(d: scala.Double) = {
    println("double to int")
    d.toInt
  }

  implicit def intToString(i: Int) = {
    println("Implicit call")
    i.toString
  }

  def main(args: Array[String]) {
    var i: Int = 10.5d
    var j: String = 5
    j = "jui"
    implicit val p: ProPre = new ProPre("what")
    implicit val p1: ProDrink = new ProDrink("hello world")
    Greeter.greet("what")
  }
}

class ProPre(val propre: String)
class ProDrink(val propre: String)

object Greeter {
  def greet(name: String)(implicit prompt: ProPre, drink: ProDrink): Unit = {
    println(name)
    println(prompt.propre)
    println(drink.propre)
  }

}
