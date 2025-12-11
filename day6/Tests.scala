class SolveProblemsTest extends munit.FunSuite:
  test("test1") {
    assertEquals(
      solveProblems(
        Seq(
          "1 2 3",
          "4 5 6",
          "+ * +"
        )
      ),
      1 + 4 + 2 * 5 + 3 + 6L
    );
  }

class SolveCephalopodProblemsTest extends munit.FunSuite:
  test("test1") {
    assertEquals(
      solveCephalopodProblems(
        Seq(
          "123 328  51 64 ",
          " 45 64  387 23 ",
          "  6 98  215 314",
          "*   +   *   +  "
        )
      ),
      1 * 24 * 356 + 369 + 248 + 8 + 32 * 581 * 175 + 623 + 431 + 4L
    );
  }
