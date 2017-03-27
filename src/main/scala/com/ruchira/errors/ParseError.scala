package com.ruchira.errors

class ParseError(message: String) extends Error
{
  override def toString: String = message
}