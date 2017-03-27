package com.ruchira

import com.ruchira.errors.ParseError

sealed trait Direction

case object North extends Direction
case object East extends Direction
case object South extends Direction
case object West extends Direction

object Direction
{
  val DIRECTION_LIST: List[Direction] = List(North, East, South, West)

  /**
    * Turn right from the passed-in Direction
    */
  def turnRight(direction: Direction): Direction =
  {
    val index = DIRECTION_LIST.indexOf(direction) + 1

    if (DIRECTION_LIST.length > index) {
      DIRECTION_LIST(index)
    } else {
      DIRECTION_LIST.head
    }
  }

  /**
    * Turn left from the passed-in Direction
    */
    def turnLeft(direction: Direction): Direction =
    {
      val index = DIRECTION_LIST.indexOf(direction) - 1

      if(index < 0)
      {
        DIRECTION_LIST.reverse.head
      } else {
        DIRECTION_LIST(index)
      }
    }

  /**
    * Convert a string to a Direction
    */
    def parse(string: String): Direction =
    {
      string.toLowerCase match
      {
        case "north" => North
        case "east" => East
        case "south" => South
        case "west" => West
        case _ => throw new ParseError(s"Unable to convert string to Direction: ${string}")
      }
    }
}
