package lab02

import lab02.Tasks3._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class Tasks3Test {

  @Test def testFibonacci() {
    assertEquals(0, fibonacci(0))
    assertEquals(1,fibonacci(1))
    assertEquals(1,fibonacci(2))
    assertEquals(2,fibonacci(3))
    assertEquals(3,fibonacci(4))
    assertEquals(-1,fibonacci(-5))
  }

  @Test def testFibRecursion(): Unit = {
    // tail recursion version:
    assertEquals(0, fib(0))
    assertEquals(1,fib(1))
    assertEquals(1,fib(2))
    assertEquals(2,fib(3))
    assertEquals(3,fib(4))
  }
}

