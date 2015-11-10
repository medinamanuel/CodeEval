package org.mmg.codeeval.challenges

/**
 * Created by mmedina on 15/05/28.
 */
object PrimePalindrome {

  def isPrime(n: Int): Boolean = {
    !(2.to(Math.sqrt(n).toInt, 1)).exists(i => n % i == 0)
  }

  def isPalindrome(n: Int): Boolean = {
    val strN = n.toString
    strN == strN.reverse
  }

  def main(a: Array[String]): Unit = {
    val largestPrime = (1000.to(1,-1)).dropWhile{n =>
       !(isPrime(n) && isPalindrome(n))
    }.head

    println(largestPrime)
  }
}
