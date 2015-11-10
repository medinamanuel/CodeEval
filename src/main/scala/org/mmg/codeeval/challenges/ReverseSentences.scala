package org.mmg.codeeval.challenges

import scala.io.BufferedSource
import scala.io.Source._

/**
 * Created by mmedina on 15/05/29.
 */
object ReverseSentences {

  private def die(msg: String): Unit = {
    println(msg)
    System.exit(1)
  }

  private def getLinesFromFile(fileToRead: String): (Seq[String], BufferedSource) = {
    val source = fromFile(fileToRead)
    (source.getLines.toSeq, source)
  }

  private def closeSource(source: BufferedSource): Unit = {
    source.close
  }

  private def reverseSentence(sentence: String): String = {
    sentence.split("\\s").foldLeft(""){(acc, word) =>
      word + " " + acc
    }
  }

  def main(a: Array[String]): Unit = {

    if (a.length < 1)
      die("Need a file to work with")

    val fileToRead = a(0)
    val (lines, source) = getLinesFromFile(fileToRead)

    lines.filterNot(_.isEmpty) foreach {sentence => println(reverseSentence(sentence)) }

    closeSource(source)

  }

}
