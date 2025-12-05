import scala.io.Source

def incrementNeighbors(
    cells: Array[Array[Int]],
    x: Int,
    y: Int
): Unit = {
  for i <- -1 to 1 do {
    for j <- -1 to 1 do {
      if (i == 0 && j == 0) then ()
      else {
        val newX = x + i;
        val newY = y + j;
        if (
          newX >= 0 && newX < cells.length && newY >= 0 && newY < cells(
            0
          ).length
        ) then {
          cells(newX)(newY) += 1;
        }
      }
    }
  }
}

def calculateNeighbors(
    cells: Array[Array['.' | '@']]
): Array[Array[Int]] = {
  val result = Array.fill(cells.length, cells(0).length)(0);
  for i <- cells.indices do {
    for j <- cells(0).indices do {
      if (cells(i)(j) == '@') then {
        incrementNeighbors(result, i, j);
      }
    }
  }
  result
}

def countLessThenNWithChar(
    cells: Array[Array['.' | '@']],
    cellsCount: Array[Array[Int]],
    charToCount: '.' | '@',
    n: Int
): Int = {
  var count = 0;
  for i <- cells.indices do {
    for j <- cells(0).indices do {
      if (cells(i)(j) == charToCount && cellsCount(i)(j) < n) then {
        count += 1;
      }
    }
  }
  count
}

def validateCell(field: Char): '.' | '@' = {
  field match {
    case '.' => '.'
    case '@' => '@'
    case _   => throw new Exception(s"Invalid cell character: $field")
  }
}

@main
def main(part: String): Unit = {
  val field = Source
    .fromFile("day4/input.txt")
    .getLines()
    .map[Array['.' | '@']](_.toCharArray().map(validateCell))
    .toArray;

  part match {
    case "part1" => {
      println(countLessThenNWithChar(field, calculateNeighbors(field), '@', 4))
    }
    case "part2" => {}
  }
}
