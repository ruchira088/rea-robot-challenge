package com.ruchira

import com.ruchira.errors.ParseError

import scala.io.Source

object Main
{
  def main(args: Array[String]): Unit =
  {
    try
    {
      val fileContents = Source.fromFile("input.txt").getLines().toList
      val (_, report) = performInstructions(None, parseInputs(fileContents))

      report.foreach(println)
    }
    catch
    {
      case error: ParseError => System.err.println(error)
    }

  }

  def parseInputs(input: List[String]): List[Instruction] = input.map(Instruction.parse)

  def performInstructions(initialPosition: Option[Position], instructions: List[Instruction]): (Option[Position], List[String]) =
    instructions.foldLeft(initialPosition, List[String]())((output, instruction) =>
    {
      val (position, reports) = output
      val InstructionResult(result, report) = Instruction.perform(instruction, position)

      (result, if(report.isEmpty)
      {
        reports
      } else
      {
        reports ++ List(report.get)
      })
    })
}
