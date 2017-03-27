package com.ruchira

import org.scalatest.FunSpec

class DirectionTest extends FunSpec
{
  describe("Direction")
  {
    it("parse(String): Direction")
    {
      val testData: List[TestData[String, Direction]] = List(
        TestData("north", North),
        TestData("East", East),
        TestData("SOUTH", South),
        TestData("WeST", West)
      )

      TestRunner.runTests(testData, Direction.parse)
    }

    it("turnRight(Direction): Direction")
    {
      val testData: List[TestData[Direction, Direction]] = List(
        TestData(North, East),
        TestData(East, South),
        TestData(South, West),
        TestData(West, North)
      )

      TestRunner.runTests(testData, Direction.turnRight)
    }

    it("turnLeft(Direction): Direction")
    {
      val testData: List[TestData[Direction, Direction]] = List(
        TestData(North, West),
        TestData(West, South),
        TestData(South, East),
        TestData(East, North)
      )

      TestRunner.runTests(testData, Direction.turnLeft)
    }
  }
}
