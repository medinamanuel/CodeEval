package org.mmg.codeeval.challenges

import scala.annotation.tailrec
import scala.io.Source

object StringArrows {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def countArrowsInString(str: String): Int = {
    val pattern = "<--<<|>>-->".r

    @tailrec
    def findAndCount(substr: String, n: Int): Int = {
      pattern.findFirstMatchIn(substr) match {
        case Some(m) => findAndCount(substr.substring(m.end - 1), n + 1)
        case _ => n
      }
    }

    findAndCount(str,0)
  }

  def main (a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach {l => println(countArrowsInString(l))}
  }
}
