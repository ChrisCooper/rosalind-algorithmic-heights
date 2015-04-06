import _root_.runtime.RosalindSolution

import scala.collection.mutable.ArrayBuffer

object MergeArrays extends RosalindSolution {

  def problem_name: String = "mer"

  def get_answer(input_lines: Iterator[String]): String = {
    // ignore metadata
    input_lines.next()
    val array1 = input_lines.next_as_array()

    // ignore metadata
    input_lines.next()
    val array2 = input_lines.next_as_array()

    val result = ArrayBuffer[Int]()

    var i1 = 0
    var i2 = 0
    while (i1 < array1.length && i2 < array2.length) {
      val elem1 = array1(i1)
      val elem2 = array2(i2)
      if (elem1 <= elem2) {
        result.append(elem1)
        i1 += 1
      } else {
        result.append(elem2)
        i2 += 1
      }
    }

    while (i1 < array1.length) {
      result.append(array1(i1))
      i1 += 1
    }
    while (i2 < array2.length) {
      result.append(array2(i2))
      i2 += 1
    }

    result.mkString(" ")
  }
}
