class GetRepeatedNumsSumTest extends munit.FunSuite:
  test("test 1") {
    assertEquals(
      getRepeatedNumsSum(
        1188511880,
        1188511890
      ),
      1188511885L
    );
  }

  test("test 2") {
    assertEquals(
      getRepeatedNumsSum(
        12001200,
        12011201
      ),
      12001200 + 12011201L
    );
  }

  test("test 3") {
    assertEquals(
      getRepeatedNumsSum(
        95,
        115
      ),
      99L
    );
  }

  test("test 4") {
    assertEquals(
      getRepeatedNumsSum(
        11,
        22
      ),
      11 + 22L
    );
  }

  test("test 5") {
    assertEquals(
      getRepeatedNumsSum(
        797927,
        798999
      ),
      798798L
    );
  }

  test("test 6") {
    assertEquals(
      getRepeatedNumsSum(
        307,
        1038
      ),
      1010L
    );
  }

  test("test odd") {
    assertEquals(
      getRepeatedNumsSum(
        422394377,
        422468141
      ),
      0L
    );
  }

  test("test odd 2") {
    assertEquals(
      getRepeatedNumsSum(
        100,
        1010
      ),
      1010L
    );
  }
