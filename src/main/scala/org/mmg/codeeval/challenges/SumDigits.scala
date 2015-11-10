package org.mmg.codeeval.challenges

object SumDigits {
  import scala.io.Source

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(line.map(_.toString.toInt).sum))
  }
}
