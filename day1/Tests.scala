class MyTests extends munit.FunSuite:
  test("Clockwise hits zero twice") {
    assertEquals(
      calculatePointingAtPosition(
        List(
          ("R", 25),
          ("R", 25),
          ("R", 25),
          ("R", 25)
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
        0,
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
          ("L", 25),
          ("L", 25),
          ("L", 25),
          ("L", 25)
        ),
        0,
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
