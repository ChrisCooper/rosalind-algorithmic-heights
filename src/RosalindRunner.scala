package runtime
import java.awt.datatransfer.StringSelection
import java.awt.Toolkit
import java.io.File
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
    val clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
    clipboard.setContents(stringSelection, null)

    println("Finished copying to clipboard")
  }
}