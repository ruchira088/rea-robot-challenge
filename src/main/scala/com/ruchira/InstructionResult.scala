package com.ruchira

case class InstructionResult(position: Option[Position], report: Option[String] = None)

object InstructionResult
{
  implicit def convert(position: Option[Position]): InstructionResult = InstructionResult(position)
}
