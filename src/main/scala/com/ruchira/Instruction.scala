package com.ruchira

sealed trait Instruction

case class Move() extends Instruction
case class Place(position: Position) extends Instruction
case class Left() extends Instruction
case class Right() extends Instruction
case class Report() extends Instruction

object Instruction
{
  def perform(instruction: Instruction, position: Option[Position]): Option[Position] =
  {
    def moveToValidPosition(currentPosition: Position, nextPosition: Position): Position =
    {
      if(Position.isValidPosition(nextPosition))
      {
        nextPosition
      }
      else
      {
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
      }

      case None => instruction match
      {
        case Place(position) => if (Position.isValidPosition(position))
          {
            Some(position)
          }
          else
          {
            None
          }
        case _ => None
      }
    }

  }

}