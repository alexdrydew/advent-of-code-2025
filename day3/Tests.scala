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
