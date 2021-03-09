package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import lab02.Tasks._

class TasksTest {

  @Test def testParity():Unit={
    val a = 3
    val b = 4

    assertEquals("odd", parity(a))
    assertEquals("odd", parity2(a))
    assertEquals("even", Tasks.parity(b))
    assertEquals("even", Tasks.parity2(b))
  }

  @Test def testNeg():Unit = {
    val empty: String => Boolean =  _ == ""
    val notEmpty: String => Boolean = neg(empty)
    val notEmpty2: String => Boolean = neg2(empty)

    assertTrue(notEmpty("foo"))
    assertTrue(notEmpty2("foo"))
    assertFalse(notEmpty(""))
    assertFalse(notEmpty2(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))
    assertTrue(notEmpty2("foo") && !notEmpty2(""))
  }

  @Test def testNegGeneric():Unit = {
    val even: Int => Boolean = _ %2 == 0
    val notEven: Int => Boolean = neg3[Int](even)
    val odd: Double => Boolean = _ %2.0 != 0
    val notOdd: Double => Boolean = neg3[Double](odd)

    assertTrue(notEven(1))
    assertFalse(notEven(2))
    assertFalse(notOdd(1.0))
    assertTrue(notOdd(2.0))
  }

  @Test def testCurrying(): Unit = {
    val p1_1 = predicate1(1)
    val p2_1 = p1_1(2)
    val p3_1 = p2_1(3)
    val p1_3: Double => Double => Boolean = predicate3(1)
    val p2_3: Double => Boolean = p1_3(2)
    val p3_3: Boolean = p2_3(3)

    assertTrue(p3_1)
    assertTrue(predicate1(1)(2)(3))
    assertTrue(p3_3)
    assertTrue(predicate3(1)(2)(3))
  }

  @Test def testCompose(): Unit = {
    assertEquals(9, compose(_-1, _*2)(5))
  }

  @Test def testComposeGeneric(): Unit = {
    assertEquals(9, composeG[Int](_-1, _*2)(5))
    assertEquals("ciao1ciao", composeG[String](_+"ciao", _+"1")("ciao"))
  }

}
