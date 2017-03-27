package com.ruchira

sealed trait Instruction

case class Move() extends Instruction
case class Place(position: Position) extends Instruction
case class Left() extends Instruction
case class Right() extends Instruction
case class Report() extends Instruction

case object Place
{
  val PREFIX = "Place"

  def parse(string: String): Place =
  {
    val lowerCasedString = string.trim.toLowerCase

    if(lowerCasedString.startsWith(PREFIX.toLowerCase))
      {
        val position = Position.parse(lowerCasedString.substring(PREFIX.length).trim)
        Place(position)
      }
    else
    {
      throw new Error(s"Unable to convert string to Place: ${string}")
    }
  }
}

object Instruction
{
  def perform(instruction: Instruction, position: Option[Position]): InstructionResult =
  {
    def moveToValidPosition(currentPosition: Position, nextPosition: Position): Position =
    {
      if(Position.isValidPosition(nextPosition))
      {
        nextPosition
      } else {
        currentPosition
      }
    }

    position match
    {
      case Some(validPosition) => instruction match
      {
        case Move() => Some(moveToValidPosition(validPosition, Position.move(validPosition)))
        case Right() => Some(Position.turnRight(validPosition))
        case Left() => Some(Position.turnLeft(validPosition))
        case Place(position) => Some(moveToValidPosition(validPosition, position))
        case Report() => InstructionResult(Some(validPosition), Some(validPosition.toString))
      }

      case None => instruction match
      {
        case Place(position) => if (Position.isValidPosition(position))
          {
            Some(position)
          } else {
            None
          }
        case Report() => {
          InstructionResult(None, Some("Toy Robot NOT on table-top."))
        }
        case _ => None
      }
    }
  }

  def parse(string: String): Instruction =
  {
    string.toLowerCase match
    {
      case "move" => Move()
      case "left" => Left()
      case "right" => Right()
      case "report" => Report()
      case instruction if instruction.startsWith(Place.PREFIX.toLowerCase) => Place.parse(instruction)
      case _ => throw new Error(s"Unable to convert string to Instruction: ${string}")
    }
  }
}