import scala.io.Source

def getRepeatedNumsSum(min: Long, max: Long): Long = {
  val minStr = min.toString;
  val length = minStr.length;

  var half = length match {
    case l if l % 2 == 0 => minStr.slice(0, l / 2).toLong
    case l               => ("1" + "0".repeat(l / 2)).toLong
  };

  var repeated = 0L;
  var sum = 0L;
  while ({
    repeated = half.toString.repeat(2).toLong;
    repeated <= max
  }) {
    if repeated >= min then sum += repeated;
    half += 1;
  };
  sum
}

@main
def main(): Unit = {
  val ranges = Source.fromFile("day2/input.txt").mkString.strip;
  val parts = ranges.split(",").map { r => r.split("-") };
  var sum = parts.map { case Array(min, max) =>
    getRepeatedNumsSum(min.toLong, max.toLong)
  }.sum;
  println(sum);
}
