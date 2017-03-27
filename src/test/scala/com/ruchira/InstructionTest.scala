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
  }
}
