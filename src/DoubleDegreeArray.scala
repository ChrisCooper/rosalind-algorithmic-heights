import _root_.runtime.RosalindSolution

object DoubleDegreeArray extends RosalindSolution {


  def problem_name: String = "ddeg"

  def get_answer(input_lines: Iterator[String]): String = {
    val graph = parsed_edge_list(input_lines)

    graph.map{_.sum}.mkString("\n")
  }
}
