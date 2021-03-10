package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import lab02.Optionals._
import lab02.Optionals.Option._

class OptionalsTest {

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

