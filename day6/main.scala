import scala.io.Source

def solveProblems(
    lines: Seq[String]
): Long = {
  val nums = lines.init.map(_.split("\\s+").map(_.toLong).toSeq);
  val operations = lines.last.split("\\s+");

  val problems = nums.transpose;
  var sum = 0L;
  for ((operation, args) <- operations.zip(problems)) {
    val solution = operation match {
      case "*" => args.product;
      case "+" => args.sum;
      case _   => { throw new Exception(s"Unknown operation: $operation") }
    }
    sum += solution;
  };
  sum
}

def solveSingleCephalopodProblem(
    nums: Seq[String],
    operation: "+" | "*"
): Long = {
  var normalNums = nums.transpose.map(_.filter(_ != ' ').mkString.toLong);
  operation match {
    case "*" => normalNums.product;
    case "+" => normalNums.sum;
  }
}

def solveCephalopodProblems(
    lines: Seq[String]
): Long = {
  var offset = 0;
  var opIdx = 0;
  val operations = lines.last.split("\\s+");
  var sum = 0L;
  while offset < lines.init.map(_.length).max do {
    val symbols = for line <- lines.init if offset < line.length yield {
      line.charAt(offset);
    }
    if symbols.forall(_ == ' ') then {
      offset += 1;
    } else {
      var nextSpaceIndexes =
        lines.init
          .filter(_.charAt(offset) != ' ')
          .map(_.indexOf(' ', offset));
      var nextSpaceIdx =
        if nextSpaceIndexes.isEmpty || nextSpaceIndexes.min == -1 then -1
        else nextSpaceIndexes.max;

      var nums = for line <- lines.init yield {
        val endIdx =
          if nextSpaceIdx == -1 then line.length else nextSpaceIdx;
        line.substring(offset, endIdx);
      }
      val operation: "+" | "*" = operations(opIdx).match {
        case "+" => "+";
        case "*" => "*";
      }
      sum += solveSingleCephalopodProblem(nums, operation);
      offset =
        if nextSpaceIdx == -1 then lines.init.map(_.length).max
        else nextSpaceIdx;
      opIdx += 1;
    }
  }

  sum;
}

@main
def main(part: String): Unit = {
  val lines = Source
    .fromFile("day6/input.txt")
    .getLines()
    .toSeq;

  part match {
    case "part1" => {
      println(solveProblems(lines));
    }
    case "part2" => {
      println(solveCephalopodProblems(lines));
    }
  }
}
