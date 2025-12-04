class GetRepeatedNumsSumTest extends munit.FunSuite:
  test("test 1") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        1188511880,
        1188511890
      ),
      1188511885L
    );
  }

  test("test 2") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        12001200,
        12011201
      ),
      12001200 + 12011201L
    );
  }

  test("test 3") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        95,
        115
      ),
      99L
    );
  }

  test("test 4") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        11,
        22
      ),
      11 + 22L
    );
  }

  test("test 5") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        797927,
        798999
      ),
      798798L
    );
  }

  test("test 6") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        307,
        1038
      ),
      1010L
    );
  }

  test("test odd") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        422394377,
        422468141
      ),
      0L
    );
  }

  test("test odd 2") {
    assertEquals(
      getRepeatedTwiceInRangeSum(
        100,
        1010
      ),
      1010L
    );
  }

class GetRepeatedInRangeSumTest extends munit.FunSuite:
  test("test 1") {
    assertEquals(
      getRepeatedInRangeSum(
        998,
        1012
      ),
      999 + 1010L
    );
  }

  test("test 2") {
    assertEquals(
      getRepeatedInRangeSum(
        1200,
        2222
      ),
      1212L + 1313L + 1414L + 1515L + 1616L + 1717L + 1818L + 1919L + 2020L + 2121L + 2222L
    );
  }

  test("test 3") {
    assertEquals(
      getRepeatedInRangeSum(
        1188511880,
        1188511890
      ),
      1188511885L
    );
  }

  test("test 4") {
    assertEquals(
      getRepeatedInRangeSum(
        115,
        282
      ),
      222L
    );
  }

  test("test 5") {
    assertEquals(
      getRepeatedInRangeSum(
        422394377,
        422468141
      ),
      422422422L
    );
  }

  test("test 6") {
    assertEquals(
      getRepeatedInRangeSum(
        2244,
        5558
      ),
      3333 + 4444 + 5555L
        + 2323 + 2424 + 2525 + 2626 + 2727 + 2828 + 2929 + 3030 + 3131
        + 3232 + 3434 + 3535 + 3636 + 3737 + 3838 + 3939 + 4040 + 4141
        + 4242 + 4343 + 4545 + 4646 + 4747 + 4848 + 4949 + 5050 + 5151
        + 5252 + 5353 + 5454
    );
  }

  test("test 7") {
    assertEquals(
      getRepeatedInRangeSum(
        5,
        100
      ),
      11L + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99L
    );
  }

  test("test 8") {
    assertEquals(
      getRepeatedInRangeSum(
        0,
        9
      ),
      0L
    );
  }

  test("test 9") {
    assertEquals(
      getRepeatedInRangeSum(
        10000000,
        12121212L
      ),
      (1000 to 1212).map(i => i.toString.repeat(2).toLong).sum
    );
  }
