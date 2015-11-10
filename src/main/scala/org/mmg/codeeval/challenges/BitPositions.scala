package org.mmg.codeeval.challenges

import scala.io.Source

object BitPositions {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def processLine(line: String) = {
    val elements = line.split(",")
    val n = elements.head.toInt.toBinaryString
    val p1 = elements(1).toInt
    val p2 = elements(2).toInt

    n(n.length-p1) == n(n.length-p2)

  }

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(processLine(line)))
  }

}
