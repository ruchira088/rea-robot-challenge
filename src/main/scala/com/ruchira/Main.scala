package com.ruchira

import scala.io.Source

object Main
{
  def main(args: Array[String]): Unit =
  {
    val fileContents = Source.fromFile("input.txt").getLines().toList
    performInstructions(None, parseInputs(fileContents), println)
  }

  def parseInputs(input: List[String]): List[Instruction] = input.map(Instruction.parse)

  def performInstructions(initialPosition: Option[Position], instructions: List[Instruction], reportSink: String => Unit): Option[Position] =
    instructions.foldLeft(initialPosition)((position, instruction) => Instruction.perform(instruction, position, reportSink))

}
