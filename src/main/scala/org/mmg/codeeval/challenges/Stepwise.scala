package org.mmg.codeeval.challenges

import scala.io.Source

object Stepwise {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty).toList

  def getWordsInLine(line: String) = line.split("\\s").toList

  def sortByLength(wordList: List[String]) = wordList.sortWith(_.length > _.length)

  def buildPrintableString(word: String) = {
    word.toCharArray.zipWithIndex.map { case (c, i) => ("*" * i) + c}.mkString(" ")
  }

  def main(a: Array[String]): Unit = {
    val getPrintableString = getWordsInLine _ andThen sortByLength andThen {_.head} andThen buildPrintableString
    getLinesFromFile(a(0)) foreach (line => println(getPrintableString(line)))
  }


}
