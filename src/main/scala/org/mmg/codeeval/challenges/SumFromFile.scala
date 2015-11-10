package org.mmg.codeeval.challenges

object SumFromFile {
  import scala.io.Source

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def main(a: Array[String]): Unit = {
    (getLinesFromFile _ andThen (lines => println(lines.map(_.toInt).sum))).apply(a(0))
  }
}
