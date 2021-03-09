package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Tasks {
  /* Tasks - part 2a (funtions) */
  /* 3 a) */
  // lambda
  val parity: Int => String = {
    case n if n%2 == 0 => "even"
    case _ => "odd"
  }

  @Test def testCount(): Unit ={

  }
  // method syntax
  def parity2(x: Int): String = x match {
    case x if x%2 == 0 => "even"
    case _ => "odd"
  }

  /* 3 b) */
  val empty: String => Boolean = _ == ""

  // lambda
  val neg: (String => Boolean) => (String => Boolean) = f => (s => !f(s))
  val notEmpty: String => Boolean = neg(empty)
  // method syntax
  def neg2 (p: (String) => Boolean): (String => Boolean) =
    (x:String) => !p(x)



  val notEmpty1: Boolean = neg("foo", neg(empty))
  println(notEmpty1)
  val notEmpty2: Boolean = neg("", neg(empty))
  println(notEmpty2)
  val notEmpty3: (String => Boolean) = neg2(empty)
  println(notEmpty3("foo"))
  println(notEmpty3(""))

  /* 3 c) */
  def neg[A] (p: (A) => Boolean): (A => Boolean) =
    (x:A) => !p(x)

  /* 4 curring */
  // val curriedMultAsFunction: Double => Double => Double = x => y => x*y
  // val p1 = (x:Double) => (y:Double) => (z:Double) => x <= y <= z
  //def p3(x:Double)(y:Double)(z:Double): Boolean = (x <= y <= z

}
