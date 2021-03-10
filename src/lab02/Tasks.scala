package lab02

import Optionals._

object Tasks {
  /*--- Tasks - part 2a (functions) ---*/

  /* a) */
  // lambda
  val parity: Int => String = {
    case n if n%2 == 0 => "even"
    case _ => "odd"
  }
  // method syntax
  def parity2(x: Int): String = x match {
    case x if x%2 == 0 => "even"
    case _ => "odd"
  }

  /* b) */
  // lambda
  val neg: (String => Boolean) => String => Boolean = p => !p(_)
  // method syntax
  def neg2(p2: String => Boolean): String => Boolean = !p2(_)

  /* c) */
  def neg3[A](p3: A => Boolean): A => Boolean = !p3(_)

  /*--- Tasks - part 2b (functions) ---*/

  /* 4. Currying */
  val predicate1: Double => Double => Double => Boolean = x => y => z => (x <= y) && (y <= z)
  val predicate2: (Double, Double, Double) => Boolean = (x,y,z) => (x <= y) && (y <= z)
  def predicate3(x:Double)(y:Double)(z:Double): Boolean = (x <= y) && (y <= z)
  def predicate4(x:Double, y:Double, z:Double): Boolean = (x <= y) && (y <= z)

  /* 5. */
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  // generic version
  def composeG[A] (f: A => A, g: A => A): A => A = x => f(g(x))

  /*--- Tasks - part 3 (recursion) ---*/

  /* 6. */
  // version non tail recursion
  def fibonacci(n:Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case n if n > 1 => fibonacci(n - 1) + fibonacci(n - 2)
    case n if n < 0 => -1 // per evitare il loop infinito in caso si inserisca un numero negativo
  }
  // tail rec version:
  def fib(n: Int): Int = {
     @annotation.tailrec
    def _fib(n: Int, a: Int, b:Int): Int = n match {
       case 0 => a
       case 1 => b
       case _ => _fib(n - 1, b, b + a)
     }
    _fib(n, 0, 1)
  }

  /*--- Tasks - part 4 (sum types, product types, modules) ---*/

  /* 7. */
  trait Shape

  object Shape {
    case class Rectangle(base: Double, height: Double) extends Shape
    case class Circle(radius: Double) extends Shape
    case class Square(side: Double) extends Shape

    def perimeter(s: Shape): Double = s match {
      case Rectangle(b, h) => (b + h) * 2
      case Circle(radius) => 2 * math.Pi * radius
      case Square(side) => 4 * side
    }

    def area(s: Shape): Double = s match {
      case Rectangle(b, h) => b * h
      case Circle(radius) => math.Pi * radius * radius
      case Square(side) => side * side
    }
  }

  /*--- Tasks - part 5 (more functional combinators) ---*/

  /* 8. */
}
