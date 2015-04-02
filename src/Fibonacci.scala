/**
 * Created by chris on 29/03/15.
 */
package FIBO

import _root_.runtime.RosalindSolution

object Fibonacci extends RosalindSolution {

  override def problem_name: String = "fibo"

  override def get_answer(input_lines: Iterator[String]): String = {
    fib(input_lines.next.toInt).toString
  }

  def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case iters => {
      var a = 0
      var b = 1
      for (i <- 2 to iters) {
        val sum = a + b
        a = b
        b = sum
      }
      b
    }
  }
}
