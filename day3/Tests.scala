class FindLargetstTwoDigitsTest extends munit.FunSuite:
  test("test 1") {
    assertEquals(
      findLargestTwoDigitNum("987654321111111"),
      98
    );
  }

  test("test 2") {
    assertEquals(
      findLargestTwoDigitNum("811111111111119"),
      89
    );
  }

  test("test 3") {
    assertEquals(
      findLargestTwoDigitNum("129"),
      29
    );
  }

  test("test 4") {
    assertEquals(
      findLargestTwoDigitNum("818181911112111"),
      92
    );
  }

class FindLargestNDigitNumTest extends munit.FunSuite:
  test("test 1") {
    assertEquals(
      findLargestNDigitNum("987654321111111", 3),
      987L
    );
  }

  test("test 2") {
    assertEquals(
      findLargestNDigitNum("811111111111119", 4),
      8119L
    );
  }

  test("test 3") {
    assertEquals(
      findLargestNDigitNum("129", 2),
      29L
    );
  }

  test("test 4") {
    assertEquals(
      findLargestNDigitNum("818181911112111", 5),
      92111L
    );
  }
