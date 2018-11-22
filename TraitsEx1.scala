package org.learn.scala

import scala.collection.mutable.ArrayBuffer

object Test {
  def main(args: Array[String]) {
    var p: Philos = new Frog
    p.philos()
    println(p)
    val f1 = new Frog
    val f2 = new Frog
    println(f1 < f2)

    val intQueue = new BasicQueue
    intQueue.put(200)
    intQueue.put(300)
    println(intQueue.get())
    println(intQueue.get())

    val t = new BasicQueue with Double with Incrementing with Filting
    t.put(1)
    println(t.get())
    t.put(-1)
    t.put(1)
    println(t.get())
  }

}

trait Philos {
  def philos(): Unit = {
    println("i consume memory")
  }
}

trait HasLeg

class Animal

class Frog extends Animal with Philos with HasLeg with Ordered[Frog] {
  override def toString: String = "green"

  override def philos(): Unit = {
    println("i am green")
  }

  override def compare(that: Frog): Int = {
    println(this.hashCode() + "\t" + that.hashCode())
    this.hashCode() - that.hashCode()
  }
}

abstract class IntQueue {
  def put(x: Int)

  def get(): Int
}

class BasicQueue extends IntQueue {
  private val arrayBuffer = new ArrayBuffer[Int]

  override def put(x: Int): Unit = arrayBuffer += x

  override def get(): Int = arrayBuffer.remove(0)
}

trait Double extends IntQueue {
  abstract override def put(x: Int) {
    println("In Double")
    super.put(x * 2)
  }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {

    println("In Incrementing")
    super.put(x + 1)
  }
}

trait Filting extends IntQueue {
  abstract override def put(x: Int) {

    if (x > 0) {
      println("In Filting")
      super.put(x)
    }
  }
}
