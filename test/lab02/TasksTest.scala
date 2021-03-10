package lab02

import lab02.Optionals.Option.getOrElse
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import lab02.Tasks._
import lab02.Optionals._
import lab02.Optionals.Option._

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

  @Test def testFib() {
    assertEquals(0, fibonacci(0))
    assertEquals(1,fibonacci(1))
    assertEquals(1,fibonacci(2))
    assertEquals(2,fibonacci(3))
    assertEquals(3,fibonacci(4))
    assertEquals(-1,fibonacci(-5))

    // tail recursion version:
    assertEquals(0, fib(0))
    assertEquals(1,fib(1))
    assertEquals(1,fib(2))
    assertEquals(2,fib(3))
    assertEquals(3,fib(4))
  }

  private val base = 1.2
  private val height = 2
  private val radius = 3
  private val side = 1.5
  private val expectedRectanglePerimeter = 6.4
  private val expectedRCirclePerimeter = 6 * math.Pi
  private val expectedSquarePerimeter = 6.0
  private val expectedRectangleArea = 2.4
  private val expectedRCircleArea = 9 * math.Pi
  private val expectedSquareArea = 2.25

  @Test def testShapePerimeter(): Unit = {
    assertEquals( expectedRectanglePerimeter, Shape.perimeter(Shape.Rectangle(base, height)))
    assertEquals(expectedRCirclePerimeter, Shape.perimeter(Shape.Circle(radius)))
    assertEquals(expectedSquarePerimeter, Shape.perimeter(Shape.Square(side)))
  }

  @Test def testShapeArea(): Unit = {
    assertEquals(expectedRectangleArea , Shape.area(Shape.Rectangle(base, height)))
    assertEquals(expectedRCircleArea, Shape.area(Shape.Circle(radius)))
    assertEquals(expectedSquareArea, Shape.area(Shape.Square(side)))
  }

  @Test def testOption():Unit = {
    val s1: Option[Int] = Some(1)
    val s2: Option[Int] = Some(2)
    val s3: Option[Int] = None()

    assertEquals(Some(1), s1)
    assertEquals(1, getOrElse(s1,0))
    assertEquals(0, getOrElse(s3,0))
    assertEquals(Some(2), flatMap(s1)(i => Some(i+1)))
    assertEquals(Some(3), flatMap(s1)(i => flatMap(s2)(j => Some(i+j))))
    assertEquals(None(), flatMap(s1)(i => flatMap(s3)(j => Some(i+j))))
  }

  @Test def testOptionFilter():Unit = {
    assertEquals(Some(5), filter[Int](Some(5))(_ > 2))
    assertEquals(None(), filter[Int](Some(5))(_ > 8))
  }

  @Test def testOptionMap():Unit = {
    assertEquals(Some(true), map(Some(5))(_ > 2))
    assertEquals(None(), map(None[Int]())(_ > 2))
    assertEquals(None(), map(None[Double]())(_ > 2))
    assertEquals(Some(5), map(Some(true))(_ => 5))
  }

  @Test def testOptionMap2():Unit = {
    val combination = (x: Int,y: Int) => x > y
    assertEquals(None(), map2(None(), Some(5), combination))
    assertEquals(None(), map2(Some(5), None(), combination))
    assertEquals(Some(false), map2(Some(2), Some(5), combination))
  }
}

