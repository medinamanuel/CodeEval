package org.mmg.codeeval.challenges

import scala.io.BufferedSource
import scala.io.Source._

/**
 * Created by mmedina on 15/05/29.
 */
object MultiplesOfNumber {

  private def die(msg: String): Unit = {
    println(msg)
    System.exit(1)
  }

  private def getLinesFromFile(fileToRead: String): (Seq[String], BufferedSource) = {
    val source = fromFile(fileToRead)
    (source.getLines.toSeq, source)
  }

  private def parseLine(line: String): (Int, Int) = {
    val numbers = line.split(",")

    (numbers(0).toInt, numbers(1).toInt)
  }

  private def closeSource(source: BufferedSource): Unit = {
    source.close
  }

  private def findSmallestMultiple(x: Int, n: Int): Int = {
    def loop(x: Int, n: Int, count: Int): Int = {
      if (n >= x)
        n
      else {
        loop(x, n * (count + 1), count + 1)
      }
    }

    loop(x, n, 1)

  }

  def main(a: Array[String]): Unit = {
    if (a.length < 1)
      die("Need a file to work with")

    val fileToRead = a(0)
    val (lines, source) = getLinesFromFile(fileToRead)

    val findMultiple = parseLine _ andThen (findSmallestMultiple _).tupled

    lines.filterNot(_.isEmpty) foreach {line => println(findMultiple(line))}

    closeSource(source)
  }


}
