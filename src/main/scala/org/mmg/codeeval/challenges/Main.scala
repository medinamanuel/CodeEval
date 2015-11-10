package org.mmg.codeeval.challenges

import scala.io.BufferedSource
import scala.io.Source._

object Main {

  val X_LOWER_LIMIT = 1
  val X_UPPER_LIMIT = 20
  val Y_LOWER_LIMIT = 1
  val Y_UPPER_LIMIT = 20
  val N_LOWER_LIMIT = 21
  val N_UPPER_LIMIT = 100

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

  private def parseLine(line: String): (Int, Int, Int) = {
    val valsInLine = line.split("\\s")
    (valsInLine(0).toInt, valsInLine(1).toInt, valsInLine(2).toInt)
  }

  private def validateNumber(number: Int, lowerLimit: Int, upperLimit: Int): Option[Int] = number match {
    case n if n >= lowerLimit && n <= upperLimit => Option(n)
    case _ => None
  }

  private def validateValues(x: Int, y: Int, n: Int): Option[(Int,Int,Int)] =  for {
    validatedX <- validateNumber(x,X_LOWER_LIMIT,X_UPPER_LIMIT)
    validatedY <- validateNumber(y,Y_LOWER_LIMIT,Y_UPPER_LIMIT)
    validatedN <- validateNumber(n,N_LOWER_LIMIT,N_UPPER_LIMIT)
  } yield (validatedX, validatedY, validatedN)

  private def theFizzBuzz(x: Int, y: Int, n: Int): Option[String] = {
    val stringToPrint = (1 to n).map {i =>
      i match {
        case a if a % x == 0 && a % y == 0 => "FB"
        case b if b % y == 0 => "B"
        case c if c % x == 0 => "F"
        case _ => i.toString
      }
    }.toList.mkString(" ")

    Option(stringToPrint)
  }

  private def printFizzBuzzResult(result: String): Option[Unit] = {
    println(result)
    Option.empty[Unit]
  }


  def main(a: Array[String]): Unit = {

    if (a.length < 1)
      die("Need a file to work with")

    val fileToRead = a(0)
    val (lines, source) = getLinesFromFile(fileToRead)

    if (lines.length > 20) {
      closeSource(source)
      die("Test cases must be 20 at most")
    }

    val processAndValidate = parseLine _ andThen (validateValues _).tupled
    val fizzBuzz = (theFizzBuzz _).tupled

    lines foreach {line => processAndValidate(line) flatMap fizzBuzz flatMap printFizzBuzzResult}

    closeSource(source)

  }


}
