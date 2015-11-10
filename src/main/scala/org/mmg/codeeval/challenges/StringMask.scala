package org.mmg.codeeval.challenges

import scala.io.Source

object StringMask {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty).toList

  def processLine(line: String) = {
    val elements = line.split("\\s").toList
    val word = elements(0)
    val binaryCode = elements(1)

    word.toCharArray zip binaryCode.toCharArray map {case (c, b) =>
      if (b == '1')
        c.toUpper
      else
        c
    }

  }

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(new String(processLine(line))))
  }

}
