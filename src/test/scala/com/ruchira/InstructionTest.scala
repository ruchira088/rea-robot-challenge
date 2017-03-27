package com.ruchira

import org.scalatest.FunSpec

class InstructionTest extends FunSpec
{
  describe("Instruction")
  {
    it("parse(String): Instruction")
    {
      val testValues: List[TestData[String, Instruction]] = List(
        TestData("right", Right()),
        TestData("left", Left()),
        TestData("move", Move()),
        TestData("report", Report()),
        TestData("place 1,1,North", Place(Position(1, 1, North))),
        TestData("RIGHT", Right()),
        TestData("LEFT", Left()),
        TestData("MOVE", Move()),
        TestData("REPORT", Report()),
        TestData("PLACE 3, 1, SOUTH", Place(Position(3, 1, South)))
      )

      TestRunner.runTests(testValues, Instruction.parse)
    }

    it("perform(Instruction, Option[Position]): Option[Position]")
    {
      val testValues: List[TestData[(Instruction, Option[Position]), Option[Position]]] = List(
        TestData((Move(), Some(Position(0, 0, North))), Some(Position(0, 1, North))),
        TestData((Move(), Some(Position(4, 4, East))), Some(Position(4, 4, East))),
        TestData((Move(), Some(Position(4, 4, South))), Some(Position(4, 3, South))),
        TestData((Move(), Some(Position(1, 1, South))), Some(Position(1, 0, South))),
        TestData((Move(), Some(Position(0, 0, South))), Some(Position(0, 0, South))),
        TestData((Move(), None), None),
        TestData((Right(), Some(Position(0, 0, South))), Some(Position(0, 0, West))),
        TestData((Left(), Some(Position(0, 0, South))), Some(Position(0, 0, East))),
        TestData((Left(), None), None),
        TestData((Place(Position(0, 0, North)), Some(Position(1, 1, South))), Some(Position(0, 0, North))),
        TestData((Place(Position(1, 1, North)), None), Some(Position(1, 1, North))),
        TestData((Place(Position(5, 5, North)), None), None),
        TestData((Place(Position(5, 5, North)), Some(Position(0, 0, North))), Some(Position(0, 0, North)))
      )

      TestRunner.runTests[(Instruction, Option[Position]), Option[Position]](testValues, value =>
      {
        val (instruction, positionOption) = value
        Instruction.perform(instruction, positionOption)
      })
    }
  }
}
