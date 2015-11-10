package org.mmg.codeeval.challenges

import scala.annotation.tailrec

/**
 * Created by mmedina on 15/05/29.
 */
object SumOfPrimes {

  def isPrime(n: Int): Boolean = {
    !(2.to(Math.sqrt(n).toInt, 1)).exists(i => n % i == 0)
  }

@tailrec
  def findAndSum(nextToSearch: Int, primesFound: Int, prevResult: Int): Int = {
    if (primesFound == 1000)
      prevResult
    else {
      val nextPrime = Stream.from(nextToSearch).dropWhile(!isPrime(_)).head
      val nextResult =  nextPrime + prevResult
      findAndSum(nextPrime + 1, primesFound + 1, nextResult)
    }
  }

  def main(a: Array[String]): Unit = {
    println(findAndSum(2,0,0))
  }

}
