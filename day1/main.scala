import scala.io.Source

type Direction = "L" | "R";

def calculatePointingAtPosition(
    rotations: IterableOnce[(Direction, Int)],
    startingPosition: Int,
    rotationPeriod: Int,
    targetPosition: Int
): Int = {
  var position = startingPosition;
  var turns = 0;

  for ((direction, distance) <- rotations) {
    position += (if (direction == "L") -distance else distance);
    position = ((position % rotationPeriod) + rotationPeriod) % rotationPeriod;

    if position == targetPosition then {
      turns += 1;
    };
  }

  turns
}

def calculateTimesPassedZero(
    rotations: IterableOnce[(Direction, Int)],
    startingPosition: Int,
    rotationPeriod: Int
): Int = {
  var position = startingPosition;
  var turns = 0;

  for ((direction, distance) <- rotations) {
    val previousPosition = position;

    position += (if (direction == "L") -distance else distance);
    position = ((position % rotationPeriod) + rotationPeriod) % rotationPeriod;

    // full turns
    turns += distance / rotationPeriod

    // check if partial turn passed zero
    direction match {
      case "L" =>
        if (position > previousPosition || position == 0) && previousPosition != 0
        then turns += 1
      case "R" =>
        if position < previousPosition then turns += 1
    }
  }

  turns
}

val parseLine: String => Option[(Direction, Int)] = {
  case s"L$d" => Some("L", d.toInt)
  case s"R$d" => Some("R", d.toInt)
  case _      => None
}

@main
def solve(part: String): Unit = {
  val rotations =
    Source.fromFile("day1/input.txt").getLines().map(parseLine).map(_.get);

  part match {
    case "part1" =>
      val times = calculatePointingAtPosition(
        rotations,
        startingPosition = 50,
        rotationPeriod = 100,
        targetPosition = 0
      )

      println(times);
    case "part2" =>
      val position = calculateTimesPassedZero(
        rotations,
        startingPosition = 50,
        rotationPeriod = 100
      )

      println(position);
    case _ =>
      println("Unknown part")
  };
}
