import scala.io.Source
import scala.collection.mutable.HashMap
import scala.collection.mutable.TreeSet

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

class Cell(
    var neighbors: List[Cell],
    var occupiedNeighbors: Int = 0,
    val uid: Long = Cell.nextId()
) {
  def updateOccupiedNeighbors(): Unit = {
    occupiedNeighbors = neighbors.length;
  }
}

object Cell {
  private var counter = 0L
  private def nextId() =
    val n = counter
    counter += 1
    n
}

def buildField(rawCells: Array[Array['.' | '@']]): Array[Cell] = {
  var posToCell = HashMap[(Int, Int), Cell]();
  for i <- rawCells.indices do {
    for j <- rawCells(0).indices do {
      if rawCells(i)(j) == '@' then posToCell((i, j)) = Cell(List[Cell]());
    }
  };
  for i <- rawCells.indices do {
    for j <- rawCells(0).indices do {
      if rawCells(i)(j) == '@' then {
        val neighbors = for
          x <- -1 to 1;
          y <- -1 to 1
          if !(x == 0 && y == 0)
          cell <- posToCell.get((i + x, j + y))
        yield cell;
        posToCell((i, j)).neighbors = neighbors.toList
        posToCell((i, j)).updateOccupiedNeighbors()
      };
    };
  };

  posToCell.values.toArray
}

def simulateRollsCollection(cells: Array[Cell]): Int = {
  given Ordering[Cell] =
    Ordering.by[Cell, (Int, Long)](cell => (cell.occupiedNeighbors, cell.uid))

  var pq = TreeSet.from(cells);
  var cnt = 0;

  while pq.nonEmpty do {
    val cell = pq.head
    pq.remove(cell)

    if cell.occupiedNeighbors < 4 then {
      cnt += 1
      for neighbor <- cell.neighbors do {
        pq.remove(neighbor)
        neighbor.neighbors = neighbor.neighbors.filter(_ != cell)
        neighbor.updateOccupiedNeighbors()
        pq.add(neighbor)
      }
    } else {
      return cnt
    }
  }

  cnt
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
    case "part2" => {
      val cells = buildField(field)
      println(simulateRollsCollection(cells))
    }
  }
}
