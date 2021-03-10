package lab02

import lab02.Tasks4._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class Tasks4Test {

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
}

