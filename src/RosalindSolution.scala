package runtime
import java.awt.datatransfer.StringSelection
import java.awt.Toolkit
import java.io.File
import scala.collection.JavaConverters._
import scala.io.Source

abstract class RosalindSolution extends App {

  override def main(args: Array[String]) {
    println("Running problem '%s'".format(problem_name))
    val answer = get_answer(input_file_lines())
    write_to_output_file(answer)
  }

  def problem_name: String
  def get_answer(input_lines: Iterator[String]): String

  def input_file_lines() =
    Source.fromFile("/home/chris/pro/rosalind-algorithmic-heights/input_files/rosalind_%s.txt".format(problem_name)).getLines()

  def write_to_output_file(str: String): Unit = {
    println("Writing to file:\n%s".format(str))

    val filename = "/home/chris/pro/rosalind-algorithmic-heights/output_files/rosalind_%s.txt".format(problem_name)
    val pw = new java.io.PrintWriter(new File(filename))
    try pw.write(str) finally pw.close()
    println("Finished writing to file:\n%s".format(filename))
  }

  def copy_to_clipboard(str: String) : Unit = {
    println("Copying to clipboard:\n%s".format(str))

    val stringSelection = new StringSelection(str)
    val clipboard = Toolkit.getDefaultToolkit.getSystemClipboard
    clipboard.setContents(stringSelection, null)

    println("Finished copying to clipboard")
  }

  /*
   * Graphs
   */
  def parsed_edge_list(input_lines: Iterator[String]): Array[Array[Int]] = {
    val graph_metadata = input_lines.next().split("\\s").map{_.toInt}
    val num_vertices = graph_metadata(0)

    val graph = Array.ofDim[Int](num_vertices, num_vertices)

    for ((from_i, to_i) <- input_lines.map(line_to_pair)) {
      graph(from_i)(to_i) = 1
      graph(to_i)(from_i) = 1
    }

    graph
  }

  def line_to_pair(line: String): (Int, Int) = {
    val parts = line.split("\\s").map{_.toInt - 1}
    assert(parts.length == 2)
    (parts(0), parts(1))
  }

  /*
   * Utilities
   */

  implicit class ArrayAdditions[T](a: Array[T]) {

    def indicesWhere(predicate: (T) => Boolean): Array[Int] = {
      a.indices.filter{(i: Int) => predicate(a(i))}.toArray
    }

    def atIndices(indices: Array[Int]): Iterable[T] = {
      for (index <- indices) yield { a(index) }
    }
  }

  implicit class StringIteratorAdditions[T](iterator: Iterator[String]) {
    def next_as_array(): Array[Int] = {
      iterator.next().split("\\s").map{_.toInt}
    }
  }

  implicit class StringAdditions[T](str: String) {
    def toIntArray(): Array[Int] = {
      str.split("\\s").map{_.toInt}
    }
  }
}
