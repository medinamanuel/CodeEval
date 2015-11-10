package org.mmg.codeeval.challenges
import scala.io.Source


object HighestScore {

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def getMaxScores(line: String) = {
    val rows = line.split("\\|").map(_.trim)
    val columns = rows.map(_.split("\\s"))

    columns.foldLeft(Array[Int]()){(currentMax, nextList) =>
      nextList.map(_.toInt).zipAll(currentMax,-1000,-1000).map{ case (a,b) => if (a > b) a else b}
    }
  }

  def main(a: Array[String]): Unit = {
    getLinesFromFile(a(0)) foreach (line => println(getMaxScores(line).mkString(" ")))
  }
}
