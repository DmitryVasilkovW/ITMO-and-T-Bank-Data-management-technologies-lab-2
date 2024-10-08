package fibonacci

import scala.annotation.tailrec

object Fibonacci {

  def fibonacci(limit: Long): BigInt =
    fibTailRec(limit, BigInt(0), BigInt(1))

  @tailrec
  private def fibTailRec(n: Long, a: BigInt, b: BigInt): BigInt =
    if (n == 0) a
    else fibTailRec(n - 1, b, a + b)

}
