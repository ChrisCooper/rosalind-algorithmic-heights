import _root_.runtime.RosalindSolution

object DoubleDegreeArray extends RosalindSolution {


  def problem_name: String = "ddeg"

  def get_answer(input_lines: Iterator[String]): String = {

    // Using an adjacency list for the graph would be better in this problem.
    // But matrices, right?
    val graph = parsed_edge_list(input_lines)

    val num_edges_array = graph.map{_.sum}

    val double_degree = graph.indices.map{ i: Int =>
      val neighbor_indicies = graph(i).indicesWhere{_ != 0}

      num_edges_array.atIndices(neighbor_indicies).sum
    }

    double_degree.mkString("\n")
  }
}
