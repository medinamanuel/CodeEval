package org.mmg.codeeval.challenges

object Lowercase {

  import scala.io.Source

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(line.toLowerCase))
  }

}
