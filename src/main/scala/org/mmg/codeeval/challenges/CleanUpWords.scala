import scala.io.Source
package org.mmg.codeeval.challenges

object CleanUpWords {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (l => println("[A-Za-z]+".r.findAllIn(l).mkString(" ").toLowerCase))
  }

}
