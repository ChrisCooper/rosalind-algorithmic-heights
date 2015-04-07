import _root_.runtime.RosalindSolution

import collection.mutable

object TwoSum extends RosalindSolution {

  def problem_name: String = "2sum"

  def get_answer(input_lines: Iterator[String]): String = {

    // Ignore metadata
    input_lines.next()

    val indices = input_lines.map{_.toIntArray}.map(find_opposites)

    indices.map{_.mkString(" ")}.mkString("\n")
  }

  def find_opposites(arr: Array[Int]): Array[Int] = {
    val encountered = mutable.Map[Int, Int]()

    for ((e, i) <- arr.zipWithIndex) {
      val previous_index = encountered.get(-e)
      previous_index match {
        case Some(prev_i: Int) => return Array(prev_i + 1, i + 1)
        case _ => encountered += ((e, i))
      }
    }
    Array(-1)
  }
}
