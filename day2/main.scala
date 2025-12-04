import scala.io.Source
import scala.collection.mutable.HashMap

def getRepeatedTwiceInRangeSum(min: Long, max: Long): Long = {
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

def divCeil[T](a: T, b: T)(using num: Integral[T]): T =
  num.quot(num.plus(a, num.minus(b, num.one)), b)

def factorize(n: Long): Set[Int] = {
  var factors = Set[Int]();

  for i <- 1L to Math.sqrt(n).toLong do
    if n % i == 0 then {
      factors += i.toInt;
      factors += (n / i).toInt;
    }

  factors
}

def getRepeatedInRangeSum(min: Long, max: Long): Long = {
  val maxStr = max.toString;
  val minStr = min.toString;

  var sum = 0L;
  for numLength <- minStr.length to maxStr.length do
    var partLengths =
      factorize(numLength).filter(_ < numLength).toList.sorted.reverse

    def getRepeatedSum(repeatedPartLength: Int): Long = {
      var current = "1".padTo(repeatedPartLength, '0').toLong;
      val repeats = numLength / repeatedPartLength;

      var sum = 0L;

      var repeated = 0L;
      val currentMax = Math.min(
        "9".repeat(repeatedPartLength * repeats).toLong,
        max
      )

      while ({
        repeated = current.toString.repeat(repeats).toLong;
        repeated <= currentMax;
      }) {
        if repeated >= min then sum += repeated;
        current += 1;
      }

      sum
    };

    val partLengthToSum = HashMap.from(
      partLengths.map(i => i -> getRepeatedSum(i))
    )

    for factor <- partLengths.reverse do
      for multiple <- partLengths do
        if multiple % factor == 0 && multiple != factor then
          partLengthToSum(multiple) -= partLengthToSum(factor);

    sum += partLengthToSum.values.sum;
  sum
}

@main
def main(part: String): Unit = {
  val ranges = Source.fromFile("day2/input.txt").mkString.strip;
  val parts = ranges.split(",").map { r => r.split("-") };

  part match {
    case "part1" => {
      var sum = parts.map { case Array(min, max) =>
        getRepeatedTwiceInRangeSum(min.toLong, max.toLong)
      }.sum;
      println(sum);
    }
    case "part2" => {
      var sum = parts.map { case Array(min, max) =>
        getRepeatedInRangeSum(min.toLong, max.toLong)
      }.sum;
      println(sum);
    }
  }
}
