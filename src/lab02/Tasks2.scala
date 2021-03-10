package lab02

object Tasks2 {
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
}
