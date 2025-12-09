import scala.io.Source
import scala.collection.mutable.ListBuffer

def parseLines(
    lines: Iterator[String]
): (ListBuffer[(Long, Long)], ListBuffer[Long]) = {
  var intervals = ListBuffer[(Long, Long)]()
  var ingredients = ListBuffer[Long]()
  var part: "intervals" | "ingredients" = "intervals";

  for line <- lines do {
    if line.isEmpty then {
      part = "ingredients"
    } else {
      part match {
        case "intervals" => {
          val parts = line.split("-").map(_.toLong)
          intervals += ((parts(0), parts(1)))
        }
        case "ingredients" => {
          ingredients += line.toLong
        }
      }
    }
  }
  (intervals, ingredients)
}

def mergeIntervals(
    intervals: Seq[(Long, Long)]
): ListBuffer[(Long, Long)] = {
  val sortedLongervals = intervals.sortBy(_._1)
  var merged = ListBuffer[(Long, Long)]()

  for (current <- sortedLongervals) {
    if (merged.isEmpty || merged.last._2 < current._1) {
      merged += current
    } else {
      val last = merged.last
      merged.remove(merged.size - 1)
      merged += ((Math.min(last._1, current._1), Math.max(last._2, current._2)))
    }
  }
  merged
}

implicit val intervalOrdering: Ordering[(Long, Long)] =
  new Ordering[(Long, Long)] {
    override def compare(p: (Long, Long), interval: (Long, Long)): Int =
      if (interval._2 < p._1) 1
      else if (interval._1 > p._1) -1
      else 0
  }

def isContainedInInterval(
    intervals: Seq[(Long, Long)],
    ingredient: Long
): Boolean = {

  intervals.search((ingredient, ingredient)) match {
    case scala.collection.Searching.Found(_)          => true
    case scala.collection.Searching.InsertionPoint(_) => false
  }
}

@main
def main(part: String): Unit = {
  val field = Source
    .fromFile("day5/input.txt")
    .getLines();
  val (intervals, ingredients) = parseLines(field);

  val mergedLongervals = mergeIntervals(intervals.toSeq);

  part match {
    case "part1" => {
      println(
        ingredients.count(
          isContainedInInterval(mergedLongervals.toSeq, _)
        )
      );
    }
    case "part2" => {
      ???
    }
  }
}
