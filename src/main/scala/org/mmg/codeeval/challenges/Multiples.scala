package org.mmg.codeeval.challenges

import scala.io.Source

object Multiples {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty).toList

  def processLine(line: String) = {
    val elements = line.split(",")
    val x = elements.head.toInt
    val n = elements(1).toInt

    Stream.from(n,n).dropWhile(_ < x).head

  }

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(processLine(line)))
  }
}
