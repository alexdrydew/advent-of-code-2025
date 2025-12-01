class CalculatePointingAtTest extends munit.FunSuite:
  test("Clockwise hits zero twice") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("R", 50),
          ("R", 50),
          ("R", 50),
          ("R", 50)
        ),
        50,
        100,
        0
      ),
      2
    );
  }

  test("Clockwise turns does not hit zero") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("R", 100),
          ("R", 100)
        ),
        50,
        100,
        0
      ),
      0
    );
  }

  test("Counterclockwise hits zero twice") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("L", 50),
          ("L", 50),
          ("L", 50),
          ("L", 50)
        ),
        50,
        100,
        0
      ),
      2
    );
  }

  test("Counterclockwise turns does not hit zero") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("L", 100),
          ("L", 100)
        ),
        50,
        100,
        0
      ),
      0
    );
  }

  test("Flickering around zero") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("R", 49),
          ("R", 1),
          ("L", 1),
          ("R", 1),
          ("L", 1),
          ("R", 1)
        ),
        50,
        100,
        0
      ),
      3
    );
  }

class CalculateTimesPassedZeroTest extends munit.FunSuite:
  test("Clockwise two full turns") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 100),
          ("R", 100)
        ),
        50,
        100
      ),
      2
    );
  }

  test("Clockwise one and a half turns") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 150)
        ),
        50,
        100
      ),
      2
    );
  }

  test("Counterclockwise two full turns") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("L", 100),
          ("L", 100)
        ),
        50,
        100
      ),
      2
    );
  }

  test("Counterclockwise one and a half turns") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("L", 150)
        ),
        50,
        100
      ),
      2
    );
  }

  test("Crossing zero multiple times") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 60), // 1, +10
          ("L", 120), // 2, 90
          ("R", 80), // 1, 70
          ("L", 200) // 2, 70
        ),
        50,
        100
      ),
      6
    );
  }

  test("Starting at zero") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 50),
          ("L", 150),
          ("R", 250)
        ),
        0,
        100
      ),
      4
    );
  }

  test("No crossings") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 30),
          ("L", 20),
          ("R", 40)
        ),
        10,
        100
      ),
      0
    );
  }

  test("Exact hits at zero") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("R", 90), // 1, 0
          ("L", 100), // 1, 0
          ("R", 200), // 2, 0
          ("R", 10), // 0, 10
          ("L", 10) // 1, 0
        ),
        10,
        100
      ),
      5
    );
  }

  test("Complex sequence") {
    assertEquals(
      calculateTimesPassedZero(
        List(
          ("L", 68), // 1, 82
          ("L", 30), // 0, 52,
          ("R", 48), // 1, 0
          ("L", 5), // 0, 95
          ("R", 60), // 1, 55
          ("L", 55), // 1, 0
          ("L", 1), // 0, 99
          ("L", 99), // 1, 0
          ("R", 14), // 0, 14
          ("L", 82) // 1, 32
        ),
        50,
        100
      ),
      6
    );
  }
