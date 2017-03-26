package com.ruchira

import org.scalatest.FunSpec

class DirectionTest extends FunSpec
{
  describe("Direction")
  {
    val testData: List[TestData[String, Direction]] = List(
      TestData("north", North),
      TestData("East", East),
      TestData("SOUTH", South),
      TestData("WeST", West)
    )

    it("parse(String): Direction")
    {
      testData.foreach(data =>
      {
        assertResult(data.expectedOutput)(Direction.parse(data.input))
      })
    }
  }
}
