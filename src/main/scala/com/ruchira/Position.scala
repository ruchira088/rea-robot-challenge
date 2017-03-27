package com.ruchira

case class Position(x: Int, y: Int, direction: Direction)
{
  override def toString: String = s"${x},${y},${direction.toString.toUpperCase}"
}

object Position
{
  val WIDTH = 5
  val HEIGHT = 5

  def move(position: Position): Position =
  {
    val Position(x, y, direction) = position

    direction match
    {
      case North => Position(x, y+1, North)
      case East => Position(x+1, y, East)
      case South => Position(x, y-1, South)
      case West => Position(x-1, y, West)
    }
  }

  def turnLeft(position: Position): Position =
  {
    val Position(x, y, direction) = position

    Position(x, y, Direction.turnLeft(direction))
  }

  def turnRight(position: Position): Position =
  {
    val Position(x, y, direction) = position

    Position(x, y, Direction.turnRight(direction))
  }

  def isValidPosition(position: Position, width: Int = WIDTH, height: Int = HEIGHT): Boolean =
  {
    def inRange(value: Int, max: Int): Boolean = 0 <= value && value < max

    val Position(x, y, _) = position

    inRange(x, width) && inRange(y, height)
  }

  def parse(string: String): Position =
  {
    val List(x, y, direction) = string.trim.split(",").toList.map(_.trim)

    Position(x.toInt, y.toInt, Direction.parse(direction))
  }
}
