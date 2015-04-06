import _root_.runtime.RosalindSolution

object InsertionSort extends RosalindSolution {

  def problem_name: String = "ins"

  def get_answer(input_lines: Iterator[String]): String = {
    input_lines.next() // skip number of lines entry
    val array = input_lines.next().split("\\s").map{_.toInt}

    var swaps_made = 0

    for (starting_index <- 1 to array.length - 1) {
      var current_position = starting_index
      while (current_position > 0 && array(current_position) < array(current_position - 1)) {
        swap(array, current_position, current_position - 1)
        swaps_made += 1
        current_position = current_position - 1
      }
    }
    println(array.mkString(" "))
    swaps_made.toString
  }

  def swap[T](array: Array[T], index1: Int, index2: Int): Unit = {
    val temp = array(index1)
    array(index1) = array(index2)
    array(index2) = temp
  }
}
