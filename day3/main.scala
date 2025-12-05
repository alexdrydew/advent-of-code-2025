import scala.io.Source
import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer
import java.util.LinkedList
import scala.collection.mutable.ArrayDeque

def findLargestTwoDigitNum(s: String): Int = {
  val stack: Stack[Int] = Stack();
  var max = 0;
  for c <- s do {
    val digit = c.asDigit;

    stack.push(digit);
    if (stack.size <= 2) {
      max = Math.max(max, stack.reverse.mkString.toInt);
    }

    var top = stack.pop();
    while (stack.nonEmpty && stack.top < top) {
      if (stack.size < 2) {
        max = Math.max(max, (stack.reverse.mkString + c).toInt);
      }
      stack.pop();
    }
    stack.push(top);

    if (stack.size > 2) {
      stack.pop();
    }

    max = Math.max(max, stack.reverse.mkString.toInt);
  }
  max
}

def findLargestNDigitNum(s: String, n: Int): Long = {
  val buf: ListBuffer[Long] = ListBuffer();
  var max = 0L;
  for c <- s do {
    val digit = c.asDigit;
    buf.append(digit);
    if (buf.size > n) {
      var i = 1;
      while (i < buf.size && buf(i - 1) >= buf(i)) {
        i += 1;
      }
      if i < buf.size then {
        buf.remove(i - 1);
      } else {
        buf.remove(buf.size - 1);
      }
    }
    max = Math.max(max, buf.mkString.toLong);
  }
  max
}

@main
def main(part: String): Unit = {
  val banks = Source.fromFile("day3/input.txt").getLines();

  part match {
    case "part1" => {
      println(banks.map(findLargestTwoDigitNum).sum)
    }
    case "part2" => {
      println(banks.map(s => findLargestNDigitNum(s, 12)).sum)
    }
  }
}
