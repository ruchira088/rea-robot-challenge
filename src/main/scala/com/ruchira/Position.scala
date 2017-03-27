package com.ruchira

case class Position(x: Int, y: Int, direction: Direction)
{
  override def toString: String = s"${x},${y},${direction.toString.toUpperCase}"
}

object Position
{
  /** Dimensions of the table-top */
  val WIDTH = 5
  val HEIGHT = 5

  /**
    * Move forward from the passed-in Position
    */
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

  /**
    * Turn left from the passed-in Position
    */
  def turnLeft(position: Position): Position =
  {
    val Position(x, y, direction) = position

    Position(x, y, Direction.turnLeft(direction))
  }

  /**
    * Turn right from the passed-in Position
    */
  def turnRight(position: Position): Position =
  {
    val Position(x, y, direction) = position

    Position(x, y, Direction.turnRight(direction))
  }

  /**
    * Checks if the Position is a valid position
    */
  def isValidPosition(position: Position, width: Int = WIDTH, height: Int = HEIGHT): Boolean =
  {
    def inRange(value: Int, max: Int): Boolean = 0 <= value && value < max

    val Position(x, y, _) = position

    inRange(x, width) && inRange(y, height)
  }

  /**
    * Converts a string to a Position
    */
  def parse(string: String): Position =
  {
    val List(x, y, direction) = string.trim.split(",").toList.map(_.trim)

    Position(x.toInt, y.toInt, Direction.parse(direction))
  }
}
