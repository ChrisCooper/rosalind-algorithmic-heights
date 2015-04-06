import _root_.runtime.RosalindSolution

import collection.mutable
import math.ceil

object MajorityElement extends RosalindSolution {

  def problem_name: String = "maj"

  def get_answer(input_lines: Iterator[String]): String = {

    // Ignore metadata
    val metadata = input_lines.next_as_array()
    val array_lengths = metadata(1)
    val threshold = ceil(array_lengths / 2.0)

    val arrays = input_lines.map{_.split("\\s").map{_.toInt}}

    val majority_elems = arrays.map{ arr =>
      val counts = mutable.Map[Int, Int]().withDefaultValue(0)

      var maj = -1
      for (i <- arr) {
        val new_count = counts(i) + 1
        counts.update(i, new_count)
        if (new_count > threshold) {
          maj = i
        }
      }
      maj
    }

    majority_elems.mkString(" ")
  }
}
