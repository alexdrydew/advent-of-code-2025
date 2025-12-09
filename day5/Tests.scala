class MergeIntervalsTest extends munit.FunSuite:
  test("test1") {
    assertEquals(
      mergeIntervals(Array[(Long, Long)]((1, 3), (2, 4), (5, 7), (6, 8))).toSeq,
      Seq[(Long, Long)]((1, 4), (5, 8))
    )
  }

  test("test2") {
    assertEquals(
      mergeIntervals(Array[(Long, Long)]((1, 5), (6, 10), (11, 15))).toSeq,
      Seq[(Long, Long)]((1, 5), (6, 10), (11, 15))
    )
  }

  test("test3") {
    assertEquals(
      mergeIntervals(
        Array[(Long, Long)]((1, 10), (2, 3), (4, 5), (6, 7))
      ).toSeq,
      Seq[(Long, Long)]((1, 10))
    )
  }

  test("test4") {
    assertEquals(
      mergeIntervals(Array[(Long, Long)]((1, 7), (3, 6), (4, 5))).toSeq,
      Seq[(Long, Long)]((1, 7))
    )
  }

class IsContainedInIntervalTest extends munit.FunSuite:
  val intervals = Array[(Long, Long)]((1, 4), (6, 10), (12, 15))

  test("contained1") {
    assertEquals(isContainedInInterval(intervals, 3), true)
  }

  test("contained2") {
    assertEquals(isContainedInInterval(intervals, 6), true)
  }

  test("not contained1") {
    assertEquals(isContainedInInterval(intervals, 5), false)
  }

  test("not contained2") {
    assertEquals(isContainedInInterval(intervals, 11), false)
  }
