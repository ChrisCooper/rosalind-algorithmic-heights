import _root_.runtime.RosalindSolution

object DegreeArray extends RosalindSolution {

  def problem_name: String = "deg"

  def get_answer(input_lines: Iterator[String]): String = {
    val graph_metadata = input_lines.next().split("\\s").map{_.toInt}
    val num_vertices = graph_metadata(0)

    val graph = Array.ofDim[Int](num_vertices, num_vertices)

    val edge_pairs = input_lines.map(line_to_pair)

    for ((from_i, to_i) <- edge_pairs) {
      graph(from_i)(to_i) = 1
      graph(to_i)(from_i) = 1
    }
    graph.map{_.sum}.mkString("\n")
  }

  def line_to_pair(line: String): (Int, Int) = {
    val parts = line.split("\\s").map{_.toInt - 1}
    assert(parts.length == 2)
    (parts(0), parts(1))
  }
}
