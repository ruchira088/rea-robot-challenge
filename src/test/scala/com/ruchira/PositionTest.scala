package com.ruchira

import org.scalatest.FunSpec

class PositionTest extends FunSpec
{
  describe("Position")
  {
    it("parse(String): Position")
    {
      val testValues = List(
        TestData("0,0,north", Position(0, 0, North)),
        TestData("4, 2, EAST", Position(4, 2, East)),
        TestData("3,3,soUth", Position(3, 3, South))
      )

      TestRunner.runTests(testValues, Position.parse)
    }

    it("move(Position): Position")
    {
      val testValues = List(
        TestData(Position(0, 0, North), Position(0, 1, North)),
        TestData(Position(3, 1, West), Position(2, 1, West)),
        TestData(Position(2, 2, South), Position(2, 1, South)),
        TestData(Position(4, 3, East), Position(5, 3, East))
      )

      TestRunner.runTests(testValues, Position.move)
    }

    it("turnRight(Position): Position")
    {
      val testValues = List(
        TestData(Position(0, 0, North), Position(0, 0, East)),
        TestData(Position(1, 1, East), Position(1, 1, South)),
        TestData(Position(2, 2, South), Position(2, 2, West)),
        TestData(Position(3, 3, West), Position(3, 3, North))
      )

      TestRunner.runTests(testValues, Position.turnRight)
    }

    it("turnLeft(Position): Position")
    {
      val testValues = List(
        TestData(Position(0, 0, North), Position(0, 0, West)),
        TestData(Position(1, 1, West), Position(1, 1, South)),
        TestData(Position(2, 2, South), Position(2, 2, East)),
        TestData(Position(3, 3, East), Position(3, 3, North))
      )

      TestRunner.runTests(testValues, Position.turnLeft)
    }

    it("isValidPosition(Position): Boolean")
    {
      val testValues = List(
        TestData(Position(0, 0, North), true),
        TestData(Position(5, 5, West), false),
        TestData(Position(0, 5, East), false),
        TestData(Position(5, 0, South), false)
      )

      TestRunner.runTests(testValues, (input: Position) => Position.isValidPosition(input))
    }
  }
}
