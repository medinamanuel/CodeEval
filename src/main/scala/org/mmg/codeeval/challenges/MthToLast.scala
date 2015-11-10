package org.mmg.codeeval.challenges

import scala.io.Source


object MthToLast {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def processLine(line: String) {
    val inputs = line.split("\\s")
    val index = inputs(inputs.length - 1).toInt

    if (inputs.length - 1 - index >= 0) {
      println(inputs(inputs.length  - 1 - index))
    }

  }

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach processLine
  }
}
