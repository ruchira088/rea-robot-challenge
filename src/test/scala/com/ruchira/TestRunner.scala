package com.ruchira

import org.scalatest.Assertions.assertResult

object TestRunner
{
  def runTests[A, B](values: List[TestData[A, B]], function: A => B) =
  {
    values.foreach(testData =>
    {
      assertResult(testData.expectedOutput)(function(testData.input))
    })
  }

}
