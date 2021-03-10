package lab02

object Tasks3 {
  /*--- Tasks - part 3 (recursion) ---*/

  /* 6. */
  // version non tail recursion
  def fibonacci(n:Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case n if n > 1 => fibonacci(n - 1) + fibonacci(n - 2)
    case n if n < 0 => -1 // to avoid infinite loop in case of negative number
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
}
