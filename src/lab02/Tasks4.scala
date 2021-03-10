package lab02

object Tasks4 {
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
}
