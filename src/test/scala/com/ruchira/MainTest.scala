package com.ruchira

import org.scalatest.FunSpec

class MainTest extends FunSpec
{
  describe("Main")
  {
    it("performInstructions(Option[Position], List[Instruction]): (Option[Position], List[String])")
    {
      val testValues: List[TestData[(Option[Position], List[Instruction]), (Option[Position], List[String])]] = List(
        TestData((None, List()), (None, List())),
        TestData((None, List(Place(Position(1, 1, West)))), (Some(Position(1, 1, West)), List())),
        TestData((None, List(
          Place(Position(1, 2, East)),
          Move(),
          Move(),
          Left(),
          Move(),
          Report()
        )), (Some(Position(3, 3, North)), List("3,3,NORTH"))),
        TestData((None, List(
          Place(Position(0, 0, East)),
          Move(),
          Report(),
          Move(),
          Left(),
          Move(),
          Report()
        )), (Some(Position(2, 1, North)), List("1,0,EAST", "2,1,NORTH"))),
        TestData((None, List(
          Place(Position(0, 0, North)),
          Move(),
          Report(),
          Move(),
          Report(),
          Move(),
          Move(),
          Move(),
          Move(),
          Report(),
          Right(),
          Report(),
          Move(),
          Report()
        )), (Some(Position(1, 4, East)), List("0,1,NORTH", "0,2,NORTH", "0,4,NORTH", "0,4,EAST", "1,4,EAST"))),
        TestData((None, List(
          Report(),
          Place(Position(1, 2, East)),
          Move(),
          Move(),
          Left(),
          Place(Position(5, 5, East)),
          Move(),
          Report()
        )), (Some(Position(3, 3, North)), List(Instruction.NOT_ON_TABLE_TOP, "3,3,NORTH")))
      )

      TestRunner.runTests[(Option[Position], List[Instruction]), (Option[Position], List[String])](testValues, input =>
      {
        val (position, instructions) = input
        Main.performInstructions(position, instructions)
      })
    }
  }
}
