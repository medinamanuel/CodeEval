import scala.io.Source
import scala.math.min
import scala.math.abs

object SNSize {

  /*def editDist[A](a: Iterable[A], b: Iterable[A]) =
    (0 to b.size).toList.foldLeft(a){(prev, x) =>
      (prev zip prev.tail zip b).scanLeft(prev.head + 1) {
        case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
      }
    } last

  def getLinesFromFile(path: String) = Source.fromFile(path).getLines().filterNot(_.isEmpty)

  def splitTestsAndWordList(it: Seq[String]) = {
    val splits = it.span(_ != "END OF INPUT")
    (splits._1, splits._2.tail)
  }

  def snSize(testCases: Seq[String], wordList: Seq[String]) = {

    testCases foreach {test =>

      val c = wordList.foldLeft(0){case (count, word) =>
        if (abs(word.length - test.length) > 1)
          count
        else {
          if (editDist(word, test) > 1)
            count
          else
            count + 1
        }

      }

      println(c)
    }


  }

  def main(a: Array[String]): Unit = {
    val a = Seq("rec", "yellow", "green", "block", "END OF INPUT", "red", "clock", "glock", "ja")

    val (testCases, wordList) = splitTestsAndWordList(a)

    snSize(testCases, wordList)

  }*/
}
