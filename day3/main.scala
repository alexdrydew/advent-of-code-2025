import scala.io.Source
import scala.collection.mutable.Stack

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

@main
def main(part: String): Unit = {
  val banks = Source.fromFile("day3/input.txt").getLines();

  part match {
    case "part1" => {
      println(banks.map(findLargestTwoDigitNum).sum)
    }
    case "part2" => {
      ???
    }
  }
}
