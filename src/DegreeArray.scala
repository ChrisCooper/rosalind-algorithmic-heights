import _root_.runtime.RosalindSolution

object DegreeArray extends RosalindSolution {

  def problem_name: String = "deg"

  def get_answer(input_lines: Iterator[String]): String = {
    val graph = parsed_edge_list(input_lines)

    graph.map{_.sum}.mkString("\n")
  }
}
