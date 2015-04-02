import _root_.runtime.RosalindSolution

/**
 * Created by chris on 02/04/15.
 */
object BinarySearch extends RosalindSolution {
  def problem_name: String = "bins"

  def get_answer(input_lines: Iterator[String]): String = {
    val search_pool_length = input_lines.next.toInt
    val num_queries = input_lines.next.toInt

    val pool = input_lines.next.split(" ").map{_.toInt}
    val queries = input_lines.next.split(" ").map{_.toInt}

    return queries.map{binary_search(_, pool)}.mkString(" ")
  }

  def binary_search(query: Int, pool: Array[Int]): Int = {
    var lower_bound = 0
    var upper_bound = pool.length

    while (lower_bound < upper_bound) {
      val test_i: Int = (lower_bound + upper_bound) / 2

      pool(test_i) match {
        case e if query > e => lower_bound = test_i + 1
        case e if query < e => upper_bound = test_i
        case _ => return test_i + 1 // question asks for 1 to N
      }
    }
    return -1
  }
}
